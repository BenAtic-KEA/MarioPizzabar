import java.util.Scanner;

public class OrderLineItem {

    private int subtotal;
    private int quantity;
    private Pizza pizza;

    public void enterFood() {
        Scanner input = new Scanner(System.in);

        // Indlæs pizza nummer.
        System.out.print("Indtast nr.");
        int pizzanumber = input.nextInt() - 1;

        // Indlæs antal.
        System.out.print("Indtast antal ");
        int quantity = input.nextInt();

        // Hent pizzaen med nummeret "pizzanumber" fra pizza menuen.
        Pizza pizza = PizzaMenu.getPizza(pizzanumber);

        // Beregn subtotal og overfør værdierne til felterne.
        this.subtotal = pizza.getPrice() * quantity;
        this.quantity = quantity;
        this.pizza = pizza;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public int getQuantity() {
        return quantity;
    }

    public Pizza getPizza() {
        return pizza;
    }

    @Override
    public String toString() {
        return "OrderLineItem" +
                "subtotal = " + subtotal +
                ", quantity = " + quantity +
                ", pizza = " + pizza +
                ;
    }
}


//OrderLineItem burde være en datatype i ordren.

