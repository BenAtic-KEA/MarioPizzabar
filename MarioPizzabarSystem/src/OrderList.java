import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private static List<Order> theOrderList = new ArrayList<Order>();
    public void newOrder(){
        Order newOrder = new Order();
        newOrder.createOrderLineItem();
        theOrderList.add(newOrder);
    }
}
