import java.io.Serializable;

public class RecipeIngredient implements Serializable{

    private Ingredient ingredient;
    private double amount;

    // Konstruktor
    public RecipeIngredient(Ingredient ingredient,double amount) {
        if (ingredient == null) {
            throw new IllegalArgumentException("Alapanyag nem lehet null");
        }
        this.ingredient = ingredient;
        this.amount = amount;

    }

    // Getterek
    public double getAmount() {
        return amount;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public String getName() {
        return ingredient.getName();
    }

    public String toString() {
        return ingredient.getName() + " - " + amount + " " + ingredient.getUnit();
    }
}