package com.Navigation;

import com.Base.TestBase;

public class NavigationTest extends TestBase {
    public static void main(String[] args){
        chromeLaunch();
        openTestURL("https://demo.opencart.com/");
        navigateTo();
        navigateBack();
        navigateForward();
        chromeClose();
    }
    public static void navigateTo(){
        driver.navigate().to("https://google.com");
        System.out.println("Navigate to " +driver.getTitle());
    }
    public static void navigateBack(){
        driver.navigate().back();
        System.out.println("Navigate back to " +driver.getTitle());

    }
    public static void navigateForward(){
       driver.navigate().forward();
        System.out.println("Navigate forward to " +driver.getTitle());
    }
    public static void navigateRefresh(){
        driver.navigate().refresh();
    }
    }

