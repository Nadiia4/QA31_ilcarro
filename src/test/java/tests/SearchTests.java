package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTests extends TestsBase {

    @Test
    public void searchPeriodCurrentMonth() {

        app.search().fillSearchFormCurrentMonth("Tel Aviv, Israel", "1/30/2022", "1/31/2022");
        app.getUserHelper().submitForm();

        Assert.assertTrue(app.search().isListOfCarsAppeared());
// LocalDate

    }

    @Test
    public void searchPeriodCurrentMonth2() {

        app.search().fillSearchFormCurrentMonth("Tel Aviv, Israel", "1/31/2022", "1/31/2022");
        app.getUserHelper().submitForm();

        Assert.assertTrue(app.search().isListOfCarsAppeared());
// LocalDate

    }

    @AfterMethod
    public void preConditions() {
        app.getCarHelper().pause(3000);
        app.getCarHelper().buttonSearch();
    }

}