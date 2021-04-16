public class Statistics {

    public static int numberOfOrderedPizzas() {

        int numberOfPizzas = 0;
        int orderListCount = OrderList.getTheOrderList().size();

        for (int i = 0; i < orderListCount; i++) {
            int orderLineCount = OrderList.getTheOrderList().get(i).getOrderLineItems().size();

            if(!OrderList.getTheOrderList().get(i).isCompleted()){
                for (int j = 0; j < orderLineCount; j++) {

                int orderLineQuantity = OrderList.getTheOrderList().get(i).getOrderLineItems().get(j).getQuantity();

                numberOfPizzas += orderLineQuantity;
                }
            }
        }
        return numberOfPizzas;

    }

    public static int[] numberOfEachPizza() {

        int[] pizzaCount = new int[PizzaMenu.getPizzaMenu().size()];


        int orderListCount = OrderList.getTheOrderList().size();

        for (int i = 0; i < orderListCount; i++) {
            int orderLineCount = OrderList.getTheOrderList().get(i).getOrderLineItems().size();

            for (int j = 0; j < orderLineCount; j++) {
                int pizzaNr = OrderList.getTheOrderList().get(i).getOrderLineItems().get(j).getPizza().getNr();
                int orderLineQuantity = OrderList.getTheOrderList().get(i).getOrderLineItems().get(j).getQuantity();

                pizzaCount[pizzaNr] += orderLineQuantity;

            }
        }
        return pizzaCount;


    }

    public static void showNumberOfEachPizza(){
        int[] eachPizzaCount = numberOfEachPizza();

        System.out.println("PizzaNr. ----      Name      ----     Amount sold");
        for (int i = 0; i < eachPizzaCount.length; i++){
            String pizzaName = PizzaMenu.getPizza(i).getName();
            System.out.println(i +" ----" + pizzaName +" ---- "+ eachPizzaCount[i]);



        }


    }
}
