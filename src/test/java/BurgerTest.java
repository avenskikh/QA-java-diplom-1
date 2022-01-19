import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {
    @Mock
    Bun bun;

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(10F);
        Mockito.when(bun.getName()).thenReturn("булка");
        Ingredient filling = new Ingredient(IngredientType.FILLING, "filling", 100);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "sauce", 200);
        burger.setBuns(bun);
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        String expected = "(==== булка ====)\r\n" +
                "= filling filling =\r\n" +
                "= sauce sauce =\r\n" +
                "(==== булка ====)\r\n" +
                "\r\n" +
                "Price: 320,000000\r\n";
        String actual = burger.getReceipt();
        Assert.assertEquals("не совпал рецепт", expected, actual);
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "test", 100);
        burger.ingredients.add(filling);
        float actualPrice = burger.getPrice();
        Assert.assertEquals("не совпал price", 100, actualPrice, 0);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        Ingredient fillingExpected = new Ingredient(IngredientType.FILLING, "test", 100);
        burger.addIngredient(fillingExpected);
        Ingredient fillingActual = burger.ingredients.get(0);
        Assert.assertEquals("не совпали ингредиенты", fillingExpected, fillingActual);



    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        Ingredient filling = new Ingredient(IngredientType.FILLING, "test", 100);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "tset", 200);
        burger.ingredients.add(filling);
        burger.ingredients.add(sauce);
        burger.removeIngredient(0);
        Ingredient fillingActual = burger.ingredients.get(0);
        Assert.assertEquals("Ингредиент не удален", sauce, fillingActual);
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(10F);
        Mockito.when(bun.getName()).thenReturn("булка");
        burger.ingredients.add(new Ingredient(IngredientType.FILLING, "test1", 100));
        burger.ingredients.add(new Ingredient(IngredientType.SAUCE, "test2", 34));
        burger.moveIngredient(1, 0);
        String actual = burger.getReceipt();
        String expected = "(==== булка ====)\r\n" +
                "= sauce test2 =\r\n" +
                "= filling test1 =\r\n" +
                "(==== булка ====)\r\n" +
                "\r\n" +
                "Price: 154,000000\r\n";
        Assert.assertEquals("ингредиент не перемещен", expected, actual);
    }
}