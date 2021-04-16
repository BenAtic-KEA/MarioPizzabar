import java.util.List;

public class Statistics {


    public static int numberOfOrderedPizzas() {

        int numberOfPizzas = 0;
        List<Order> eachOrderArray = OrderList.getTheOrderList();

        for (Order order : eachOrderArray) {

            List<OrderLineItem> eachOrderLineItemArray = order.getOrderLineItems();

            //if(!eachOrderArray.get(i).isCompleted()){
            for (OrderLineItem orderLineItem : eachOrderLineItemArray) {

                int orderLineQuantity = orderLineItem.getQuantity();

                numberOfPizzas += orderLineQuantity;
            }
        }
        //}
        return numberOfPizzas;

    }

    private static int[] numberOfEachPizza() {

        int[] pizzaCount = new int[PizzaMenu.getPizzaMenu().size()];

        List<Order> eachOrderArray = OrderList.getTheOrderList();

        for (Order order : eachOrderArray) {

            List<OrderLineItem> orderLineItemArray = order.getOrderLineItems();

            for (OrderLineItem orderLineItem : orderLineItemArray) {

                int pizzaNr = orderLineItem.getPizza().getNr() - 1;
                int orderLineQuantity = orderLineItem.getQuantity();

                pizzaCount[pizzaNr] += orderLineQuantity;

            }
        }
        return pizzaCount;


    }

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

    public static void showTotalRevenue(){

        double revenue = totalRevenue();

        System.out.println("Omsætningen for dagen: " + revenue + "kr");
    }
}
