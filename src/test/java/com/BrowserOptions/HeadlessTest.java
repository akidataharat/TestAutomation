package com.BrowserOptions;

import com.Base.TestBase;
import com.OpenCart.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.io.IOException;

public class HeadlessTest extends TestBase{
    public static WebDriver driver;
    public static void main(String[] args) throws IOException{
    ChromeBrowserHeadless();
    chromeClose();
    }
    public static void ChromeBrowserHeadless() throws IOException{
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        ChromeOptions crobj=new ChromeOptions();
        crobj.setHeadless(true);
        driver=new ChromeDriver(crobj);
        Login.TC_001_Valid();
        System.out.println("Headless ChromeTest Done");
    }
    }


