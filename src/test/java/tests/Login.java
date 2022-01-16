package tests;

import org.testng.annotations.Test;

public class Login extends TestBase {


      @Test
    public void loginSuccessTest() throws InterruptedException {

        app.getUserHelper().openLoginForm();

        app.getUserHelper().fillLoginForm("lenastep@gmail.com", "12345nnnN");

        app.getUserHelper().submitForm();

    }


}