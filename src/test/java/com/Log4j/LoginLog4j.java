package com.Log4j;

import com.Base.TestBase;
import com.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
/*
1. Go to login . Type Email.
3. Type Password.
4. Click Login button.
 */

public class LoginLog4j extends TestBase {
    public static void main(String[] args) throws IOException {
        chromeLaunch();
        TC_001_Valid();
        chromeClose();
    }
    public static void TC_001_Valid() throws IOException {
        //Step 1
        driver.get("https://demo.opencart.com/index.php?route=account/login");
        Log.info("Open login URL");

        //Step 2
        WebElement Email=driver.findElement(By.id("input-email"));
        Email.sendKeys("user101@gmail.com");
        Log.info("Type Email");

        //Step 3
        WebElement Password=driver.findElement(By.id("input-password"));
        Password.sendKeys("123456");
        Log.info("Type password");

        //Step 4
        WebElement LoginBtn=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        LoginBtn.click();
        Log.info("Click on Login Button");

        //Logic Develop
        //Login Pass
        String Exp_Title="My Account";
        String Act_Title=driver.getTitle();

        if(Exp_Title.equals(Act_Title)){
            System.out.println("Test Passed for valid Data.");
            Log.debug("Test Passed for valid Data.");

            //Logout
            WebElement logout=driver.findElement(By.linkText("Logout"));
            logout.click();
            captureScreenshot("LoginTest_Valid",".png");
        }
        else{
            System.out.println("Test Failed for valid Data.Yahooooo Bug Found.");
            Log.info("Test Failed for valid Data.");
        }


    }

}