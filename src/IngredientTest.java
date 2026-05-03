import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

        @Test
        void testGetName() {
            Ingredient i = new Ingredient("rum", "l");
            assertEquals("rum", i.getName());
        }

        @Test
        void testGetUnit() {
            Ingredient i = new Ingredient("rum", "l");
            assertEquals("l", i.getUnit());
        }
    }
