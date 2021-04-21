import java.util.Scanner;

public class OrderLineItem {

    private int subtotal;
    private int quantity;
    private Pizza pizza;

    // Tom constructor
    OrderLineItem(){}

    // Fuld constructor
    OrderLineItem(Pizza pizza,int quantity){
        this.pizza = pizza;
        this.quantity = quantity;
        subtotal = quantity * pizza.getPrice();
    }

    // metode til at få bruger input ved ordreoprettelse.
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
        return  "Nr. " + getPizza().getNr() + " " +
                getPizza().getName() + ". " +
                getPizza().getPrice() + "Kr" +
                " Antal: " + quantity +
                " Subtotal: " + subtotal + "Kr";
    }
}
