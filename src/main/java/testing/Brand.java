package testing;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Brand {
    private String expected;
    private String actual;
    @Test
    public void addBrandInvalid(){
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

        driver.findElement(By.cssSelector("body > div.container > div.main > div.content > form:nth-child(2) > input[type=\"submit\"]")).click();


        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("");
        driver.findElement(By.name("category")).clear();
        driver.findElement(By.name("category")).sendKeys("");
        driver.findElement(By.cssSelector("body > form > input[type=\"submit\"]:nth-child(3)")).click();
        // invalid sendKeys(""),sendKeys(" ")
        expected="add brand";
        actual=driver.getTitle();
        if(expected.equals(actual))
            System.out.println("pass");
        else
            System.out.println("failed");
        Assert.assertEquals(actual,expected);
    }
}
