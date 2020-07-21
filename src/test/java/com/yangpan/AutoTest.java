package com.yangpan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AutoTest {
    public static void main(String[] args) throws InterruptedException {

        /**
         * 驱动下载
         * https://chromedriver.storage.googleapis.com
         * 谷歌浏览器与chromedriver版本的对应关系可查看下载页面的notes.txt
         * 1.参考文章
         * https://www.cnblogs.com/xiaochangwei/p/8405591.html
         */




        // System.setProperty("webdriver.gecko.driver", "c://geckodriver.exe");
        // WebDriver webDriver = new FirefoxDriver();

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver_win32\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();





        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        // 与浏览器同步非常重要，必须等待浏览器加载完毕
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //打开目标地址
        webDriver.get("http://192.168.0.172:8082/employer-webapi/swagger-ui.html");
        webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/ul/li[1]/div/h2/a")).click();
        webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/ul/li[1]/ul/li[2]/ul/li/div[1]/h3/span[2]/a")).click();
        webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/ul/li[1]/ul/li[2]/ul/li/div[2]/form/table[1]/tbody/tr/td[2]/textarea")).sendKeys("{\n" +
                "  \"account\": \"13541292110\",\n" +
                "  \"accountEnum\": \"MASTER\",\n" +
                "  \"password\": \"123456\",\n" +
                "  \"validateCode\": \"string\"\n" +
                "}");
        webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/ul/li[1]/ul/li[2]/ul/li/div[2]/form/div[3]/input")).click();

        Thread.sleep(1000);
        String token = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/ul/li[1]/ul/li[2]/ul/li/div[2]/div[2]/div[4]/pre/code/span[15]")).getText();
        token = token.replaceAll("\"", "");
        System.out.println("=================" + token);
        webDriver.findElement(By.xpath("/html/body/div[1]/div/form/div[2]/div/a")).click();
        webDriver.findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/div[2]/div/div[1]/div/div[1]/div/div/div/div/div[2]/div[3]/input")).sendKeys(token);
        webDriver.findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/div[2]/div/div[1]/div/div[2]/button")).click();
        webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/ul/li[1]/div/h2/a")).click();
        // webDriver.quit();
    }
}