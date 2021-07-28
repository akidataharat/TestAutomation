 package com.TestNG;

import org.testng.annotations.*;

public class AnnotationsOrder {

    @BeforeSuite
    public void SuiteSetup(){
        System.out.println("Suite Setup Done");
    }

    @BeforeTest
    public void TestSetup(){
        System.out.println("Test setup Done");
    }

    @BeforeClass
    public void ClassSetup(){
        System.out.println("Class setup Done");
    }

    @BeforeMethod
    public void MethodSetup(){
        System.out.println("Method Setup Done");
    }

    @Test
    public void TC_001(){
        System.out.println("Hello World");
    }

    @Test
    public void TC_002(){
        System.out.println("Hello Bangladesh");
    }

    @AfterMethod
    public void MethodExecute(){
        System.out.println("After method Done");
    }

    @AfterClass
    public void ClassExecute(){
        System.out.println("After class Done");
    }

    @AfterTest
    public void TestExecute(){
        System.out.println("After Test Done ");
    }

    @AfterSuite
    public void SuiteExecute(){
        System.out.println("After suite Done");
    }
}
