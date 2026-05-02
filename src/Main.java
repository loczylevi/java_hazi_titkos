import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        try {
            // Fájlkezelő létrehozása
            FileHandler file = new FileHandler();

            file.createFile();
            file.writeToFile("adatbazis.txt", "Lorem ipsum gatyusz maximusz");
            file.readFromFile("adatbazis.txt");

            //               --- basic gerinc ---                //
            // Alapanyag létrehozása pipa
            // Ingredient rum = new Ingredient("fehér rum", "l");

            // Recept hozzávaló létrehozása
            // RecipeIngredient ingredient = new RecipeIngredient(rum, 2);

            // Recept létrehozása
            //Recipe recipe = new Recipe("Mojito");
            //recipe.addIngredient(ingredient);

            // Recept kiírása
            //System.out.println(recipe);
            //               --- basic gerinc ---                //


            Menu m = new Menu();
            RecipeDatabase db = new RecipeDatabase();
            int userInput = 1;

            while (userInput != 7) {
                System.out.println(m.menu_print());
                userInput = m.userInput();
                switch (userInput) {
                    case 1:
                        System.out.println("\n___________Új alapanyag hozzáadása___________\n");
                        while (true) {
                            System.out.println("Alapanyag bekérés: space-t rakj a két adat közé!");
                            ArrayList<String> list = m.InputIngridient();
                            Ingredient userIngridient = new Ingredient(list.get(0), list.get(1));

                            db.addIngredient(userIngridient);

                            System.out.println("Akarsz még hozzáadni? (i/n)");
                            String question = m.newinput().toLowerCase();
                            if (question.equals("n") || question.equals("nem")){
                                break;
                            }
                        }
                        break;

                    case 2:
                        System.out.println("\n___________Új recept hozzáadása___________\n");
                        String n = m.newRecipe();
                        Recipe add_recipe = new Recipe(n);

                        System.out.println("Recept hozzávaló bekérés: space-t rakj a két adat közé!");

                        while (true){

                            ArrayList<String> list_recip = m.InputRecipe();
                            String RecipeName = list_recip.get(0);
                            int RecipeAmount = Integer.parseInt(list_recip.get(1));

                            Ingredient ing = db.findIngredient(RecipeName);

                            if (ing != null){
                                RecipeIngredient AddIngredient = new RecipeIngredient(ing, RecipeAmount);
                                add_recipe.addIngredient(AddIngredient);

                            }
                            else{
                                System.out.println("Nincs ilyen alapanyag hogy: "+ RecipeName);
                            }

                            System.out.println("Akarsz még hozzáadni a "+ add_recipe.getName() + " recepthez? (i/n)");
                            String question = m.newinput().toLowerCase();
                            if (question.equals("n") || question.equals("nem")){
                                break;
                            }





                        }
                        db.addRecipe(add_recipe);
                        break;

                    case 3:
                        System.out.println("Recept törlése");
                        break;

                    case 4:
                        System.out.println("Hozzávalók listázása");
                        break;

                    case 5:
                        System.out.println("Mentés fájlba...");
                        break;

                    case 6:
                        System.out.println("Betöltés fájlból...");
                        break;

                    case 7:
                        System.out.println("Kilépés...");
                        break;

                    default:
                        System.out.println("Hibás választás!");
                }



            }




        } catch (IOException e) {
            System.err.println("Fájlkezelési hiba: " + e.getMessage());
        }
    }
}