package com.yangpan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by yangpan on 2020-06-24 17:17.
 */
public class AutoCreateGoods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver_win32\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
    }
}
