import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Order {

    private double total;
    private Date date;
    private int orderID;
    private PickupTime pickUpTime;
    private boolean completed;
    private final List<OrderLineItem> orderLineItems = new ArrayList<>();

    // Tom constructor
    Order(){}

    // Fuld constructor
    Order(int[] date, String pickupTime,  boolean completed, int[] pizzas, int[] quantity, int orderID){
        loadDate(date[2]-1900, date[1]-1, date[0]);
        this.pickUpTime = new PickupTime(pickupTime);
        this.completed = completed;
        this.orderID = orderID;
        for (int i = 0 ; i < pizzas.length ; i++) {
            loadOrderLine(PizzaMenu.getPizza(pizzas[i]-1), quantity[i]);
        }
        setTotal();
    }


    // Getters til attributes
    public double getTotal(){
        return total;
    }

    public Date getDate() {
        return date;
    }

    public PickupTime getPickUpTime(){
        return pickUpTime;
     }

    public boolean isCompleted() {
        return completed;
    }

    public void loadOrderLine(Pizza pizza, int quantity){
        orderLineItems.add(new OrderLineItem(pizza, quantity));
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
    }

    public void addPickUpTime(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Tilføj afhentningstid: (timer:minutter)");
        String verifiedInput = null;
        while(verifiedInput == null){
            String input = sc.nextLine();
            if (input.length() == 5 && input.charAt(2) == ':'){
                verifiedInput = input;
            }
            else {
                System.out.println("Fejl i indtastning, prøv igen. (timer:minutter)");
            }
        }
        setPickUpTime(verifiedInput);
    }


    //metode til at tilføje en ny ordrelinje i menuen
    public void addOrderLine() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tilføj ny ordrelinje? y/n");
        if (sc.next().charAt(0) == 'y') {
            addOrderLines();
        }
    }

    //metode til at fjerne en ordrelinje fra menuen
    public void removeOrderLine() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hvilken ordrelinje skal fjernes?");

        for(int i = 0; i < orderLineItems.size(); i++){
            System.out.println("[" + (i + 1) + "] " + orderLineItems.get(i));
        }
        int orderLineID = sc.nextInt();
        if (orderLineID - 1 < orderLineItems.size()) {
            orderLineItems.remove(orderLineID - 1);
            System.out.println("Pizza id: " + orderLineID + " er blevet fjernet");
        } else {
            System.out.println("Dette ordre linje ID eksisterer ikke");
        }

    }


    // Beregner totalen ud fra de individuelle linjers subtotaler.
    public void setTotal(){
        for (OrderLineItem item :
                orderLineItems) {
            total+=item.getSubtotal();
        }
    }

    public void setDate() {
        date = new Date();
    }

    public void loadDate(int year, int month, int day){
        date = new Date(year, month, day);
    }

    // Temp setters skal måske fjernes senere.
    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = new PickupTime(pickUpTime);
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public List<OrderLineItem> getOrderLineItems() {
        return orderLineItems;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    // Loop der pakker Arraylisten ud og laver en samlet string med newlines for hvert objekt. Bruger OrderLineItem's toString().
    public String orderLinesToString(){
        String orderLines = "";
        for (int i = 0; i<orderLineItems.size(); i++){
            orderLines = orderLines.concat("\n" + orderLineItems.get(i));
        }
        return orderLines;
    }

    // læser en date og returnerer en formateret string med samme værdier.
    public String formatDateToString(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }

    // String repræsentation af Order objektet.
    @Override
    public String toString(){
        String completed = "Nej";
        if(isCompleted()){
            completed = "Ja";
        }
        return "OrdreID: #" + orderID + " " + "Dato: " + formatDateToString(getDate()) + " Pickup: " + getPickUpTime()
                + " " + orderLinesToString() + "\nTotal: " + getTotal() + "kr" + "\nFuldført: " + completed + "\n";
    }
}
