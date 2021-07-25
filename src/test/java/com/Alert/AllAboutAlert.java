package com.Alert;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AllAboutAlert extends TestBase {
    public static void main(String[] args){
        chromeLaunch();
        openTestURL("https://the-internet.herokuapp.com/javascript_alerts");
        normalAlert();
        confirmAlert();
        promptAlert();
        chromeClose();
    }
    public static void normalAlert(){
       // WebElement normalAltBtn=driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(1) > button"));
       // WebElement normalAltBtn2=elementByCSS("#content > div > ul > li:nth-child(1) > button");
        //normalAltBtn2.click();
        //driver.switchTo().alert().accept();
        getElementByCssAndClick("#content > div > ul > li:nth-child(1) > button");
        alertAccept();
    }

    public static void confirmAlert(){
    getElementByCssAndClick("#content > div > ul > li:nth-child(2) > button");
    alertCancel();
    }

    public static void promptAlert(){
    getElementByCssAndClick("#content > div > ul > li:nth-child(3) > button");
    driver.switchTo().alert().sendKeys("Test automation Rockzzz");
    alertAccept();
    }
}
