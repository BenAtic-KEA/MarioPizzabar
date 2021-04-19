import java.util.List;

public class Statistics {

    /**
     * Tæller antallet af pizzaer
     */
    public static int numberOfOrderedPizzas() {

        int numberOfPizzas = 0;
        List<Order> eachOrderArray = OrderList.getTheOrderList();
        // Laver et loop for hver ordre i OrderList
        for (Order order : eachOrderArray) {

            List<OrderLineItem> eachOrderLineItemArray = order.getOrderLineItems();

            // kontrollere om ordren er fuldført.
            if (order.isCompleted()) {
                // laver et loop for hver OrderLineItem.
                for (OrderLineItem orderLineItem : eachOrderLineItemArray) {

                    int orderLineQuantity = orderLineItem.getQuantity();

                    numberOfPizzas += orderLineQuantity;
                }
            }
        }
        return numberOfPizzas;

    }

    private static int[] numberOfEachPizza() {

        // et Array som holder styr på hvor mange af en specifik pizza der er blevet lavet.
        int[] pizzaCount = new int[PizzaMenu.getPizzaMenu().size()];

        List<Order> eachOrderArray = OrderList.getTheOrderList();

        for (Order order : eachOrderArray) {

            List<OrderLineItem> orderLineItemArray = order.getOrderLineItems();

            if (order.isCompleted()) {

                for (OrderLineItem orderLineItem : orderLineItemArray) {

                    int pizzaNr = orderLineItem.getPizza().getNr() - 1;
                    int orderLineQuantity = orderLineItem.getQuantity();
                    // lægger mængden til den pizza der er lavet i pizzaCount[]
                    pizzaCount[pizzaNr] += orderLineQuantity;

                }
            }
        }
        return pizzaCount;

    }

    /**
     * printer antallet af pizzaer
     */
    public static void showNumberOfEachPizza(){
        int[] eachPizzaCount = numberOfEachPizza();

        for (int i = 0; i < eachPizzaCount.length; i++){
            String pizzaName = PizzaMenu.getPizza(i).getName();
            int pizzaMenuNr = i + 1;
            System.out.println("Pizzanr.: " + pizzaMenuNr + " " + pizzaName + " Amount sold: " + eachPizzaCount[i]);

        }

    }

    private static double totalRevenue(){

        List<Order> amountOfOrders = OrderList.getTheOrderList();
        double totalRevenue = .0;

        for (Order amountOfOrder : amountOfOrders) {

            double currentRevenue = amountOfOrder.getTotal();

            totalRevenue += currentRevenue;
        }
        return totalRevenue;
    }

    /**
     * printer omsætning
     */
    public static void showTotalRevenue(){

        double revenue = totalRevenue();

        System.out.println("Omsætningen for dagen: " + revenue + "kr");
    }

    /**
     * antallet af ordre på ordrelisten
     * @return int
     */
    public static int numberOfOrders(){

        List<Order> amountOfOrders = OrderList.getTheOrderList();
        int orderCount = 0;


        for(Order amountOfOrder : amountOfOrders){

            orderCount++;
        }
        return orderCount;
    }
}
