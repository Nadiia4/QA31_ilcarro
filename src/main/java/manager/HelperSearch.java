package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperSearch extends HelperBase {

    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void fillSearchFormCurrentMonth(String city, String dateFrom, String dateTo) {
        fillInputCity(city);
        pause(4000);
        selectPeriodCurrentMonth(dateFrom, dateTo);
    }

    private void fillInputCity(String city) {
        type(By.id("city"), city);
        click(By.cssSelector(".pac-item"));
        pause(500);

    }

    public void selectPeriodCurrentMonth(String dateFrom, String dateTo) {
        //     1/28/2022 - 1/30/2022 -----> 28 - 30
        click(By.id("dates"));
        wd.findElement(By.id("dates")).clear();//!!!!!!!!!!!!!!

        String[] dataF = dateFrom.split("/"); //--->>>> [1],[28],[2022] ----> get[1] = 28
        String[] dataT = dateTo.split("/"); // ---->>>> [1], [30], [2022]  ---->get[1] = 30

        String locator = "//div[text()=' " + dataF[1] + " ']"; //     //div[text()=' 28 ']
        String loc = String.format("//div[text()=' %s ']",dataF[1]);  //div[text()=' 28 ']

        click(By.xpath(locator)); // 28

        String locator2 = "//div[text()=' " + dataT[1] + " ']";
        click(By.xpath(locator2));
        pause(5000);

    }


    public boolean isListOfCarsAppeared() {
        return isElementPresent(By.cssSelector(".search-results"));
    }
}
