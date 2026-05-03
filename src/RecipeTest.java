import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    @Test
    void testGetName() {
        Recipe addRecipe = new Recipe("Mojito");
        assertEquals("Mojito", addRecipe.getName());

    }

    @Test
    void testAddIngredient() {
        Recipe recipe = new Recipe("Rizzy Shake");
        Ingredient ingredient = new Ingredient("vörös bor", "dl");
        RecipeIngredient recipeIngredient = new RecipeIngredient(ingredient, 2);
        recipe.addIngredient(recipeIngredient);

        assertNotNull(recipe.findIngredient("vörös bor"));
    }

    @Test
    void testRemoveIngredient() {
        Recipe r = new Recipe("fórró csoki");
        Ingredient i = new Ingredient("csokoládé", "g");
        RecipeIngredient ri = new RecipeIngredient(i, 25);

        r.addIngredient(ri);
        r.removeIngredient("csokoládé");

        assertNull(r.findIngredient("csokoládé"));
    }

    @Test
    void testFindIngredient() {
        Recipe r = new Recipe("Rumos narancs");
        Ingredient i = new Ingredient("narancslé", "dl");
        RecipeIngredient ri = new RecipeIngredient(i, 15);

        r.addIngredient(ri);

        assertEquals("narancslé", r.findIngredient("narancslé").getName());
    }
}


