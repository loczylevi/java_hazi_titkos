import java.io.IOException;
import java.util.ArrayList;

public class AppService {

    public static void Newingredient(Menu m, RecipeDatabase db) {
        System.out.println("\n___________Új alapanyag hozzáadása___________\n");

        while (true) {
            System.out.println("Alapanyag bekérés: space-t rakj a két adat közé!");
            ArrayList<String> list = m.InputIngridient();

            Ingredient userIngredient = new Ingredient(list.get(0), list.get(1));
            db.addIngredient(userIngredient);

            System.out.println("Akarsz még hozzáadni? (i/n)");
            String question = m.newinput().toLowerCase();

            if (question.equals("n") || question.equals("nem")) {
                break;
            }
        }
    }

    public static void NewRecipe(Menu m, RecipeDatabase db) {
        System.out.println("\n___________Új recept hozzáadása___________\n");

        String n = m.newRecipe();
        Recipe addRecipe = new Recipe(n);

        System.out.println("Recept hozzávaló bekérés: space-t rakj a két adat közé!");

        while (true) {
            ArrayList<String> listRecip = m.InputRecipe();
            String recipeName = listRecip.get(0);
            int recipeAmount = Integer.parseInt(listRecip.get(1));

            Ingredient ing = db.findIngredient(recipeName);

            if (ing != null) {
                RecipeIngredient addIngredient = new RecipeIngredient(ing, recipeAmount);
                addRecipe.addIngredient(addIngredient);
            } else {
                System.out.println("Nincs ilyen alapanyag hogy: " + recipeName);
            }

            System.out.println("Akarsz még hozzáadni a " + addRecipe.getName() + " recepthez? (i/n)");
            String question = m.newinput().toLowerCase();

            if (question.equals("n") || question.equals("nem")) {
                break;
            }
        }

        db.addRecipe(addRecipe);
    }

    public static void DeleteRecipe(Menu m, RecipeDatabase db) {
        System.out.println("Recept törlése");

        String delRec = m.newRecipe();
        Recipe recpFind = db.findRecipe(delRec);

        if (recpFind != null) {
            db.deleteRecipe(delRec);
            System.out.println("Recept sikeresen törölve: " + delRec);
        } else {
            System.out.println("Nincs ilyen recept hogy: " + delRec);
        }
    }

    public static void ListIngredients(Menu m, RecipeDatabase db) {
        System.out.println("Hozzávalók listázása");


        String recipeName = m.newRecipe();
        Recipe foundRecipe = db.findRecipe(recipeName);

        if (foundRecipe != null) {
            System.out.println("\n______________________\n");
            System.out.println(recipeName + ":");
            foundRecipe.listIngredients();
        } else {
            System.out.println("Nincs ilyen recept hogy: " + recipeName);
        }
        System.out.println("\n______________________\n");
    }

    public static void SaveToFile(RecipeDatabase db) throws IOException {
        System.out.println("Mentés fájlba...");
        db.saveToFile("adatbazis.dat");
        System.out.println("Mentés sikeres.");
    }

    public static RecipeDatabase LoadFromFile() throws IOException, ClassNotFoundException {
        System.out.println("Betöltés fájlból...");
        RecipeDatabase db = RecipeDatabase.loadFromFile("adatbazis.dat");
        System.out.println("Betöltés sikeres.");
        return db;
    }
}