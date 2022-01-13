import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


public class BurgerTest {


    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        Bun bun = new Bun("булка", 10);
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
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        Bun bun = new Bun("булка", 10);
        burger.setBuns(bun);
        Float actualPrice = burger.getPrice();
        Assert.assertEquals(20, actualPrice, 0);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        Bun bun = new Bun("булка", 10);
        burger.setBuns(bun);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "test", 100);
        burger.addIngredient(filling);
        String receipt = burger.getReceipt();
        Assert.assertTrue(receipt.contains("test"));
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        Bun bun = new Bun("булка", 10);
        burger.setBuns(bun);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "test", 100);
        burger.addIngredient(filling);
        burger.removeIngredient(0);
        String receipt = burger.getReceipt();
        Assert.assertFalse(receipt.contains("test"));
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        Bun bun = new Bun("булка", 10);
        burger.setBuns(bun);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "test1", 100);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "test2", 34);
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        burger.moveIngredient(1,0);
        String actual = burger.getReceipt();
        String expected = "(==== булка ====)\r\n" +
                "= sauce test2 =\r\n" +
                "= filling test1 =\r\n" +
                "(==== булка ====)\r\n" +
                "\r\n" +
                "Price: 154,000000\r\n";
        Assert.assertEquals(expected, actual);
    }
}