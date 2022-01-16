package tests;

import org.testng.annotations.Test;

public class Registration extends TestBase {


    @Test
    public void registrationSuccessTest() {

        // int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fiilRegistrationForm("Lola", "Dow", "dow555@gmail.com", "Jj122234445");
        app.getUserHelper().chekPolicy();
        app.getUserHelper().submitForm();

    }

}
