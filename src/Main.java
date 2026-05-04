import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {

            Menu m = new Menu();
            RecipeDatabase db = new RecipeDatabase();
            int userInput = 1;

            while (userInput != 9) {

                System.out.println(m.menu_print());
                userInput = m.userInput();

                /*
                1. Új alapanyag\n
                2. Új recept\n
                3. Recept törlése\n
                4. Hozzávalók listázása\n
                5. Receptek listázása név szerint\n
                6. Receptek listázása hozzávalók száma szerint\n
                7. Mentés fájlba\n
                8. Betöltés fájlból\n
                9. Kilépés;\n
                 */

                switch (userInput) {
                    case 1:
                        AppService.Newingredient(m, db);
                        break;

                    case 2:
                        AppService.NewRecipe(m, db);
                        break;

                    case 3:
                        AppService.DeleteRecipe(m, db);
                        break;

                    case 4:
                        AppService.ListIngredients(m, db);
                        break;

                    case 5:
                        db.listRecipesByName();
                        break;

                    case 6:
                        db.listRecipesByIngredientCount();
                        break;

                    case 7:
                        AppService.SaveToFile(db);
                        break;

                    case 8:
                        db = AppService.LoadFromFile();
                        break;

                    case 9:
                        System.out.println("Kilépés...");
                        break;

                    default:
                        System.out.println("Hibás választás!");
                }

            }

        } catch (IOException | ClassNotFoundException e) {
        System.err.println("Hiba: " + e.getMessage());
    }
    }
}

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