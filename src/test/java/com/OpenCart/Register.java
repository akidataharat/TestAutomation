package com.OpenCart;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Register extends TestBase {
    public static void main(String[] args) {
        chromeLaunch();
       // TC_001_valid();
        TC_002_valid();
        chromeClose();
    }

    public static void TC_001_valid() {
        //step 01
        driver.get("https://demo.opencart.com/index.php?route=account/register");
        //firstname
        WebElement FirstName = driver.findElement(By.id("input-firstname"));
        FirstName.sendKeys("word");
        //lastname
        WebElement LastName = driver.findElement(By.id("input-lastname"));
        LastName.sendKeys("word");
        //Email
        WebElement Email = driver.findElement(By.id("input-email"));
        Email.sendKeys("");
        //telephone
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
    }

    public static void TC_002_valid() {
        driver.get("https://demo.opencart.com/index.php?route=account/register");
        WebElement Firstname = driver.findElement(By.id("input-firstname"));
        Firstname.sendKeys("asdfghjklmnbvcxzqwertyuiolpkjh");
        WebElement Lastname = driver.findElement(By.id("input-lastname"));
        Lastname.sendKeys("qwertyuioplkjhgfdsazxcvbnmlkiuj");
        WebElement Email = driver.findElement(By.id("input-email"));
        Email.sendKeys("user@gmail.com");
        WebElement Telephone = driver.findElement(By.id("input-telephone"));
        Telephone.sendKeys("12345678912");
        WebElement Password = driver.findElement(By.id("input-password"));
        Password.sendKeys("12345678");
        WebElement ConfirmPassword = driver.findElement(By.id("input-confirm"));
        ConfirmPassword.sendKeys("12345678");
        WebElement Agree = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
        Agree.click();
        WebElement Continue = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
        Continue.click();
        //First Name
        String Expected_fn_message = "First Name must be between 1 and 32 characters!";
        String Actual_fn_message = driver.findElement(By.cssSelector("#account > div:nth-child(3) > div > div")).getText();
        if (Expected_fn_message.equals(Actual_fn_message)) {
            System.out.println("Registration first name passed");
        } else {
            System.out.println("Yahoo!!,Bug detected for first name");
        }
        // Last Name
        String Expected_ln_message = "Last Name must be between 1 and 32 characters!";
        String Actual_ln_message = driver.findElement(By.cssSelector("#account > div:nth-child(4) > div > div")).getText();
        if (Expected_ln_message.equals(Actual_ln_message)) {
            System.out.println("Registration for last name passed");
        } else {
            System.out.println("Yahoo!!,Bug detected for last name");
        }
        //Email
        String Expected_email_message = "E-Mail Address does not appear to be valid!";
        String Actual_email_message = driver.findElement(By.cssSelector("#account > div:nth-child(5) > div > div")).getText();
        if (Expected_email_message.equals(Actual_email_message)) {
            System.out.println("Registration for email passed");
        } else {
            System.out.println("Yahoo!!,Bug detected for Email");
        }
        //Telephone
        String Expected_telephone_message = "Telephone must be between 3 and 32 characters!";
        String Actual_telephone_message = driver.findElement(By.cssSelector("#account > div:nth-child(6) > div > div")).getText();
        if (Expected_telephone_message.equals(Actual_telephone_message)) {
            System.out.println("Registration for telephone passed");
        } else {
            System.out.println("Yahoo!!,Bug detected for Telephone");
        }
        //Password
        String Expected_password_message = "Password must be between 4 and 20 characters!";
        String Actual_password_message = driver.findElement(By.cssSelector("#content > form > fieldset:nth-child(2) > div.form-group.required.has-error > div > div")).getText();
        if (Expected_password_message.equals(Actual_password_message)) {
            System.out.println("Registration for Password passed");
        } else {
            System.out.println("Yahoo!!,Bug detected for Password");
        }


    }
}


