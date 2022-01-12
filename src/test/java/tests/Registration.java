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

public class Registration extends TestBase{


    @Test
    public void registrationSuccessTest(){
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        //open form
        click(By.cssSelector("[href= '/registration?url=%2Fsearch']"));
        //fill name
        type(By.cssSelector("#name"), "nadiia"+ index);
        //fill lastName
        type(By.cssSelector("#lastName"), "borysova"+ index);
        //fill Email
        type(By.cssSelector("#email"), "nadiia" + index + "@gmail.com");
        //fill password
        type(By.cssSelector("#password"),"12345nnnN");

        //fill checkbox???????????????????
        //wd.findElement(By.xpath("//label[contains(text(),'I agree to the')]")).isSelected();
        click(By.xpath("//label[contains(text(),'I agree to the')]"));
        //wd.findElement(By.cssSelector(".checkbox-container")).submit();

        //submit registration
        click(By.cssSelector("[type='submit']"));

    }


}
