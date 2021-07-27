package com.EndToEndTestAutomation;

import com.Base.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.swing.*;
import java.util.Random;

public class EndToEndTest extends TestBase {
    public static void main(String[] args) {

        chromeLaunch();
        openTestURL("https://demo.opencart.com/index.php?route=account/register");
        String email=NewRegistration();
        openTestURL("https://demo.opencart.com/index.php?route=account/login");
        NewLogin(email);

    }

    public static String NewRegistration() {

        getElementByIdAndType("input-firstname", "akida");
        getElementByIdAndType("input-lastname", "taharat");
        WebElement Email = driver.findElement(By.id("input-email"));
        Random random = new Random();
        String email = "user" + random.nextInt(1000) + "@gmail.com";
        Email.sendKeys(email);
        getElementByIdAndType("input-telephone", "01234567890");
        getElementByIdAndType("input-password", "123456");
        getElementByIdAndType("input-confirm", "123456");
        getElementByXpathAndClick("//*[@id=\"content\"]/form/div/div/input[1]");
        getElementByXpathAndClick("//*[@id=\"content\"]/form/div/div/input[2]");

        String Exp_url = "https://demo.opencart.com/index.php?route=account/success";
        String Act_url = driver.getCurrentUrl();

        if (Exp_url.equals(Act_url)) {
            System.out.println("A new account just Created!");
        } else {
            System.out.println("Registration Failed, Bug Found!!!");
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
        return email;


    }

    public static void NewLogin(String email) {
        getElementByIdAndType("input-email",email);
        getElementByIdAndType("input-password","123456");
        getElementByXpathAndClick("//*[@id=\"content\"]/div/div[2]/div/form/input");
        System.out.println("Successfully logged In!!");
    }


}



