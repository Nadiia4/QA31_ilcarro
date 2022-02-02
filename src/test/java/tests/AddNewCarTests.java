package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestsBase{

    @BeforeMethod
    public void preCondition(){
        // if !logged ---> login()

        if(!app.getUserHelper().isLogOutPresent()){
            User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");
            app.getUserHelper().login(user);
        logger.info("Car was added for user " + user.toString());
        }
    }

    @Test
    public void addNewCarSuccess(){
        // model ---open carform ---> fill carForm --- attachPhoto ---submitBTN
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        System.out.println(index);

        Car car = Car.builder()
                .address("Tel Aviv, Israel")
                .make("BMW")
                .model("M5")
                .year("2020")
                .engine("2.5")
                .fuel("Petrol")
                .gear("MT")
                .wD("AWD")
                .doors("5")
                .seats("4")
                .clasS("C")
                .fuelConsumption("6.5")
                .carRegNumber("102-33-"+index)
                .price("65")
                .distanceIncluded("500")
                .features("type of")
                .about("Very good car")
                .build();

logger.info("Car was added " + car.toString());

        app.getCarHelper().openCarForm();
        app.getCarHelper().fillCarForm(car);
        app.getCarHelper().attachPhoto("C:/Users/Nadii/QA31_ilcarro/bmww.jfif");
        app.getCarHelper().submitForm();

        Assert.assertTrue(app.getCarHelper().isCarAdded());
    }
    @Test
    public void addNewCarSuccess2(){
        // model ---open carform ---> fill carForm --- attachPhoto ---submitBTN
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        System.out.println(index);

        Car car = Car.builder()
                .address("Tel Aviv, Israel")
                .make("BMW")
                .model("M5")
                .year("2020")
                .engine("2.5")
                .fuel("Petrol")
                .gear("MT")
                .wD("AWD")
                .doors("5")
                .seats("4")
                .clasS("C")
                .fuelConsumption("6.5")
                .carRegNumber("102-33-"+index)
                .price("65")
                .distanceIncluded("500")
                .features("type of")
                .about("Very good car")
                .build();

        logger.info("Car was added " + car.toString());

        app.getCarHelper().openCarForm();
        app.getCarHelper().fillCarForm(car);
        app.getCarHelper().attachPhoto("C:/Users/Nadii/QA31_ilcarro/bmww.jfif");
        app.getCarHelper().submitForm();

        Assert.assertTrue(app.getCarHelper().isCarAdded());
    }

    @AfterMethod
    public void postConditions(){
        app.getCarHelper().clickSearchButton();
        app.getUserHelper().logout();

    }
}






