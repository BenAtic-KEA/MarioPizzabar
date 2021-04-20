import java.io.FileNotFoundException;
import java.util.List;

public class OrderController {
    public static void createOrder() throws FileNotFoundException {
        // Opret ny ordre via "OrderList", der står for at initialisere ordre-objektet og tilføje det til "theOrderList" (den interne ArrayList af ordrer).
        OrderList.newOrder();

        // "newOrder" returnerer ikke det nyoprettede ordre-objekt, så derfor henter vi det fra "theOrderList" - samtidig med at vi beregner ordre ID'et.
        // Alternativ implementering: Order newOrder = OrderList.newOrder();
        Order newOrder = OrderList.getOrder(OrderList.getTheOrderList().size() - 1);

        // Gem den nyoprettede ordre med det samme, så Alfonzo ikke skal huske at gøre det løbende.
        SaveLoad.saveOrderList("MarioPizzabarSystem/OrderListSaves/OrderListSaveTest.csv");
        // Udskriv ordren, så Alfonzo kan se den.
        System.out.println("Created order: " + newOrder.toString());
    }

    public static void editOrder() throws FileNotFoundException {
        System.out.println("To edit order, type order ID: ");
        int orderID = inputController.getOrderId();

        Order orderToEdit = OrderList.getOrder(orderID);
        System.out.println("Editing order: " + orderToEdit.getOrderID());
        System.out.println("------------------------");
        System.out.println("[1] - Add order line. ");
        System.out.println("[2] - Remove most recent order line. ");

        int subMenuChoice = inputController.getMenuChoice(1, 2);
        if (subMenuChoice == 1) {
            orderToEdit.addOrderLine();
        } else if (subMenuChoice == 2) {
            orderToEdit.removeOrderLine();
        }

        // Gem den opdaterede ordre.
        SaveLoad.saveOrderList("MarioPizzabarSystem/OrderListSaves/OrderListSaveTest.csv");
    }

    public static void completeOrder() throws FileNotFoundException {
        System.out.println("To complete order, type order ID: ");
        int orderID = inputController.getOrderId();
        Order orderToComplete = OrderList.getOrder(orderID - 1); // Jeg korrigerer ofte for -1, kan vi lægge det ind i klassen?
        orderToComplete.setCompleted(true);
        // Gem den opdaterede ordre.
        SaveLoad.saveOrderList("MarioPizzabarSystem/OrderListSaves/OrderListSaveTest.csv");
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