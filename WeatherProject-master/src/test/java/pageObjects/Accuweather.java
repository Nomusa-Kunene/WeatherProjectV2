package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Accuweather {

    //identified web elements for accuweather and declared them as private variables
    @FindBy(how = How.XPATH, using = "./html/body/div/div[1]/div[2]/div[1]/form/input")
    private WebElement query;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[5]/div/div[1]/div[1]/div[1]/a[1]")
    private WebElement selectLocation;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[4]/div/div/div[3]/a[4]")
    private WebElement clickDaily;

    //created class methods to access the elements.
    //the query method clicks on the search bar, clears it and enters city name "Bloemfontein"
    public void query(){
        query.click();
        query.clear();
        query.sendKeys("Bloemfontein");
    }

    //selects the first location option displayed
    public void selectLocation(){
        selectLocation.click();
    }

    //clicks on the daily tab
    public void clickDaily(){
        clickDaily.click();
    }

}
