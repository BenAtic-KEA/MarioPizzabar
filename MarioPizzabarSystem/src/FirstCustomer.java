import java.io.FileNotFoundException;

public class FirstCustomer {
    public static void main(String[] args)  throws FileNotFoundException {
        PizzaMenu.listOfPizzas();
        OrderList.newOrder();
        System.out.println(OrderList.getOrder(0));
    }
}
