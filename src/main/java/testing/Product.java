package testing;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Product {
    private String actual;
    private String expected;
    @Test
    public void addProductValid()
    {
        System.setProperty("webdriver.chrome.driver","E:\\documents\\third year.second term\\software 2\\project\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("khlood@gmail.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.cssSelector("#login")).click();

        driver.findElement(By.cssSelector("body > div.container > div.main > div.content > form:nth-child(1) > input[type=\"submit\"]")).click();

        //registeration.loginValid();
        //driver.findElement(By.cssSelector(body > div.container > div.main > div.content > form:nth-child(3) > input[type="submit"]))
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("M@M's");
        driver.findElement(By.name("price")).clear();
        driver.findElement(By.name("price")).sendKeys("20");
        driver.findElement(By.name("category")).clear();
        driver.findElement(By.name("category")).sendKeys("food");
        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("120");
        driver.findElement(By.name("brand")).clear();
        driver.findElement(By.name("brand")).sendKeys("galaxy");
        driver.findElement(By.name("store")).clear();
        driver.findElement(By.name("store")).sendKeys("food");
        driver.findElement(By.cssSelector("body > form > input[type=\"submit\"]:nth-child(13)")).click();
        expected="add in DB";
        actual=driver.getTitle();
        if(expected.equals(actual))
            System.out.println("pass");
        else
            System.out.println("failed");
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void AddProductBug(){
        System.setProperty("webdriver.chrome.driver","E:\\documents\\third year.second term\\software 2\\project\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("khlood@gmail.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.cssSelector("#login")).click();

        driver.findElement(By.cssSelector("body > div.container > div.main > div.content > form:nth-child(1) > input[type=\"submit\"]")).click();

        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("$$");
        driver.findElement(By.name("price")).clear();
        driver.findElement(By.name("price")).sendKeys("$");
        driver.findElement(By.name("category")).clear();
        driver.findElement(By.name("category")).sendKeys("$");
        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("$");
        driver.findElement(By.name("brand")).clear();
        driver.findElement(By.name("brand")).sendKeys("$");
        driver.findElement(By.name("store")).clear();
        driver.findElement(By.name("store")).sendKeys("$");
        driver.findElement(By.cssSelector("body > form > input[type=\"submit\"]:nth-child(13)")).click();
        expected="http://localhost:8080/addProduct";
        actual=driver.getCurrentUrl();
        if(actual.equals(expected))
            System.out.println("pass");
        else
            System.out.println("failed");
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void buyProductValid(){
        System.setProperty("webdriver.chrome.driver","E:\\documents\\third year.second term\\software 2\\project\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("khlood@gmail.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.cssSelector("#login")).click();

        driver.findElement(By.cssSelector("body > div.container > div.main > div.content > form:nth-child(3) > input[type=\"submit\"]")).click();

        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("M@M's");
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("aya@gmail.com");
        driver.findElement(By.name("store")).clear();
        driver.findElement(By.name("store")).sendKeys("food");
        driver.findElement(By.name("amount")).clear();
        driver.findElement(By.name("amount")).sendKeys("2");
        driver.findElement(By.cssSelector("body > form > input[type=\"submit\"]:nth-child(9)")).click();
        expected="Buy Product";
        actual=driver.getTitle();

        if(actual.equals(expected))
            System.out.println("pass");
        else
            System.out.println("failed");
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void buyProductBug(){
        System.setProperty("webdriver.chrome.driver","E:\\documents\\third year.second term\\software 2\\project\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("khlood@gmail.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.cssSelector("#login")).click();

        driver.findElement(By.cssSelector("body > div.container > div.main > div.content > form:nth-child(3) > input[type=\"submit\"]")).click();

        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("");
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("aya@gmail.com");
        driver.findElement(By.name("store")).clear();
        driver.findElement(By.name("store")).sendKeys("");
        driver.findElement(By.name("amount")).clear();
        driver.findElement(By.name("amount")).sendKeys("");
        driver.findElement(By.cssSelector("body > form > input[type=\"submit\"]:nth-child(9)")).click();
        expected="products";//show all products
        actual=driver.getTitle();
        if(actual.equals(expected))
            System.out.println("pass");
        else
            System.out.println("failed");
        Assert.assertEquals(actual,expected);
    }
}
