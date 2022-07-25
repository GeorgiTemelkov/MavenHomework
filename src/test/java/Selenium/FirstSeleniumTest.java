package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FirstSeleniumTest {

   public WebDriver driver;
   public WebDriverWait wait;
   public Actions actions;

   @BeforeMethod
   public void setUp(){
       ChromeOptions options = new ChromeOptions();
  //      options.addArguments("--headless");
       options.addArguments("--window-size-1920x1080");

//      System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chrome/chromedriver.exe");


       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver(options);
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
       wait = new WebDriverWait(driver, Duration.ofSeconds(15));
       actions = new Actions(driver);


   }

   @AfterMethod
   public void tearDown(){
       driver.close();

   }


    @Test
    public void testLandingPAge()  {


        driver.get("http://training.skillo-bg.com");


        By loginLinkBy = By.id("nav-link-login");
        WebElement loginLink = driver.findElement(loginLinkBy);

        Assert.assertTrue(loginLink.isDisplayed());

        List<WebElement> listPost = driver.findElements(By.xpath("//div[@class='row post-list-container']//app-post-detail"));

        Assert.assertEquals(listPost.size(), 3);


        loginLink.click();

        WebElement signInTxt = driver.findElement(By.xpath("//p[text()='Sign in']"));
        Assert.assertTrue(signInTxt.isDisplayed());

    }

    @Test
    public void testLoginPage(){
    driver.get("http://training.skillo-bg.com/users/login");

    WebElement userName = driver.findElement(By.cssSelector("#defaultLoginFormUsername"));

    WebElement password = driver.findElement(By.cssSelector("#defaultLoginFormPassword"));
    WebElement signInBtn = driver.findElement(By.cssSelector("#sign-in-button"));


  //  actions.click(userName).sendKeys("Georgi404").perform();

    userName.sendKeys("Georgi404");
    password.sendKeys("Ge0rgi");
    signInBtn.click();

    By logoutLink = By.cssSelector(".fas.fa-sign-out-alt.fa-lg");
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(logoutLink)));

    Assert.assertTrue(driver.findElement(logoutLink).isDisplayed());


    }





}
