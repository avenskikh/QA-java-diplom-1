import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private final IngredientType type;

    public IngredientParameterizedTest(IngredientType type) {
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[][] getTypeData() {
        return new Object[][]{
                {IngredientType.FILLING},
                {IngredientType.SAUCE},
        };
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(type, "тест", 200);
        IngredientType actual = ingredient.getType();
        Assert.assertEquals(ingredient.type, actual);
    }
}
