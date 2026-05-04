import java.util.TreeMap;
import java.io.Serializable;
public class Recipe implements Serializable{
    private String name;
    private TreeMap<String, RecipeIngredient> ingredients;

    public Recipe() {
        this.name = "Ismeretlen recept";
        this.ingredients = new TreeMap<>();
    }

    public Recipe(String name) {
        this.name = name;
        this.ingredients = new TreeMap<>();
    }

    public int getIngredientCount() {
        return ingredients.size();
    }

    public String getName() {
        return name;
    }

    public TreeMap<String, RecipeIngredient> getIngredients() {
        return ingredients;
    }

    // Hozzávaló hozzáadása
    public void addIngredient(RecipeIngredient h) {
        ingredients.put(h.getName(), h);
    }

    // Hozzávaló törlése
    public void removeIngredient(String name) {
        ingredients.remove(name);
    }

    // Keresés
    public RecipeIngredient findIngredient(String name) {
        return ingredients.get(name);
    }

    // Listázás
    public void listIngredients() {
        for (RecipeIngredient h : ingredients.values()) {
            System.out.println(h);
        }
    }

    @Override
    public String toString() {
        return "Recept: " + name + ", hozzávalók: " + ingredients.values();
    }
}