import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;


public class IngredientTest {

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "тест", 200);
        Float actual = ingredient.getPrice();
        Assert.assertEquals(ingredient.price, actual, 0);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "тест", 200);
        String actual = ingredient.getName();
        Assert.assertEquals(ingredient.name, actual);
    }
}