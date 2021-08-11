package com.ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utils.Log;
import com.utils.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login_Extent {
    //Extent report
    ExtentHtmlReporter htmlReporter;
    ExtentReports report;
    ExtentTest logger;


    WebDriver driver;

    String LoginURL = "https://demo.opencart.com/index.php?route=account/login";
    @BeforeClass
    @Parameters("Browser")
    public void initSetup(String browserName) {

        if(browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
            Log.info("Chrome Launch successfully.");
        }


    }
    @AfterClass
    public void tearDown() {
        driver.close();
        Log.info("Chrome close successfully.");
    }

    @Test
    public void TC_001_InValid() {
        //Extent
        htmlReporter=new ExtentHtmlReporter("./Extent-Report/LoginTestReport.html");
        report =new ExtentReports();
        report.attachReporter(htmlReporter);

        //Extent Optional
        report.setSystemInfo("OS","Windows 10");
        report.setSystemInfo("Tester","Akida");
        report.setSystemInfo("Environment","Test");

        logger=report.createTest("Login Test");

        driver.get(LoginURL);
        Log.info("Login page open successfully");
        logger.log(Status.INFO,"Login page open successfully");

        //Excel
        Xls_Reader reader=new Xls_Reader("./src/test/resources/LoginData.xlsx");
        String sheetName="Sheet1";
        int rowCount=reader.getRowCount(sheetName);

        for (int rowNum=2; rowNum<=rowCount;rowNum++){
            String email=reader.getCellData(sheetName,"Email", rowNum);
            String password=reader.getCellData(sheetName,"Password",rowNum);

            WebElement Email = driver.findElement(By.id("input-email"));
            Email.clear();
            Email.sendKeys(email);
            Log.info("Type Email:"+email);
            logger.log(Status.INFO,"Type Email:"+email);

            //step3
            WebElement Password = driver.findElement(By.id("input-password"));
            Password.clear();
            Password.sendKeys(password);
            Log.info("Type password:"+password);
            logger.log(Status.INFO,"Type password:"+password);


            WebElement LoginBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
            LoginBtn.click();
            Log.info("Click on Login Button");
            logger.log(Status.INFO,"Click on Login Button");

            //Logic Develop
            //Login Pass
            String Exp_Title = "Account Login";
            String Act_Title = driver.getTitle();

            if (Exp_Title.equals(Act_Title)) {
                //Excel write
                reader.setCellData(sheetName,"Result",rowNum,"Not Login(Login passed for invalid)");
                logger.log(Status.PASS,"Not Login. Test Passed.");
            }
            else {
                //Excel write
                reader.setCellData(sheetName,"Result",rowNum,"Login(Login failed for invalid)");
                logger.log(Status.FAIL,"Login. Test Failed.");
            }

            //Assertion
            Assert.assertEquals(Act_Title, Exp_Title);
            //Logout
            // WebElement logout = driver.findElement(By.linkText("Logout"));
            //logout.click();
            report.flush();
        }
    }
}

