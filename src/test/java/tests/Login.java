package tests;

import models.User;
import org.testng.annotations.Test;

public class Login extends TestBase {


      @Test
    public void loginSuccessTest() throws InterruptedException {

        app.getUserHelper().openLoginForm();

        app.getUserHelper().fillLoginForm("lenastep@gmail.com", "12345nnnN");

        app.getUserHelper().submitForm();

    }


    @Test
    public void loginSuccessModel() throws InterruptedException {
        User user = new User().withEmail("lenastep@gmail.com").withPassword("12345nnnN");

        app.getUserHelper().openLoginForm();

        app.getUserHelper().fillLoginForm(user.getEmail(), user.getPassword());

        app.getUserHelper().submitForm();

    }


}