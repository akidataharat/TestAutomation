package com.CrossBrowser;

import com.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CB_LoginTest {
    WebDriver driver;

    String LoginURL = "https://demo.opencart.com/index.php?route=account/login";

    @BeforeClass
    @Parameters("Browser")
    public void initSetup(String browserName) {

        if(browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
            Log.info("Chrome Launch successfully.");
        }


    }
    @AfterClass
    public void tearDown() {
        driver.close();
        Log.info("Chrome close successfully.");
    }

    @Test
    public void TC_001_Valid() {
        driver.get(LoginURL);
        Log.info("Login page open successfully");
        WebElement Email = driver.findElement(By.id("input-email"));
        Email.sendKeys("user101@gmail.com");
        Log.info("Type Email");

        WebElement Password = driver.findElement(By.id("input-password"));
        Password.sendKeys("123456");
        Log.info("Type password");

        WebElement LoginBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        LoginBtn.click();
        Log.info("Click on Login Button");

        //Logic Develop
        //Login Pass
        String Exp_Title = "My Account";
        String Act_Title = driver.getTitle();


        //Assertion
        Assert.assertEquals(Act_Title, Exp_Title);

        //Logout
        WebElement logout = driver.findElement(By.linkText("Logout"));
        logout.click();


    }
}
