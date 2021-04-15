import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PizzaMenu {

    private static ArrayList<Pizza> pizzaMenu = new ArrayList<>();


    public static void listOfPizzas()
            throws FileNotFoundException {

        // lokalisere og opretter scanner af Pizza.csv filen.
        File pizzaFile = new File("MarioPizzabarSystem/Pizzaer/Pizza.csv");
        Scanner pizzaFileReader = new Scanner(pizzaFile);

        // springer metadata over i Pizza.csv.
        pizzaFileReader.nextLine();

        while (pizzaFileReader.hasNextLine()) {
            // gemmer hver linje i currentLine, så den kan splittes til et array (currentPizza)
            String currentLine = pizzaFileReader.nextLine();
            String[] currentPizza = currentLine.split(";");

            // definere Pizzaens attributes
            int nr = Integer.parseInt(currentPizza[0].trim());
            String name = currentPizza[1].trim();
            String ingredients = currentPizza[2].trim();
            int price = Integer.parseInt(currentPizza[3].trim());

            //bruger pizza constructeren til at lave et object.
            Pizza tempPizza = new Pizza(nr, name, ingredients, price);

            // gemmer objectet i min ArrayList pizzaMenu og fortsætter mit while Loop
            pizzaMenu.add(tempPizza);

        }

    }
        // getPizza bruges til at hente 1 specifikt objekt i pizzaMenu.
        public static Pizza getPizza(int pizzaNr){
            return pizzaMenu.get(pizzaNr);

        }


       public static void displayMenu() {

        for(int i = 0; i < pizzaMenu.size(); i++){

                System.out.println(pizzaMenu.get(i));
            }
        }
}

