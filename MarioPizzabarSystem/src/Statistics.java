import java.util.List;

public class Statistics {

    /**
     * Tæller antallet af pizzaer
     */
    public static int numberOfOrderedPizzas() {

        int numberOfPizzas = 0;
        List<Order> orderArray = OrderList.getTheOrderList();
        // Laver et loop for hver ordre i OrderList
        for (Order order : orderArray) {

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

    private static int[] numberOfEachPizza() { //TODO hvis 1.1 er gældende skal denne gøres public

        // et Array som holder styr på hvor mange af en specifik pizza der er blevet lavet.
        int[] pizzaCountArray = new int[PizzaMenu.getPizzaMenu().size()];

        List<Order> orderArray = OrderList.getTheOrderList();

        for (Order order : orderArray) {

            List<OrderLineItem> orderLineItemArray = order.getOrderLineItems();

            if (order.isCompleted()) {

                for (OrderLineItem orderLineItem : orderLineItemArray) {

                    int pizzaNr = orderLineItem.getPizza().getNr() - 1;
                    int orderLineQuantity = orderLineItem.getQuantity();
                    // lægger mængden til den pizza der er lavet i pizzaCount[]
                    pizzaCountArray[pizzaNr] += orderLineQuantity;

                }
            }
        }
        return pizzaCountArray;

    }

    /**
     * printer antallet af pizzaer
     */
    public static void showNumberOfEachPizza(){ //TODO 1.1 burde denne rykkes til controlleren også kalde numberOfEachPizza()?
        int[] pizzaCount = numberOfEachPizza();

        for (int i = 0; i < pizzaCount.length; i++){
            String pizzaName = PizzaMenu.getPizza(i).getName();
            int pizzaMenuNr = i + 1;
            System.out.println("Pizzanr.: " + pizzaMenuNr + " " + pizzaName + " Amount sold: " + pizzaCount[i]);

        }

    }

    private static double totalRevenue(){ //TODO hvis 2.1 er gældende skal denne gøres public

        List<Order> orderArray = OrderList.getTheOrderList();
        double totalRevenue = .0;

        for (Order order : orderArray) {
            if (order.isCompleted()) {
                double currentRevenue = order.getTotal();

                totalRevenue += currentRevenue;
            }
        }
        return totalRevenue;
    }

    /**
     * printer omsætning
     */
    public static void showTotalRevenue(){ //TODO 2.1 burde denne rykkes til controlleren også kalde totalRevenue()?

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
