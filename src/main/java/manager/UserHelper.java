package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase {


    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']"));
        // click(By.cssSelector("[href='/login?url=%2Fsearch']"));
        //click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password)

    {
        type(By.cssSelector("#email"), email);
        type(By.cssSelector("#password"), password);
    }

    public void fillLoginForm(User user)

    {
        type(By.cssSelector("#email"), user.getEmail());
        type(By.cssSelector("#password"), user.getPassword());
    }

    public void submitForm() {

    click(By.cssSelector("[type='submit']"));
        //click(By.cssSelector("[type='submit']"));
        //click(By.xpath("//button[text()='Login']"));
        //click(By.xpath("//button[1]"));
}

    public void openRegistrationForm() {
        click(By.cssSelector("[href= '/registration?url=%2Fsearch']"));
        //wd.findElement(By.xpath("//a[text()=' Sign up ']"));

    }

    public void fiilRegistrationForm(String name, String lastName, String email, String password) {
        //if form displayed --->fill
        if(wd.findElement(By.tagName("form")).isDisplayed()){
        //fill form
            type(By.cssSelector("#name"), name);
            //type(By.id("name"),name);
        type(By.cssSelector("#lastName"), lastName);
        type(By.cssSelector("#email"), email);
        type(By.cssSelector("#password"), password);
    }
     }
    public void fiilRegistrationForm(User user) {
        //if form displayed --->fill
        if(wd.findElement(By.tagName("form")).isDisplayed()){
            //fill form
            type(By.cssSelector("#name"), user.getName());
            //type(By.id("name"),name);
            type(By.cssSelector("#lastName"), user.getLastName());
            type(By.cssSelector("#email"), user.getEmail());
            type(By.cssSelector("#password"), user.getPassword());
        }
    }

    public void chekPolicy() {

        if (!wd.findElement(By.id("terms-of-use")).isSelected())
        {
        click(By.xpath("//label[@for='terms-of-use']"));

    }

    }

    public boolean isRegistrationSuccess() {
        //dialog is displayed??
        //WebElement message = wd.findElement(By.cssSelector("h2.message"));
        WebDriverWait waite = new WebDriverWait(wd, 10);
        //waite.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));
         boolean in_success = waite.until(ExpectedConditions.textToBePresentInElement(wd.findElement(By.cssSelector("h2.message")), "You are logged in success"));

         return in_success;
        //String text = message.getText();
       // return text.equals("You are logged in success");

    }
    }
