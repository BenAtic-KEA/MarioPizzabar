import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PizzaMenu {

    private static ArrayList<Pizza> pizzaMenu;


    public static void listOfPizzas()
            throws FileNotFoundException {


        File pizzaFile = new File("MarioPizzabarSystem/Pizzaer/Pizza.csv");
        Scanner pizzaFileReader = new Scanner(pizzaFile);
        pizzaMenu = new ArrayList<Pizza>();

        pizzaFileReader.nextLine();

        while (pizzaFileReader.hasNextLine()) {
            String currentLine = pizzaFileReader.nextLine();
            String[] currentPizza = currentLine.split(";");

            int nr = Integer.parseInt(currentPizza[0].trim());
            String name = currentPizza[1].trim();
            String ingredients = currentPizza[2].trim();
            int price = Integer.parseInt(currentPizza[3].trim());

            Pizza tempPizza = new Pizza(nr, name, ingredients, price);

            pizzaMenu.add(tempPizza);
        }

    }

        public static void displayMenu()
        throws FileNotFoundException {

        while(int i = 0; i < pizzaMenu.size(); i++){

                System.out.println(pizzaMenu.get(i));
            }
        }

}

