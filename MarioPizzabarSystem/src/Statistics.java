import java.util.Scanner;

public class Statistics {

    public static int numberOfOrderedPizzas(){

        int numberOfPizzas = 0;
        int orderListCount = OrderList.getTheOrderList().size();

        for(int i = 0; i < orderListCount; i++){
            int orderLineCount = OrderList.getTheOrderList().get(i).getOrderLineItems().size();

                for (int j = 0; j < orderLineCount; j++) {

                    int orderLineQuantity = OrderList.getTheOrderList().get(i).getOrderLineItems().get(j).getQuantity();

                    numberOfPizzas += orderLineQuantity;

                }
        }
        return numberOfPizzas;

    }

}
