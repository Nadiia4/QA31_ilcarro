package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        pause(500);
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


    public void fillSearchFormInFuture(String city, String from, String to) {
        fillInputCity(city);
        selectAnyData(from, to);
    }

    public void fillSearchFormInPast(String city, String from, String to) {
        fillInputCity(city);
        typePastData(from, to);

    }

    private void typePastData(String datafrom, String dataTo) {

        typePast(By.id("dates"), datafrom + " - " + dataTo);

        //pause(7000);
    }

    private void typePast(By locator, String text) {
       // pause(2000);//????
        if (text != null && !text.isEmpty()) {
            //click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);

            // pause(2000);//????
            click(locator);
            WebElement label = wd.findElement(locator);
            Rectangle rect = label.getRect();


            int offSetX = rect.getWidth() / 2;
            int offSetY = rect.getHeight() / 2;

            Actions actions = new Actions(wd);
            actions.moveToElement(label).release().build().perform();

            System.out.println(offSetX + " " + offSetY);
            actions.moveByOffset(-offSetX, -offSetY).click().release().build().perform();
        }
    }

    private void selectAnyData(String dataFrom, String dataTo) {

        //"3/30/2022" "6/25/2022"
        //"3/30/2022" "1/31/2023"
        //"1/20/2023" "1/31/2023"

        LocalDate from = LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate to = LocalDate.parse(dataTo, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate now = LocalDate.now();

        click(By.id("dates"));

        int mouthDiff = from.getYear()-now.getYear()
                ==0 ? from.getMonthValue() - now.getMonthValue()
                : 12-now.getMonthValue() + from.getMonthValue();

        clickNextMonth(mouthDiff);
        String dataLocator = String.format("//div[text()=' %s ']",from.getDayOfMonth());//vmesto conkatinacii
        click(By.xpath(dataLocator));

        mouthDiff = to.getYear()- from.getYear()
                == 0 ? to.getMonthValue()- from.getMonthValue()
                : 12- from.getMonthValue() + to.getMonthValue();
        clickNextMonth(mouthDiff);

        dataLocator = String.format("//div[text()=' %s ']", to.getDayOfMonth());
        click(By.xpath(dataLocator));

    }


    private void clickNextMonth(int count) {
        for (int i = 0; i < count; i++) {
            click(By.cssSelector("button[aria-label='Next month']"));
        }

    }


    public boolean isErrorMessageDisplayed() {


        WebElement until = new WebDriverWait(wd, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='ng-star-inserted']")));//??????
        String text = until.getText();
        System.out.println(text);
       // pause(5000);
        return text.equals(" You can't pick date before today ");


    }

    public boolean isSubmitButtonNotActive() {

        if (!wd.findElement(By.cssSelector("[type='submit']")).isDisplayed()) {
            return true;
             //return !isElementPresent(By.cssSelector("[type='submit']"));
        }
        return false;
    }

    public void  fillSearchFromInPast1(String city,String from, String to){
        fillInputCity(city);
        typeInPeriodInPast(from, to);


    }

    private void typeInPeriodInPast(String from, String to) {

        type(By.id("dates"), from + " - " + to);
        click(By.cssSelector(".cdk-overlay-container"));
    }

    public boolean isDataInPast() {
        WebElement el = wd.findElement(By.cssSelector(".error.ng-star-inserted"));
        new WebDriverWait(wd, 10)
                .until(ExpectedConditions.textToBePresentInElement(el, "pick date before today"));

String text = el.getText();
System.out.println(text);
        //return text.equals(" You can't pick date before today ");
        return text.contains("pick date before today");

    }

    public boolean isDataInPast2() {//tot zhe method isDataInPast, ispolnen po drygomy
        WebElement el = wd.findElement(By.cssSelector(".error.ng-star-inserted"));
        String text = el.getText();

        new WebDriverWait(wd, 10)
                .until(ExpectedConditions.textToBePresentInElement(el, text));

        System.out.println(text);
        //return text.equals(" You can't pick date before today ");
        return text.contains("pick date before today");

    }

    public boolean isYallaButtonInactive() {

        return !wd.findElement(By.cssSelector("[type='submit']")).isEnabled();

    }
}
