import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Order {
    private double total;
    private Date date;
    private String pickUpTime;
    private boolean completed;
    private final List<OrderLineItem> orderLineItems = new ArrayList<>();

    // Getters til attributes
    public double getTotal(){
        return total;
    }

    public Date getDate() {
        return date;
    }

    public String getPickUpTime(){
        return pickUpTime;
     }

    public boolean isCompleted() {
        return completed;
    }

    // Metode til at lave Ordrelinjer, Laver et nyt ordelinjeobjekt, populerer det med attributes og tilføjer den til Arraylisten.
    public void createOrderLineItem(){
        OrderLineItem orderLine = new OrderLineItem();
        orderLine.enterFood();
        orderLineItems.add(orderLine);
    }

    // Loop der tillader at tilføje flere ordrelinjer ad gangen.
    public void addOrderLines(){
        Scanner sc = new Scanner(System.in);
        boolean finished = false;
        while(!finished){
            createOrderLineItem();
            System.out.println("Tilføj flere? Y/n");
            if (sc.next().charAt(0) == 'n') {
                finished = true;
                setTotal();
            }
        }
        sc.close();
    }

    public void addPickUpTime(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Tilføj afhentningstid: ");
        setPickUpTime(sc.nextLine());
        sc.close();
    }

    // Beregner totalen ud fra de individuelle linjers subtotaler.
    private void setTotal(){
        for (OrderLineItem item :
                orderLineItems) {
            total+=item.getSubtotal();
        }
    }

    public void setDate() {
        date = new Date();
    }

    // Temp setters skal måske fjernes senere.
    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // Loop der pakker Arraylisten ud og laver en samlet string med newlines for hvert objekt. Bruger OrderLineItem's toString().
    public String orderLinesToString(){
        String orderLines = "";
        for (int i = 0; i<orderLineItems.size(); i++){
            orderLines += "\n" + orderLineItems.get(i);
        }
        return orderLines;
    }

    // String repræsentation af Order objektet.
    @Override
    public String toString(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String fuldført = "Nej";
        if(isCompleted()){
            fuldført = "Ja";
        }
        return "Dato: " + formatter.format(getDate()) + " Pickup: " + getPickUpTime() + " " + orderLinesToString() + "\nTotal: " + getTotal() + "\nFuldført: " + fuldført;
    }
}
