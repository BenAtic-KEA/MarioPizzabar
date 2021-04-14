import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private static final List<Order> theOrderList = new ArrayList<>();

    // Laver ny Ordre og tilføjer den til Ordrelisten.
    public static void newOrder(){
        Order newOrder = new Order();
        newOrder.addOrderLines();
        theOrderList.add(newOrder);
    }

    // Getter til de individuelle ordrer i Arraylisten.
    public static Order getOrder(int orderNr){
        return theOrderList.get(orderNr);
    }
}
