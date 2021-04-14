import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private double total;
    private Date date;
    private Date pickUpTime;
    private boolean completed;
    private final List<OrderLineItem> orderLineItems = new ArrayList<>();

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

    public String orderLinesToString(){
        String orderLines = "";
        for (int i = 0; i<orderLineItems.size(); i++){
            orderLines += "\n" + orderLineItems.get(i);
        }
        return orderLines;
    }

    @Override
    public String toString(){
        return ""+ date + " " + pickUpTime + " " + completed + orderLinesToString();
    }
}
