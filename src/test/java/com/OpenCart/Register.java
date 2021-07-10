package com.OpenCart;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Register extends TestBase {
    public static void main(String[] args) {
        chromeLaunch();
        TC_001_valid();
        chromeClose();
    }
    public static void TC_001_valid(){
        //step 01
        driver.get("https://demo.opencart.com/index.php?route=account/register");
        //firstname
        WebElement FirstName=driver.findElement(By.id("input-firstname"));
        FirstName.sendKeys("word");
        //lastname
        WebElement LastName=driver.findElement(By.id("input-lastname"));
        LastName.sendKeys("word");
        //Email
        WebElement Email=driver.findElement(By.id("input-email"));
        Email.sendKeys("user5665@gmail.com");
        //telephone
        WebElement Telephone=driver.findElement(By.id("input-telephone"));
        Telephone.sendKeys("01234567891");
        //Password
        WebElement Password=driver.findElement(By.id("input-password"));
        Password.sendKeys("123456");
        //confirm password
        WebElement Confirm=driver.findElement(By.id("input-confirm"));
        Confirm.sendKeys("123456");
        //checkbox
        WebElement checkbox=driver.findElement(By.name("agree"));
        checkbox.click();
        //submit
        WebElement submit =driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
        submit.click();



    }
    public static void inputFieldValidationTest(){
        WebElement ClickContinue = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
        WebElement First_name = driver.findElement(By.id("input-firstname"));
        First_name.sendKeys("dasdassdadasdasdasdasdasdasdasdasdasdasdasdasdasdasd");

        ClickContinue.click();

        String Exp_validationMessage="First Name must be between 1 and 32 characters!";
        String Act_validationMessage=driver.findElement(By.cssSelector("#account > div:nth-child(3) > div > div")).getText();

        if(Exp_validationMessage.equals(Act_validationMessage))
        {
            System.out.println("First Name validation Pass");
        }
        else{
            System.out.println("Test Failed for First name.Yahooooo Bug Found.");
        }
    }

    public boolean Firstname(){
        WebElement ClickContinue = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
        WebElement First_name = driver.findElement(By.id("input-firstname"));
        First_name.sendKeys("dasdassdadasdasdasdasdasdasdasdasdasdasdasdasdasdasd");

        ClickContinue.click();

        String Exp_validationMessage="First Name must be between 1 and 32 characters!";
        String Act_validationMessage=driver.findElement(By.cssSelector("#account > div:nth-child(3) > div > div")).getText();

        if(Exp_validationMessage.equals(Act_validationMessage))
        {
            System.out.println("First Name validation Pass");
        }
        return true;
    }


}

