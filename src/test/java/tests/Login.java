package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Login extends TestBase{



    @Test
    public void loginSuccessTest() throws InterruptedException {
        //open login form
        click(By.cssSelector("[href='/login?url=%2Fsearch']"));
        //fill email
        type(By.cssSelector("#email"), "lenastep@gmail.com");
        //fill password
        Thread.sleep(5000);
        type(By.cssSelector("#password"),"12345nnnN");
        //confirm login - click login button
        click(By.cssSelector("[type='submit']"));
        //click(By.xpath("//button[text()='Login']"));
        //click(By.xpath("//button[1]"));

    }


}