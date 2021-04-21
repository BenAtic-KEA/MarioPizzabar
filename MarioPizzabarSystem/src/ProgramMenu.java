import java.io.FileNotFoundException;

public class ProgramMenu {

    public static void main(String[] args) throws FileNotFoundException {
        // Indlæs menukort fra CSV-fil.
        PizzaMenu.listOfPizzas();
        // Indlæs ordrehistorik fra CSV-fil.
        SaveLoad.loadOrderList("MarioPizzabarSystem/OrderListSaves/Orderlist.csv");

        // Start program-loop.
        while (true) {
            displayMenu();
            int menuChoice = InputController.getMenuChoice();

            // Opret ny ordre.
            if (menuChoice == 1) {
                OrderController.createOrder();
            }
            // Rediger ordre.
            else if (menuChoice == 2) {
                OrderController.editOrder();
            }
            // Markér ordre som "completed".
            else if (menuChoice == 3) {
                OrderController.completeOrder();
            }
            // Vis pizzamenu.
            else if (menuChoice == 4) {
                PizzaMenu.displayMenu();
            }
            // Vis aktive ordre ("completed" = false).
            else if (menuChoice == 5) {
                OrderController.showActiveOrders();
            }
            else if (menuChoice == 6) {
                OrderController.showAllOrders();
            }
            // Vis statistik.
            else if (menuChoice == 7) {
                System.out.println("[1] - Vis indtjening. ");
                System.out.println("[2] - Vis antal solgte pizzaer.");
                int subMenuChoice = InputController.getMenuChoice(1, 2);

                if (subMenuChoice == 1) {
                    Statistics.showTotalRevenue();
                } else if (subMenuChoice == 2) {
                    Statistics.showNumberOfEachPizza();
                }
            } else {
                // Hvis ikke vi har et menupunkt, der svarer til menuChoice, throw.
                throw new IllegalStateException("Uforventet værdi: " + menuChoice);
            }
        }
    }

    public static void displayMenu() {
        System.out.println("Marios Pizzeria");
        System.out.println("------------------------");
        System.out.println("[1] - Opret ny ordre.");
        System.out.println("[2] - Rediger ordre.");
        System.out.println("[3] - Afslut ordre.");
        System.out.println("------------------------");
        System.out.println("[4] - Vis menu.");
        System.out.println("[5] - Vis uafsluttede ordre.");
        System.out.println("[6] - Vis ordre historie.");
        System.out.println("[7] - Vis statistik.");
    }
}