import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PizzaMenu {

    private static final ArrayList<Pizza> pizzaMenu = new ArrayList<>();

    /**
     * Indlæser pizzaer fra fil til pizzaMenu
     */
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
    public static Pizza getPizza(int pizzaNr) {
        return pizzaMenu.get(pizzaNr); //TODO skal vi tilføje -1 for at undgå det i controlleren?

    }

    public static ArrayList<Pizza> getPizzaMenu() {
        return pizzaMenu;
    }


    public static void displayMenu() { //TODO burde denne display metoden rykkes til controller også kalde getPizzaMenu()?

        for (int i = 0; i < pizzaMenu.size(); i++) {

            // printer Nr
            int pizzaNr = pizzaMenu.get(i).getNr();

            System.out.print(pizzaMenu.get(i).getNr() + " ");
            if (pizzaNr < 10) {
                System.out.print(" ");
            }

            // printer Navn
            int longestPizzaName = longestPizzaName();
            int currentPizzaNameLength = pizzaMenu.get(i).getName().length();

            System.out.print(pizzaMenu.get(i).getName() + " ");
            if(currentPizzaNameLength < longestPizzaName){

                for(int j = currentPizzaNameLength; j < longestPizzaName;j++){
                    System.out.print(" ");
                }
            }
            //printer ingrediens
            int longestIngredientsString = longestIngredientsString();
            int currentIngredientsLength = pizzaMenu.get(i).getIngredients().length();
            System.out.print(pizzaMenu.get(i).getIngredients());

            if(currentIngredientsLength < longestIngredientsString){
                for(int k = currentIngredientsLength; k < longestIngredientsString; k++){
                    System.out.print(" ");
                }
            }
            //printer prisen

            System.out.println(" " + pizzaMenu.get(i).getPrice() + "kr");


            }
        }

    public static int longestPizzaName(){
        int longestName = 0;

        for (int i = 0; i < pizzaMenu.size(); i++){

            int tempLength = pizzaMenu.get(i).getName().length();

            if(tempLength > longestName){

                longestName = tempLength;
            }
        }
        return longestName;
    }

    public static int longestIngredientsString(){
        int longestString = 0;

        for (int i = 0; i < pizzaMenu.size(); i++){

            int tempLength = pizzaMenu.get(i).getIngredients().length();

            if(tempLength > longestString){

                longestString = tempLength;
            }
        }
        return longestString;
    }

}

