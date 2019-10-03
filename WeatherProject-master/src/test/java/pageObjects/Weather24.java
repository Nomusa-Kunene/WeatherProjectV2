package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Weather24 {
    //identified web elements for weather24 and declared them as private variables
    @FindBy(how = How.XPATH, using = "//*[@id=\"ctl00_WeatherContentHolder_ddlCity\"]")
    private WebElement cityDropDown;
    @FindBy(how = How.XPATH, using = "//*[@id=\"ctl00_WeatherContentHolder_ddlCity\"]/option[11]")
    private WebElement CityName;
    @FindBy(how = How.XPATH, using = "//*[@id=\"ctl00_WeatherContentHolder_btnGo\"]")
    private WebElement btnGo;
    @FindBy(how = How.XPATH, using = "//*[@id=\"ext-gen32\"]")
    private WebElement weatherForecast;


    //created class methods to access the elements.
    //click on the drop down for city
    public void selectCity(){
        cityDropDown.click();
    }

    //select city "Bloemfontein"
    public void CityName(){
        CityName.click();
    }

    //click on the Go button
    public void clickGo() {
        btnGo.click();
    }

    //select the 7 day weather forecast
    public void clickExpandedForecast() {
        weatherForecast.click();
    }
}
