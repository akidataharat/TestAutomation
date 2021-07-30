package com.CrossBrowser;

import com.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;

public class CB_RegistrationTest {
    WebDriver driver;
    String RegisterURL = "https://demo.opencart.com/index.php?route=account/register";

    @BeforeClass
    @Parameters("Browser")

    public void initSetup(String browserName) {

        if (browserName.equalsIgnoreCase("Chrome")) {
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
    public void NewRegistration() {
        driver.get(RegisterURL);
        Log.info("Registration page open successfully");

        WebElement FirstName = driver.findElement(By.id("input-firstname"));
        FirstName.sendKeys("akida");

        //lastname
        WebElement LastName = driver.findElement(By.id("input-lastname"));
        LastName.sendKeys("taharat");

        //Email
        WebElement Email = driver.findElement(By.id("input-email"));
        Random random = new Random();
        String email = "user" + random.nextInt(1000) + "@gmail.com";
        Email.sendKeys(email);
        //Telephone
        WebElement Telephone = driver.findElement(By.id("input-telephone"));
        Telephone.sendKeys("01234567891");

        //Password
        WebElement Password = driver.findElement(By.id("input-password"));
        Password.sendKeys("123456");

        //confirm password
        WebElement Confirm = driver.findElement(By.id("input-confirm"));
        Confirm.sendKeys("123456");
        //checkbox
        WebElement checkbox = driver.findElement(By.name("agree"));
        checkbox.click();
        //submit
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
        submit.click();
        //registration check
        String Actual = "https://demo.opencart.com/index.php?route=account/success";
        String Expected = driver.getCurrentUrl();
        if (Actual.equals(Expected)) {
            System.out.println("Test passed for valid data");
        } else {
            System.out.println("yahoo!Bug found! Test failed for valid data");
        }
        //logout
        WebElement Logout = driver.findElement(By.linkText("Logout"));
        Logout.click();
        String Exp_url1 = "https://demo.opencart.com/index.php?route=account/logout";
        String Act_url1 = driver.getCurrentUrl();
        if (Exp_url1.equals(Act_url1)) {
            System.out.println("Logged out!");
        } else {
            System.out.println("Logout Failed, Bug Found!!!");
        }



    }

}