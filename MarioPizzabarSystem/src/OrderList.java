import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private static List<Order> theOrderList = new ArrayList<Order>();
    public static void newOrder(){
        Order newOrder = new Order();
        newOrder.createOrderLineItem();
        theOrderList.add(newOrder);
    }

    public static Order getOrder(int orderNr){
        return theOrderList.get(orderNr);
    }

}
