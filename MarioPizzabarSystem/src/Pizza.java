
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

        public void setNr(int newNr) {
            this.nr = newNr;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String newName){
            this.name = newName;
        }

        public String getIngredients() {
            return this.ingredients;
        }

        public void setIngredients(String newIngredients){
            this.ingredients = newIngredients;
        }

        public int getPrice() {
            return this.price;
        }

        public void setPrice(int newPrice) {
            this.price = newPrice;

        }
        //Overiding tostring
        @Override
        public String toString(){
            return nr + "" + name + "" + ingredients + "" + price;
        }
    }

