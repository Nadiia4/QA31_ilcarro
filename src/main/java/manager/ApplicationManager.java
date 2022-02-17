package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
   // WebDriver wd;
    EventFiringWebDriver wd;
    UserHelper userHelper;
    CarHelper carHelper;
    HelperSearch search;//obyavlyaem
    String browzer;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);//ekzemplyar loggera

    public ApplicationManager(String browzer) {
        this.browzer = browzer;
    }

    public void init(){
        //wd = new ChromeDriver();

        if(browzer.equals(BrowserType.CHROME)){
            WebDriverManager.chromedriver().setup();//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!dlya vipolneniya testov v chrome
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("All tests strts in 'Chrome' browser" );
        }else if(browzer.equals(BrowserType.FIREFOX)){

            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("All tests strts in 'FIREFOX' browser" );
        } else if(browzer.equals(BrowserType.EDGE)){

        wd = new EventFiringWebDriver(new EdgeDriver());
        logger.info("All tests strts in 'EDGE' browser" );
    }
//
//        wd = new EventFiringWebDriver(new ChromeDriver());
//        logger.info("All tests strts in 'Chrome' browser" );
        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.xyz/search");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wd.register(new MyListener());

        userHelper = new UserHelper(wd);
        carHelper = new CarHelper(wd);
        search = new HelperSearch(wd);//inicializiruem
    }

    public void stop(){
        wd.quit();
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public CarHelper getCarHelper() {
        return carHelper;
    }
    public HelperSearch search(){
        return search;
    }//daem getter
}