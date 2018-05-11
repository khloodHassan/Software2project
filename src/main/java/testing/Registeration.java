package testing;

import com.example.demo.Entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
@SpringBootConfiguration
//@Mock
//@Import(MyTestsConfiguration.class)
public class Registeration {

    private final int lenght = 255;
    //private char[] expected=new char[lenght];
    private String expected;
    private String actual;

    @Test
    public void loginValid(){
      /*System.setProperty("webdriver.chrome.driver","E:\\documents\\third year.second term\\software 2\\project\\chromedriver.exe");
      WebDriver driver= new ChromeDriver();
      driver.get("http://localhost:8080/login");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("khlood@gmail.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.cssSelector("#login")).click();*/
      User user=new User("khlood@gmail.com","123");
      ArrayList<User> array=new ArrayList<User>();
      array.add(user);
      //Mockito.when()
    }
    @Test
    public void loginInValid(){
        System.setProperty("webdriver.chrome.driver","E:\\documents\\third year.second term\\software 2\\project\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("$");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("*");
        driver.findElement(By.cssSelector("#login")).click();
    }
    @Test
    public void loginInValidAdmin(){
        System.setProperty("webdriver.chrome.driver","E:\\documents\\third year.second term\\software 2\\project\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("khlood@gmail.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("KFSD");
        driver.findElement(By.cssSelector("#login")).click();
    }
    @Test
    public void addBrandValid(){
        System.setProperty("webdriver.chrome.driver","E:\\documents\\third year.second term\\software 2\\project\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/addBrand?");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys();
        driver.findElement(By.name("category")).clear();
        driver.findElement(By.name("category")).sendKeys();
        driver.findElement(By.cssSelector("body > form > input[type=\"submit\"]:nth-child(3)")).click();


    }
    @Test
    public void addBrandInValid(){
        System.setProperty("webdriver.chrome.driver","E:\\documents\\third year.second term\\software 2\\project\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/addBrand?");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("");
        driver.findElement(By.name("category")).clear();
        driver.findElement(By.name("category")).sendKeys("");
        driver.findElement(By.cssSelector("body > form > input[type=\"submit\"]:nth-child(3)")).click();
        // invalid sendKeys(""),sendKeys(" ")

    }

    @Test
    public void signUpValid(){
        System.setProperty("webdriver.chrome.driver","E:\\documents\\third year.second term\\software 2\\project\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/register");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("userName")).clear();
        driver.findElement(By.name("userName")).sendKeys("asmaa");
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("asmaa@gmail.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("12");
        driver.findElement(By.name("confirm")).clear();
        driver.findElement(By.name("confirm")).sendKeys("12");
        driver.findElement(By.id("type1"));
        driver.findElement(By.id("type1")).click();
        driver.findElement(By.cssSelector("body > div.container > div.main > div.content > form > input[type=\"submit\"]:nth-child(16)")).click();
        //String expected1="http://localhost:8080/registered";
        expected="http://localhost:8080/registered";
        actual=driver.getCurrentUrl();
        //System.out.println("pass");
        Assert.assertEquals(actual,expected);
        if(expected.equals(actual))
        {
            System.out.println("pass");
        }
        else
            System.out.println("failed");
    }
    @Test
    public void signUpInvalid(){
        System.setProperty("webdriver.chrome.driver","E:\\documents\\third year.second term\\software 2\\project\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/register");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.switchTo().frame("main");
        driver.findElement(By.name("userName")).clear();
        driver.findElement(By.name("userName")).sendKeys("");
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("");
        driver.findElement(By.name("confirm")).clear();
        driver.findElement(By.name("confirm")).sendKeys("");
        //driver.findElement(By.id("type1")).clear();
        driver.findElement(By.id("type1"));
        driver.findElement(By.id("type1")).click();
        /*
        driver.findElement(By.id("type2"));
        driver.findElement(By.id("type2")).click();
        driver.findElement(By.id("type3"));
        driver.findElement(By.id("type3")).click();*/
        driver.findElement(By.cssSelector("body > div.container > div.main > div.content > form > input[type=\"submit\"]:nth-child(16)")).click();
        expected="http://localhost:8080/registered";
        actual=driver.getCurrentUrl();
        if(expected.equals(actual))
        {
            System.out.println("pass");
        }
        else
            System.out.println("failed");
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void addStoreValid(){
        System.setProperty("webdriver.chrome.driver","E:\\documents\\third year.second term\\software 2\\project\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/addStore");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("btngan a7mr");
        driver.findElement(By.name("type")).clear();
        driver.findElement(By.name("type")).sendKeys("food");
        driver.findElement(By.id("location1"));
        driver.findElement(By.id("location1")).click();
        driver.findElement(By.cssSelector("body > form > input[type=\"submit\"]:nth-child(10)")).click();

    }
    @Test
    public void addStoreBug(){
        System.setProperty("webdriver.chrome.driver","E:\\documents\\third year.second term\\software 2\\project\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/addStore");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("0");
        driver.findElement(By.name("type")).clear();
        driver.findElement(By.name("type")).sendKeys("0");
        driver.findElement(By.id("location1"));
        driver.findElement(By.id("location1")).click();
        driver.findElement(By.cssSelector("body > form > input[type=\"submit\"]:nth-child(10)")).click();
    }
    @Test
    public void addStoreInValid(){
        System.setProperty("webdriver.chrome.driver","E:\\documents\\third year.second term\\software 2\\project\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/addStore");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys(" ");
        driver.findElement(By.name("type")).clear();
        driver.findElement(By.name("type")).sendKeys(" ");
        driver.findElement(By.id("location1"));
        driver.findElement(By.id("location1")).click();
        driver.findElement(By.cssSelector("body > form > input[type=\"submit\"]:nth-child(10)")).click();
    }


    @Test
    public void AddProductBug(){
        System.setProperty("webdriver.chrome.driver","E:\\documents\\third year.second term\\software 2\\project\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/addProduct");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys(" ");
        driver.findElement(By.name("price")).clear();
        driver.findElement(By.name("price")).sendKeys("0");
        driver.findElement(By.name("category")).clear();
        driver.findElement(By.name("category")).sendKeys(" ");
        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("0");
        driver.findElement(By.name("brand")).clear();
        driver.findElement(By.name("brand")).sendKeys(" ");
        driver.findElement(By.name("store")).clear();
        driver.findElement(By.name("store")).sendKeys(" ");
        driver.findElement(By.cssSelector("body > form > input[type=\"submit\"]:nth-child(13)")).click();

    }
    @Test
    public void AddCollaboratorValid(){
        System.setProperty("webdriver.chrome.driver","E:\\documents\\third year.second term\\software 2\\project\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/addCollaborator");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("userName")).clear();
        driver.findElement(By.name("userName")).sendKeys("Olaa");
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("olaa@gmail.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.name("confirm")).clear();
        driver.findElement(By.name("confirm")).sendKeys("123");
        driver.findElement(By.name("storeOwnerEmail")).clear();
        driver.findElement(By.name("storeOwnerEmail")).sendKeys("ayaa@gmail.com");
        driver.findElement(By.cssSelector("body > form > input[type=\"submit\"]:nth-child(11)")).click();
    }
    @Test
    public void AddCollaboratorInValid(){
        System.setProperty("webdriver.chrome.driver","E:\\documents\\third year.second term\\software 2\\project\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/addCollaborator");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("userName")).clear();
        driver.findElement(By.name("userName")).sendKeys("0");
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("0");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("0");
        driver.findElement(By.name("confirm")).clear();
        driver.findElement(By.name("confirm")).sendKeys("0");
        driver.findElement(By.name("storeOwnerEmail")).clear();
        driver.findElement(By.name("storeOwnerEmail")).sendKeys("ayaa@gmail.com");
        driver.findElement(By.cssSelector("body > form > input[type=\"submit\"]:nth-child(11)")).click();
    }

}
