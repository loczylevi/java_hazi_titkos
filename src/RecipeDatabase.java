import java.io.*;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Comparator;

public class RecipeDatabase implements Serializable {

    private TreeMap<String, Ingredient> ingredients;
    private TreeMap<String, Recipe> recipes;

    public Ingredient findIngredient(String name) {
        return ingredients.get(name);
    }



    public RecipeDatabase() {
        ingredients = new TreeMap<>();
        recipes = new TreeMap<>();
    }

    // alapanyag hozzáadás
    public void addIngredient(Ingredient i) {
        ingredients.put(i.getName(), i);
    }

    // recept hozzáadás
    public void addRecipe(Recipe r) {
        recipes.put(r.getName(), r);
    }

    // recept törlés
    public void deleteRecipe(String name) {
        recipes.remove(name);
    }

    // recept keresés
    public Recipe findRecipe(String name) {
        return recipes.get(name);
    }

    // hozzávalók listázása
    public void listIngredientsOfRecipe(String name) {
        Recipe r = recipes.get(name);
        if (r != null) {
            r.listIngredients();
        } else {
            System.out.println("Nincs ilyen recept!");
        }
    }

    public void listRecipesByName() {
        for (Recipe r : recipes.values()) {
            System.out.println(r);
        }
    }

    public void listRecipesByIngredientCount() {
        ArrayList<Recipe> recipeList = new ArrayList<>(recipes.values());

        recipeList.sort(new Comparator<Recipe>() {
            @Override
            public int compare(Recipe r1, Recipe r2) {
                return r1.getIngredientCount() - r2.getIngredientCount();
            }
        });

        for (Recipe r : recipeList) {
            System.out.println(r.getName() + " - hozzávalók száma: " + r.getIngredientCount());
        }
    }



    // mentés fájlba
    public void saveToFile(String fileName) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
        out.writeObject(this);
        out.close();
    }

    // betöltés fájlból
    public static RecipeDatabase loadFromFile(String fileName)
            throws IOException, ClassNotFoundException {

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        RecipeDatabase db = (RecipeDatabase) in.readObject();
        in.close();
        return db;
    }
}