package com.TestNG;

import org.testng.annotations.Test;

public class TestNGBasic {
    @Test(enabled = false)
    public void TC_001(){
        System.out.println("Hello World");
    }

    @Test(priority = -2)
    public void TC_002(){
        System.out.println("Hello Bangladesh");
    }

    @Test(description = "Test Description")
    public void TC_003(){
        System.out.println("Hello Dhaka");
    }

    @Test(priority = -1)
    public void TC_004(){
        System.out.println("Hello Rajshahi");
    }
    @Test(groups = "Login Test")
    public void TC_005(){
        System.out.println("Hello Rajshahi1");
    }
}
