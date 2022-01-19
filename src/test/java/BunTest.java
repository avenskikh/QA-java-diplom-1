import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {


    @Test
    public void getNameTest() {
        Bun bun = new Bun("Иван", 100);
        String actual = bun.getName();
        Assert.assertEquals("не совпал name", bun.name, actual);
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("Иван", 100);
        float actual = bun.getPrice();
        Assert.assertEquals("не совпал price", bun.price, actual, 0);
    }
}