package HomepageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginTest {

    private WebDriver driver;

    @BeforeTest
    public void setupDriver(ITestContext ctx) throws MalformedURLException {

        MutableCapabilities dc = new ChromeOptions();
        dc.setCapability("version","");
        driver= new RemoteWebDriver(new URL("http://192.168.1.173:4444/wd/hub"),dc);


    }



    @Test (priority = 1)
    public void titleVerificationTest() throws InterruptedException, MalformedURLException {

       // System.setProperty("webdriver.chrome.driver", "G:\\Intellij\\ooxcc\\src\\test\\java\\Resources\\chromedriver_win32\\chromedriver.exe");

       // ChromeOptions o= new ChromeOptions();
        //o.addArguments("--incognito");\   // o.addArguments("--headless");
       // driver = new ChromeDriver(o);
      //
        driver.get("https://ooxcc.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        String title = driver.getTitle();
        Assert.assertEquals("SuiteCRM",title);

    }

    @Test(priority = 2)
    public void loginTest() throws InterruptedException {
        WebElement userName = driver.findElement(By.name("username"));
        WebElement passWord = driver.findElement(By.name("password"));
        WebElement button = driver.findElement(By.id("login-button"));

        userName.sendKeys("rnewf");
        passWord.sendKeys("A0F&@WSNll");
        button.click();
        Thread.sleep(5000);
        WebElement newButton= driver.findElement(By.xpath("//button[contains(text(),'New')]"));
        boolean reply = newButton.isDisplayed();
       Assert.assertTrue(reply);
        driver.quit();
    }


}
