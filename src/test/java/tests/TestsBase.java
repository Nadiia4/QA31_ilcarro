package tests;

import manager.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestsBase {
    protected static ApplicationManager app = new ApplicationManager();

    Logger logger = LoggerFactory.getLogger(TestsBase.class);


    @BeforeMethod
    public  void startLogger(Method m){
        logger.info("Name of test ----->" + m.getName());
    }

    @BeforeSuite
    public void setUp() {
        app.init();

    }

    @AfterSuite
    public void tearDown() {
        //app.stop();
    }



}