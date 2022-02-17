package tests;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestsBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        // if logged [logout present???] ---> logout

        if (app.getUserHelper().isLogOutPresent()) {
            app.getUserHelper().logout();
        }
    }


    @Test
    public void loginSuccess() {
logger.info("The test start with email : [lenastep@gmail.com] & password : [12345nnnN]");
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm("lenastep@gmail.com", "12345nnnN");
        app.getUserHelper().submitForm();

        app.getUserHelper().takeScreenShot("src/test/screenShots/scr1.png");

        // click ok

        //Assert
    }
    @Test(dataProvider = "loginValidData",dataProviderClass = MyDataProvider.class)
    //test ispolnitsya tri raza, t.k. v methode MyDataProvider estj tri zapisi(3 rtochki s 3 email i password)
    public void loginSuccessDataProvider(String email, String password) {
        logger.info("The test start with email :" +email + " & password :" +password);
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(email, password);
        app.getUserHelper().submitForm();

        app.getUserHelper().takeScreenShot("src/test/screenShots/scr1.png");

        // click ok

        //Assert
    }

    @Test(groups = {"web"})
    public void loginSuccessModel() {

        User user = new User().withEmail("lenastep@gmail.com").withPassword("12345nnnN");
logger.info("The test start with data: " + user.toString());
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(user);
        app.getUserHelper().submitForm();
        //click ok

        //Assert
    }
    @Test(dataProvider = "loginValidDataModel", dataProviderClass = MyDataProvider.class)
    public void loginSuccessModelDataProvider(User user) {

        logger.info("The test start with data: " + user.toString());
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(user);
        app.getUserHelper().submitForm();
        //click ok

        //Assert
    }


    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        app.getUserHelper().pause(500);
        app.getUserHelper().clickOkButton();

    }

}