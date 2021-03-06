import java.io.FileNotFoundException;
import java.util.List;

public class OrderController {

    private static String saveFilePath;
    public static void setSaveFilePath(String inputFromUser){
        saveFilePath = inputFromUser;
    }

    public static void createOrder() throws FileNotFoundException {
        // Opret ny ordre via "OrderList", der står for at initialisere ordre-objektet og tilføje det til "theOrderList" (den interne ArrayList af ordrer).
        Order newOrder = OrderList.newOrder();

        // Gem den nyoprettede ordre med det samme, så Alfonzo ikke skal huske at gøre det løbende.
        SaveLoad.saveOrderList(saveFilePath);

        // Udskriv ordren, så Alfonzo kan se den.
        System.out.println("Lav ny ordre: \n" + newOrder.toString());
    }

    public static void editOrder() throws FileNotFoundException {
        System.out.println("Indtast ordreID: ");
        int orderID = InputController.getOrderId();

        for (int i = 0; i < OrderList.getTheOrderList().size();i++) {
            if (OrderList.getOrder(i + 1).getOrderID() == orderID) {
                Order orderToEdit = OrderList.getOrder(i + 1);

                System.out.println("Redigér ordre: " + orderToEdit.getOrderID());
                System.out.println("------------------------");
                System.out.println("[1] - Tilføj ordrelinje ");
                System.out.println("[2] - Fjern ordrelinje ");

                int subMenuChoice = InputController.getMenuChoice(1, 2);
                if (subMenuChoice == 1) {
                    orderToEdit.addOrderLine();
                } else if (subMenuChoice == 2) {
                    if (orderToEdit.getOrderLineItems().size() < 2) {
                        OrderList.getTheOrderList().remove(i);
                        System.out.println("Ordre:" + orderToEdit.getOrderID() +" er slettet");
                    } else {
                        orderToEdit.removeOrderLine();
                    }
                }
            }
        }
        // Gem den opdaterede ordre.
        SaveLoad.saveOrderList(saveFilePath);
    }

    public static void completeOrder() throws FileNotFoundException {
        System.out.println("Afslut ordre, indtast ordre ID: ");
        int orderID = InputController.getOrderId();
        for (int i = 0; i < OrderList.getTheOrderList().size();i++) {
            if (OrderList.getOrder(i + 1).getOrderID() == orderID) {
                OrderList.getOrder(i + 1).setCompleted(true);
            }
        }
        SaveLoad.saveOrderList(saveFilePath);
    }

    public static void showActiveOrders() {
        // Hent listen af ordrer fra "orderList".
        List<Order> theOrderList = sortedByPickUpTime(OrderList.getTheOrderList());

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
    public static List<Order> sortedByPickUpTime(List<Order> theOrderList) {

        List<Order> sortedOrderList = theOrderList;
        Order temp;
        int i, j;
        int N = theOrderList.size();

        for (j = 0; j < N - 1; j++) {
            for (i = 0; i < N - j - 1; i++) {

                int totalMinutes = sortedOrderList.get(i).getPickUpTime().timeToMinutes();

                if (totalMinutes > (sortedOrderList.get(i + 1).getPickUpTime().timeToMinutes())) {

                    temp = sortedOrderList.get(i);

                    sortedOrderList.set(i, sortedOrderList.get(i + 1));
                    sortedOrderList.set(i + 1, temp);

                }
            }
        }
        return sortedOrderList;
    }
}
