import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;


public class IngredientTest {

    @Mock
    IngredientType type;

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(type, "тест", 200);
        Float actual = ingredient.getPrice();
        Assert.assertEquals(ingredient.price, actual, 0);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(type, "тест", 200);
        String actual = ingredient.getName();
        Assert.assertEquals(ingredient.name, actual);
    }
}