import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private static final List<Order> theOrderList = new ArrayList<>();

    // Laver ny Ordre og tilføjer den til Ordrelisten. Mangler at bruge setters til pickupTime.
    public static Order newOrder(){
        Order newOrder = new Order();
        newOrder.addOrderLines();
        newOrder.setDate();
        newOrder.addPickUpTime();
        newOrder.setOrderID(theOrderList.size() + 1);
        setOrder(newOrder);
        return newOrder;
    }

    // Getter til de individuelle ordrer i Arraylisten.
    public static Order getOrder(int orderNr){
        return theOrderList.get(orderNr - 1); //korrigerer for index-placering jf. newOrder
    }

    public static List<Order> getTheOrderList() {
        return theOrderList;
    }

    public static void setOrder(Order order){
        theOrderList.add(order);
    }
}
