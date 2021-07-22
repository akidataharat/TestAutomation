package com.BrowserOptions;

import com.Base.TestBase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;

import java.io.File;

public class BrowserBinary extends TestBase {
    public static void main(String[] args){
        setBinary();
        chromeClose();

    }
    public static void setBinary(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        ChromeOptions crobj=new ChromeOptions();
        crobj.setBinary(new File("C:\\Users\\assd\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe"));
        driver=new ChromeDriver();
        driver.get("https://google.com");
    }
}
