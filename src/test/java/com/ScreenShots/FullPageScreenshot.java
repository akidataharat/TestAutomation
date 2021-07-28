package com.ScreenShots;

import com.Base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FullPageScreenshot extends TestBase {
    public static void main(String[] args) throws IOException{
        chromeLaunch();
        openTestURL("https://www.bbc.com/");
        fullPageScreenshot();

    }
    public static void fullPageScreenshot() throws IOException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Scroll down the page
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        //Open the stay details page
        jse.executeScript("window.scrollBy(0,250)", "");

        //take screenshot
        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(fpScreenshot.getImage(),"PNG",new File("./src/test/Screenshots/FullBBCPageImage.png"));
    }
}
