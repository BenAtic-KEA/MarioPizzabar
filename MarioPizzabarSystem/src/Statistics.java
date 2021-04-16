import java.util.List;

public class Statistics {


    public static int numberOfOrderedPizzas() {

        int numberOfPizzas = 0;
        List<Order> orderListArray = OrderList.getTheOrderList();

        for (int i = 0; i < orderListArray.size(); i++) {

            List<OrderLineItem> orderLineArray = orderListArray.get(i).getOrderLineItems();

            //if(!orderListArray.get(i).isCompleted()){
                for (int j = 0; j < orderLineArray.size(); j++) {

                int orderLineQuantity = orderLineArray.get(j).getQuantity();

                numberOfPizzas += orderLineQuantity;
                }
            }
        //}
        return numberOfPizzas;

    }

    private static int[] numberOfEachPizza() {

        int[] pizzaCount = new int[PizzaMenu.getPizzaMenu().size()];

        List<Order> orderListArray = OrderList.getTheOrderList();

        for (Order order : orderListArray) {

            List<OrderLineItem> orderLineCount = order.getOrderLineItems();

            for (OrderLineItem orderLineItem : orderLineCount) {

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

        for(int i = 0; i < amountOfOrders.size(); i++ ){

            double currentRevenue = amountOfOrders.get(i).getTotal();

            totalRevenue += currentRevenue;
        }
        return totalRevenue;
    }

    public static void showTotalRevenue(){

        double revenue = totalRevenue();

        System.out.println("Omsætningen for dagen: " + revenue + "kr");
    }
}
