import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveLoad {

    public static void main(String[] args) throws FileNotFoundException{
        PizzaMenu.listOfPizzas();
        loadOrderList("MarioPizzabarSystem/Pizzaer/Orderlist.csv");
        OrderList.displayOrder(0);
        PizzaMenu.displayMenu();
    }

    public static void loadOrderList(String pathToFile) throws FileNotFoundException{

        // Initialiserer filen og scanneren der skal læse den.
        Scanner sc = new Scanner(
                new File(pathToFile));
        // Springer MetaData over.
        sc.nextLine();
        while(sc.hasNextLine()){

            // Loader nextline og splitter til string array.
            String currentLine = sc.nextLine();
            String[] currentOrder = currentLine.split(";");

            //Laver første parameter om til int array
            String[] dateString = currentOrder[0].trim().split("/");
            int[] dateInt = new int[3];
            for (int i = 0; i<dateString.length; i++){
                dateInt[i]= Integer.parseInt(dateString[i].trim());
            }

            // finder pickUpTime
            String pickUpTime = currentOrder[1].trim();

            // finder completed
            boolean completed = Boolean.getBoolean(currentOrder[2].trim());

            // Laver int array af pizzaID'er
            String[] pizzaString = currentOrder[3].trim().split("-");
            List<Integer> pizzaIDs = createIntegerList(pizzaString);

            // Laver list af quantities
            String[] quantityString = currentOrder[4].trim().split("-");
            List<Integer> quantities = createIntegerList(quantityString);

            if (pizzaIDs.size() == quantities.size()){
                OrderList.setOrder(loadOrder(dateInt,pickUpTime, completed, convertToIntArray(pizzaIDs), convertToIntArray(quantities)));
            }else{
                System.out.println("This Order was corrupted - skipping.");
            }
        }
    }

    private static int[] convertToIntArray(List<Integer> list){
        int[] output = new int[list.size()];
        for (int i=0; i<output.length; i++){
            output[i]=list.get(i);
        }
        return output;
    }

    private static List<Integer> createIntegerList(String[] inputArray){
        List<Integer> integerArrayList = new ArrayList<>();
        for (String str:
                inputArray) {
            integerArrayList.add(Integer.parseInt(str.trim()));
        }
        return integerArrayList;
    }

    public static Order loadOrder(int[] date, String pickupTime,  boolean completed, int[] pizzas, int[] quantity) {
        Order order = new Order();
        order.loadDate(date[0]-1900, date[1], date[2]);
        order.setPickUpTime(pickupTime);
        order.setCompleted(completed);
        for (int i : pizzas) {
            for (int j : quantity) {
                order.loadOrderLine(PizzaMenu.getPizza(i-1), j);
            }
        }
        return order;
    }
}
