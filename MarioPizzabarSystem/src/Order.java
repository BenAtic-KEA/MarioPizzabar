import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Order {
    private double total;
    private Date date;
    private Date pickUpTime;
    private boolean completed;
    private List<OrderLineItem> orderLineItems = new ArrayList<OrderLineItem>();

    public Order() {
    }

    public double getTotal(){
        return total;
    }

    public Date getDate() {
        return date;
    }

     public Date getPickUpTime(){
        return pickUpTime;
     }

    public boolean isCompleted() {
        return completed;
    }

    public void createOrderLineItem(){
        OrderLineItem orderLine = new OrderLineItem();
        orderLine.enterFood();
        orderLineItems.add(orderLine);
    }

    public void setPickUpTime(Date pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
