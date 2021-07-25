package com.EndToEndTestAutomation;

import com.Base.TestBase;

public class EndToEndTest extends TestBase {
    public static void main(String[] args){
        chromeLaunch();
        openTestURL("https://demo.opencart.com/index.php?route=account/register");
    }

}
