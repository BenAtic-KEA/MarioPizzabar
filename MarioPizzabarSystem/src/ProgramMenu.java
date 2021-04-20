import java.io.FileNotFoundException;

public class ProgramMenu {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO "FileNotFoundException" kan forekomme, skal den håndteres? (eks. brugervenlig fejlbesked hvis filerne ikke findes)
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
                System.out.println("[1] - Show revenue. ");
                System.out.println("[2] - Show pizza statistics. ");
                int subMenuChoice = InputController.getMenuChoice(1, 2);

                if (subMenuChoice == 1) {
                    Statistics.showTotalRevenue(); // TODO "showTotalRevenue" tæller uafsluttede ordrer.
                } else if (subMenuChoice == 2) {
                    Statistics.showNumberOfEachPizza();
                }
            } else {
                // Hvis ikke vi har et menupunkt, der svarer til menuChoice, throw.
                throw new IllegalStateException("Unexpected value: " + menuChoice);
            }
        }
    }

    public static void displayMenu() {
        System.out.println("Marios Pizzeria");
        System.out.println("------------------------");
        System.out.println("[1] - Create new order.");
        System.out.println("[2] - Edit order.");
        System.out.println("[3] - Complete order.");
        System.out.println("------------------------");
        System.out.println("[4] - Show menu.");
        System.out.println("[5] - Show incomplete orders.");
        System.out.println("[6] - Show order history.");
        System.out.println("[7] - Show statistics.");
    }
}