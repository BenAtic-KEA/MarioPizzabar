import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private static final List<Order> theOrderList = new ArrayList<>();

    // Laver ny Ordre og tilføjer den til Ordrelisten. Mangler at bruge setters til pickupTime.
    public static void newOrder(){
        Order newOrder = new Order();
        newOrder.addOrderLines();
        newOrder.setDate();
        newOrder.addPickUpTime();
        newOrder.setOrderID(theOrderList.size() + 1);
        setOrder(newOrder);
    }

    public static void editOrderLine(int orderID){
        System.out.println(theOrderList.get(orderID - 1));
    }

    // Getter til de individuelle ordrer i Arraylisten.
    public static Order getOrder(int orderNr){
        return theOrderList.get(orderNr);
    }

    public static List<Order> getTheOrderList() {
        return theOrderList;
    }

    public static void setOrder(Order order){
        theOrderList.add(order);
    }
    public static void displayOrder(int index){
        System.out.println(getOrder(index));
    }
}
