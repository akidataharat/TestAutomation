package com.Navigation;

import com.Base.TestBase;
import com.OpenCart.Register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class NavigationHomeWork extends TestBase {
    public static WebDriver driver;
    public static void main(String[] args){
        chromeLaunch();
        openTestURL("https://demo.opencart.com/");
        navigateTo("https://demo.opencart.com/index.php?route=account/register");
        Register.TC_001_valid();
        navigateBack();
        navigateForward();
        navigateRefresh();
        chromeClose();
    }
    public static void navigateTo(String URL){
        driver.navigate().to(URL);
        System.out.println("Navigate to " +driver.getTitle());
    }


    public static void navigateBack(){
        driver.navigate().back();
        openTestURL("https://demo.opencart.com/");

    }
    public static void navigateForward(){
        driver.navigate().forward();
        System.out.println("Navigate forward to " +driver.getTitle());
    }
    public static void navigateRefresh(){
        driver.navigate().refresh();
        System.out.println("Navigate forward to " +driver.getTitle());
    }


}
