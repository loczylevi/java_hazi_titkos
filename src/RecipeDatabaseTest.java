import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RecipeDatabaseTest {
    @Test
    void testAddIngredientToDb() {
        RecipeDatabase db = new RecipeDatabase();
        Ingredient i = new Ingredient("fahéj", "dkg");

        db.addIngredient(i);

        assertNotNull(db.findIngredient("fahéj"));
    }

    @Test
    void testAddRecipe() {
        RecipeDatabase db = new RecipeDatabase();
        Recipe r = new Recipe("Mojito");

        db.addRecipe(r);

        assertNotNull(db.findRecipe("Mojito"));
    }

    @Test
    void testDeleteRecipe() {
        RecipeDatabase db = new RecipeDatabase();
        Recipe r = new Recipe("Mojito");

        db.addRecipe(r);
        db.deleteRecipe("Mojito");

        assertNull(db.findRecipe("Mojito"));
    }

    @Test
    void testFindRecipe() {
        RecipeDatabase db = new RecipeDatabase();
        Recipe r = new Recipe("Mojito");

        db.addRecipe(r);

        assertEquals("Mojito", db.findRecipe("Mojito").getName());
    }



}