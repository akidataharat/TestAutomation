package com.BrowserOptions;

import com.Base.TestBase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSL extends TestBase {
    public static void main(String[] args){
        insecureTest();
        chromeClose();

    }
    public static void insecureTest(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        ChromeOptions crobj=new ChromeOptions();
        crobj.setAcceptInsecureCerts(true);
        driver=new ChromeDriver();
        driver.get("http://www.cacert.org/");
        String TitleAfterAccept= driver.getTitle();
        System.out.println(TitleAfterAccept);
    }
}
