package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTests extends TestsBase {

    @Test
    public void searchPeriodCurrentMonth() {

        app.search().fillSearchFormCurrentMonth("Tel Aviv, Israel", "1/31/2022", "1/31/2022");
        app.getUserHelper().submitForm();

        Assert.assertTrue(app.search().isListOfCarsAppeared());
// LocalDate

    }

    @Test
    public void searchPeriodCurrentMonth2() {

        app.search().fillSearchFormCurrentMonth("Rehovot, Israel", "2/04/2022", "2/05/2022");
        app.getUserHelper().submitForm();

        Assert.assertTrue(app.search().isListOfCarsAppeared());
// LocalDate - class java - on znaet tekushuy daty

    }
@Test
    public void searchPeriodAnyDataInFuture(){

        //"3/30/2022" "6/25/2022"
        //"3/30/2022" "1/31/2023"
        //"1/20/2023" "1/31/2023"

        app.search().fillSearchFormInFuture("Tel Aviv, Israel", "02/03/2023","02/04/2023");
        app.search().pause(7000);
        app.getUserHelper().submitForm();

        Assert.assertTrue(app.search().isListOfCarsAppeared());
    }

    @Test
    public void searchPeriodAnyDataInPast(){

        app.search().fillSearchFormInPast("Tel Aviv, Israel", "1/30/2022","1/31/2022");
        //app.search().pause(5000);

        Assert.assertTrue(app.search().isErrorMessageDisplayed());
        Assert.assertTrue(app.search().isSubmitButtonNotActive());

    }

    @AfterMethod
    public void posConditions() {
        app.getCarHelper().pause(3000);//????
        app.getCarHelper().buttonSearch();
    }

}