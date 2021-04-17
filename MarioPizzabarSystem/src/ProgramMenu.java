import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class ProgramMenu {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        // Indlæs menukort fra CSV-fil
        PizzaMenu.listOfPizzas(); // TODO exception kan forekomme, skal den håndteres? (eks. brugervenlig besked hvis menu ikke findes)

        // Start program-loop.
        while (true) {
            displayMenu();
            int menuChoice = getMenuChoice(); // TODO ugyldige valg kan forekomme, skal de håndteres?

            // Opret ny ordre.
            if (menuChoice == 1) {
                OrderList.newOrder();
                // Beregn ordreId ud fra længden af "theOrderList". TODO ID til ordre, mangler referencepunkt. Lige nu skal vi selv holde styr på ordreID, baseret på indeks i arrayliste
                int orderID = OrderList.getTheOrderList().size() - 1;
                System.out.println("Created order: " + OrderList.getOrder(orderID).toString());
            }
            // Rediger ordre.
            else if (menuChoice == 2) {
                System.out.println("To edit order, type order ID: ");
                int orderID = sc.nextInt();
                OrderList.editOrderLine(orderID); // TODO "editOrderLine" mangler at få implementeret redigeringsmuligheder
            }
            // Markér ordre som "completed".
            else if (menuChoice == 3) {
                System.out.println("To complete order, type order ID: ");
                int orderID = sc.nextInt();
                OrderList.getOrder(orderID - 1).setCompleted(true); // Jeg korrigerer ofte for -1, kan vi lægge det ind i klassen?
            }
            // Vis pizzamenu.
            else if (menuChoice == 4) {
                PizzaMenu.displayMenu();
            }
            // Vis aktive ordre ("completed" = false).
            else if (menuChoice == 5) {
                List<Order> theOrderList = OrderList.getTheOrderList();
                for (int i = 0; i < theOrderList.size(); i++) {
                    Order order = theOrderList.get(i);
                    if (order.isCompleted()) {
                        continue;
                    }
                    OrderList.displayOrder(i);
                }
            }
            // Vis statistik.
            else if (menuChoice == 6) {
                System.out.println("[1] - Show revenue. ");
                System.out.println("[2] - Show pizza statistics. ");
                int subMenuChoice = sc.nextInt();

                if (subMenuChoice == 1) {
                    Statistics.showTotalRevenue(); // TODO "showTotalRevenue" tæller uafsluttede ordrer + vi skal have gemt til fil, for at gemme ordrer
                } else if (subMenuChoice == 2) {
                    Statistics.showNumberOfEachPizza(); // TODO "showNumberOfEachPizza" tæller uafsluttede ordrer + vi skal have gemt til fil, for at gemme ordrer
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
        System.out.println("[5] - Show order list.");
        System.out.println("[6] - Show statistics.");
    }

    public static int getMenuChoice() {
        int userInput = sc.nextInt();
        return userInput;
    }
}