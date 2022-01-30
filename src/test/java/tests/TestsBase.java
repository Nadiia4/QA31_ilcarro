package tests;

import manager.ApplicationManager;
import org.testng.annotations.*;

public class TestsBase {
    protected static ApplicationManager app = new ApplicationManager();


    @BeforeSuite
    public void setUp() {
        app.init();

    }

    @AfterSuite
    public void tearDown() {
        //app.stop();
    }



}