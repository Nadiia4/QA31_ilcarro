package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {//generaziya constryktora

        this.wd = wd;
    }

    public void type(By locator, String text) {//?????
        pause(2000);//????
        if (text != null && !text.isEmpty()) {
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }
//    public void type(By locator, String text) {
//        if (text != null && !text.isEmpty()) {
//            WebElement element = wd.findElement(locator);
//            element.click();
//            element.clear();
//            element.sendKeys(text);
//        }
    public void click(By locator) {

        wd.findElement(locator).click();
    }

    public void pause(int millis){

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public boolean  isElementPresent(By locator){
        return wd.findElements(locator).size()>0;

    }
    public void typeLocation(String address) {
        type(By.id("pickUpPlace"),address);
        click(By.cssSelector(".pac-item"));
        pause(500);
    }
}
