package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Registration extends TestBase {


    @Test
    public void registrationSuccessTest() {

        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fiilRegistrationForm("Lola", "Dow", "dow"+index+"@gmail.com", "Jj122234445");
        app.getUserHelper().chekPolicy();
        app.getUserHelper().submitForm();

        //app.getUserHelper().pause(2000);
        Assert.assertTrue(app.getUserHelper().isRegistrationSuccess());

    }

    @Test
    public void registrationSuccessModel() {
//object model
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        System.out.println(index);

        User user = new User().withName("Lola").withLastName("Dow").withEmail("dow"+index+"@gmail.com").withPassword("Jj122234445");

        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fiilRegistrationForm(user);
        app.getUserHelper().chekPolicy();
        app.getUserHelper().submitForm();

        //app.getUserHelper().pause(2000);
        Assert.assertTrue(app.getUserHelper().isRegistrationSuccess());

    }

}
