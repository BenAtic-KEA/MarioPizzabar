import java.io.FileNotFoundException;

public class FirstCustomer {
    // Test for at se use-casen i funktion
    public static void main(String[] args)  throws FileNotFoundException {
        // Indlæser menukortet fra CSV-fil.
        PizzaMenu.listOfPizzas();
        // Opretter ny ordre
        OrderList.newOrder();
        // printer ordren med toString
        System.out.println(OrderList.getOrder(0));
    }
}
