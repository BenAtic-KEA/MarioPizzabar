
public class Pizza {
        private int nr;
        private String name;
        private String ingredients;
        private int price;

        //constructor
        public Pizza(int nr, String name, String ingredients, int price) {
            this.nr = nr;
            this.name = name;
            this.ingredients = ingredients;
            this.price = price;
        }
        // getters and setters
        public int getNr() {
            return this.nr;
        }

        public String getName() {
            return this.name;
        }

        public String getIngredients() {
            return this.ingredients;
        }

        public int getPrice() {
            return this.price;
        }

        //Overriding tostring
        @Override
        public String toString(){
            return nr + " " + name + " " + ingredients + " " + price + "kr";
        }
    }

