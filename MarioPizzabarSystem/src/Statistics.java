import java.util.Scanner;

public class Statistics {

    public static int numberOfOrderedPizzas(){

        int numberOfPizzas = 0;

        for(int i = 0; i < OrderList.getTheOrderList().size(); i++){
                for (int j = 0; j < OrderList.getTheOrderList().get(i).getOrderLineItems().size(); j++)

                    numberOfPizzas += OrderList.getTheOrderList().get(i).getOrderLineItems().get(j).getQuantity();

        }
        return numberOfPizzas;

    }

}
