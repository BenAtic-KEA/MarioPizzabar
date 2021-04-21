import java.io.FileNotFoundException;
import java.util.List;

public class OrderController {

    public static void createOrder() throws FileNotFoundException {
        // Opret ny ordre via "OrderList", der står for at initialisere ordre-objektet og tilføje det til "theOrderList" (den interne ArrayList af ordrer).
        Order newOrder = OrderList.newOrder();

        // Gem den nyoprettede ordre med det samme, så Alfonzo ikke skal huske at gøre det løbende.
        SaveLoad.saveOrderList("MarioPizzabarSystem/OrderListSaves/Orderlist.csv");

        // Udskriv ordren, så Alfonzo kan se den.
        System.out.println("Lav ny ordre: \n" + newOrder.toString());
    }

    public static void editOrder() throws FileNotFoundException {
        System.out.println("Indtast ordreID: ");
        int orderID = InputController.getOrderId();

        Order orderToEdit = OrderList.getOrder(orderID);
        System.out.println("Redigér ordre: " + orderToEdit.getOrderID());
        System.out.println("------------------------");
        System.out.println("[1] - Tilføj ordrelinje ");
        System.out.println("[2] - Fjern ordrelinje ");

        int subMenuChoice = InputController.getMenuChoice(1, 2);
        if (subMenuChoice == 1) {
            orderToEdit.addOrderLine();
        } else if (subMenuChoice == 2) {
            orderToEdit.removeOrderLine();
        }

        // Gem den opdaterede ordre.
        SaveLoad.saveOrderList("MarioPizzabarSystem/OrderListSaves/Orderlist.csv");
    }

    public static void completeOrder() throws FileNotFoundException {
        System.out.println("Afslut ordre, indtast ordre ID: ");
        int orderID = InputController.getOrderId();
        Order orderToComplete = OrderList.getOrder(orderID);
        orderToComplete.setCompleted(true);
        // Gem den opdaterede ordre.
        SaveLoad.saveOrderList("MarioPizzabarSystem/OrderListSaves/Orderlist.csv");

    }

    public static void showActiveOrders() {
        // Hent listen af ordrer fra "orderList".
        List<Order> theOrderList = OrderList.getTheOrderList();

        // Gennemløb listen af ordrer.
        for (int i = 0; i < theOrderList.size(); i++) {
            // Hent ordren med index "i" fra listen.
            Order currentOrder = theOrderList.get(i);

            // Spring ordren over hvis den er gennemført.
            if (currentOrder.isCompleted()) {
                continue;
            }

            // Udskriv ordren, hvis den ikke er færdig.
            System.out.println(currentOrder.toString());
        }
    }

    public static void showAllOrders() {
        // Hent listen af ordrer fra "orderList".
        List<Order> theOrderList = OrderList.getTheOrderList();

        // Gennemløb listen af ordrer.
        for (int i = 0; i < theOrderList.size(); i++) {
            // Hent ordren med index "i" fra listen.
            Order currentOrder = theOrderList.get(i);

            // Udskriv ordren, hvis den ikke er færdig.
            System.out.println(currentOrder.toString());
        }
    }
}
