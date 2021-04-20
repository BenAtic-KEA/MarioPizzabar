import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SaveLoad {

    /* testmetode
    //public static void main(String[] args) throws FileNotFoundException{
        PizzaMenu.listOfPizzas();
        loadOrderList("MarioPizzabarSystem/OrderListSaves/Orderlist.csv");
        saveOrderList("MarioPizzabarSystem/OrderListSaves/OrderListSaveTest.csv");
    //}*/

    // Looper over Ordrerlisten med iterator og gemmer alle ordrene som Strings i den specificerede pathToFile
    public static void saveOrderList(String pathToFile) throws FileNotFoundException{
        PrintStream output = new PrintStream(new File(pathToFile));
        output.println("date;pickupTime;completed;pizzas;quantity");
        Order order;
        Iterator<Order> itr = OrderList.getTheOrderList().iterator();
        while(itr.hasNext()){
            order = itr.next();
            output.println(convertOrderToSaveString(order));
        }
    }

    // læser en ordres relevante attributes, laver dem til strings og danner en saveString.
    private static String convertOrderToSaveString(Order order) {
        String date = order.formatDateToString(order.getDate());
        String complete = String.valueOf(order.isCompleted());
        return date + ";" + order.getPickUpTime() + ";" + complete + ";" + convertOrderLinesToSaveString(order);
    }

    // Læser ordrelinjers pizzanr og antal, laver dem til strings og sætter dem sammen i det rigtige format med '-' til brug i en saveString.
    private static String convertOrderLinesToSaveString(Order order){
        String pizzaNumbers = String.valueOf(order.getOrderLineItems().get(0).getPizza().getNr());
        String quantities = String.valueOf(order.getOrderLineItems().get(0).getQuantity());
        for (int i = 1; i<order.getOrderLineItems().size(); i++){
            pizzaNumbers = pizzaNumbers.concat("-").concat(String.valueOf(order.getOrderLineItems().get(i).getPizza().getNr()));
            quantities = quantities.concat("-").concat(String.valueOf(order.getOrderLineItems().get(i).getQuantity()));
        }
        return pizzaNumbers + ";" + quantities;
    }

    // Læser en csv-fil med gemte ordrer og indlæser dem til theOrderList.
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

            // finder
            boolean completed = Boolean.parseBoolean(currentOrder[2].trim());

            // Laver int array af pizzaID'er
            String[] pizzaString = currentOrder[3].trim().split("-");
            List<Integer> pizzaIDs = createIntegerList(pizzaString);

            // Laver list af quantities
            String[] quantityString = currentOrder[4].trim().split("-");
            List<Integer> quantities = createIntegerList(quantityString);

            // Tester om ordren mangler data og tilføjer ordren til theOrderList.
            if (pizzaIDs.size() == quantities.size()){
                OrderList.setOrder(new Order(dateInt,pickUpTime, completed, convertToIntArray(pizzaIDs), convertToIntArray(quantities), 1));
            }else{
                System.out.println("This Order was corrupted - skipping.");
            }
        }
    }

    // Konverterer en liste af Integer-objecter til et simpelt array af integers
    private static int[] convertToIntArray(List<Integer> list){
        int[] output = new int[list.size()];
        for (int i=0; i<output.length; i++){
            output[i]=list.get(i);
        }
        return output;
    }

    // Læser et String array med integers og laver dem om til en liste af Integer-objekter.
    private static List<Integer> createIntegerList(String[] inputArray){
        List<Integer> integerArrayList = new ArrayList<>();
        for (String str:
                inputArray) {
            integerArrayList.add(Integer.parseInt(str.trim()));
        }
        return integerArrayList;
    }
}
