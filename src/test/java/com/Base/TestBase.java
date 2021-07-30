package com.Base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TestBase {
    public static WebDriver driver;

    public static void main(String[] args) throws IOException{
        chromeLaunch();
        chromeClose();
        //firefoxLaunch();
        //firefoxClose();
    }
    public static void chromeLaunch(){

        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        System.out.println("Chrome Launch Successfully!!!");
    }

    /*public static void firefoxLaunch(){
        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
        driver=new FirefoxDriver();
        System.out.println("Firefox Launch Successfully!!!");
    }*/
    public static void openTestURL(String URL) {

        driver.get(URL);
    }

    public static WebElement elementByCSS(String locator){

        return driver.findElement(By.cssSelector(locator));
    }

    public static WebElement elementByXpath(String locator){

        return driver.findElement(By.xpath(locator));
    }

    public static WebElement elementById(String locator){

        return driver.findElement(By.id(locator));
    }

    public static WebElement elementByName(String locator){

        return driver.findElement(By.name(locator));
    }

    public static void getElementByCssAndClick(String locator){

        driver.findElement(By.cssSelector(locator)).click();
    }

    public static void getElementByCssAndType(String locator, String text){

        driver.findElement(By.cssSelector(locator)).sendKeys(text);

    }
    public static void getElementByIdAndType(String locator, String text) {

        driver.findElement(By.id(locator)).sendKeys(text);
    }

        public static void getElementByIdAndClick(String locator){

            driver.findElement(By.id(locator)).click();

    }
    public static void getElementByXpathAndType(String locator, String text){

        driver.findElement(By.xpath(locator)).sendKeys(text);

    }
    public static void getElementByXpathAndClick(String locator){

        driver.findElement(By.xpath(locator)).click();

    }

    public static void alertAccept(){

        driver.switchTo().alert().accept();
    }

    public static void alertCancel() {

        driver.switchTo().alert().dismiss();
    }

    public static void captureScreenshot(String name, String format) throws IOException {
        //take screenshot
        File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //save image
        FileUtils.copyFile(srcFile,new File("./src/test/Screenshots/" +name+ format),true);

    }

    public static void chromeClose(){
        driver.close();
        System.out.println("Chrome Closed!!!");
    }
    /*public static void firefoxClose(){
        driver.close();
        System.out.println("Firefox Closed!!!");
    }*/

}
