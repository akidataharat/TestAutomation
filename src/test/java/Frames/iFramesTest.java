package Frames;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class iFramesTest extends TestBase {
    public static void main(String[] args){
     chromeLaunch();
     openTestURL("https://www.w3schools.com/html/html_iframe.asp");
    singleFrames();
    chromeClose();
    }
    public static void singleFrames(){
//locate iFrame
        WebElement iFrame=driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/iframe"));
        driver.switchTo().frame(iFrame);
        WebElement css=driver.findElement(By.xpath("//*[@id=\"topnav\"]/div/div/a[4]"));
        css.click();

    }
}
