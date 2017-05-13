/**
 * Created by I.Kamniev on 5/13/2017.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
public class SecondClass {
    protected static WebDriver driver;
    protected static void sleep(int time){
        try {
            // thread to sleep for 1000 milliseconds
            Thread.sleep(time * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Test(priority = 1, description = "Successful login into 7toys.com.ua")
    public void login(){

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("pojarnik");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("123456");
        driver.findElement(By.cssSelector("[type='submit']")).click();
        sleep(5);
        //Assert.assertFalse(driver.getTitle().contains("Сожалеем, Вы неправильно ввели логин или пароль!\n"),"NOT LOGED IN!");
    }
    @Test(priority = 2, description = "Add bike to cart", dependsOnMethods = "login")
    public void addBike(){
        driver.findElement(By.cssSelector("a[href='/catalog/all/")).click();
        sleep(2);
        driver.findElement(By.cssSelector("a[href='/category/%D0%A7%D0%9F006996/']")).click();
        sleep(2);
        driver.findElement(By.cssSelector("a[href='/category/%D0%A7%D0%9F007086/']")).click();
        sleep(2);
        // Add first bike on the page to the cart
        driver.findElement(By.cssSelector("input[class=tocart")).click();
        sleep(2);
        driver.findElement(By.cssSelector("a[href='/cart/']")).click();
        //Assert.assertTrue(checkIfElementExists("h1.filename"), "File could not be opened!");
    }
    public static boolean checkIfElementExists(String selector) {
        try {
            driver.findElement(By.cssSelector(selector));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @Test(priority = 3, description = "Logout from 7toys.com.ua", dependsOnMethods = "login")
    public void logout(){
        driver.findElement(By.cssSelector("a[href='/accounts/logout/?next=/")).click();
        sleep(5);
            }
    @BeforeClass
    public void startChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\WEBAutomation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://7toys.com.ua");
    }
      @Test
   public void buyOnebike () {
        login();
        addBike();
        //logout();
   }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
