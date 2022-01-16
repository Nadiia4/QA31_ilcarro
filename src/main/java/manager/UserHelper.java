package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public void submitForm() {

    click(By.cssSelector("[type='submit']"));
        //click(By.cssSelector("[type='submit']"));
        //click(By.xpath("//button[text()='Login']"));
        //click(By.xpath("//button[1]"));
}

    public void openRegistrationForm() {
        click(By.cssSelector("[href= '/registration?url=%2Fsearch']"));

    }

    public void fiilRegistrationForm(String name, String lastName, String email, String password) {
        type(By.cssSelector("#name"), name);
        type(By.cssSelector("#lastName"), lastName);
        type(By.cssSelector("#email"), email);
        type(By.cssSelector("#password"), password);

     }


    public void chekPolicy() {
        click(By.cssSelector("label[for='terms-of-use']"));//??????


    }
}
