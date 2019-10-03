package testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Accuweather;
import pageObjects.Weather24;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class TestFile {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        //System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe"); //on the current machine, the chrome.driver path is specified within the environment variables in system settings
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        String baseUrl = "http://weather.news24.com";
        driver.get(baseUrl);
    }

    @Test
    public void testWeather24() throws Exception {

        Weather24 weather24 = PageFactory.initElements
                (driver, Weather24.class);

        weather24.selectCity();
        weather24.CityName();
        weather24.clickGo();
        weather24.clickExpandedForecast();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[3]/td[4]")));

        //store minimum and maximum temperature values in a String array
        String[] weatherMaxTemperatures = new String[5];
        String[] weatherMinTemperatures = new String[5];

        //populating the String arrays by findElement by xpath and getText().
        weatherMaxTemperatures[0] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[3]/td[4]")).getText();
        weatherMaxTemperatures[1] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[4]/td[4]")).getText();
        weatherMaxTemperatures[2] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[5]/td[4]")).getText();
        weatherMaxTemperatures[3] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[6]/td[4]")).getText();
        weatherMaxTemperatures[4] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[7]/td[4]")).getText();

        //populate String array for minimum temperatures.
        weatherMinTemperatures[0] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[3]/td[5]")).getText();
        weatherMinTemperatures[1] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[4]/td[5]")).getText();
        weatherMinTemperatures[2] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[5]/td[5]")).getText();
        weatherMinTemperatures[3] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[6]/td[5]")).getText();
        weatherMinTemperatures[4] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[7]/td[5]")).getText();

        //opening the accuweather url
        String accuURL = "https://www.accuweather.com";
        driver.get(accuURL);
        Thread.sleep(3000);
        Accuweather accuweather = PageFactory.initElements(driver, Accuweather.class);
        accuweather.query();
        driver.findElement(By.xpath("./html/body/div/div[1]/div[2]/div[1]/form/input")).sendKeys(Keys.ENTER);
        accuweather.selectLocation();
        accuweather.clickDaily();

        //store minimum and maximum temperature values in a String array
        String[] accuMaxTemperatures = new String[5];
        String[] accuMinTemperatures = new String[5];

        Thread.sleep(3000);

        //populating the String arrays by findElement by xpath and getText().
        accuMaxTemperatures[0] = driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[2]/span[1]")).getText() + "C";
        accuMaxTemperatures[1] = driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div/div[1]/a[2]/div[2]/span[1]")).getText() + "C";
        accuMaxTemperatures[2] = driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div/div[1]/a[3]/div[2]/span[1]")).getText() + "C";
        accuMaxTemperatures[3] = driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div/div[1]/a[4]/div[2]/span[1]")).getText() + "C";
        accuMaxTemperatures[4] = driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div/div[1]/a[5]/div[2]/span[1]")).getText() + "C";

        //populate String array for minimum temperatures.
        accuMinTemperatures[0] = driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[2]/span[2]")).getText().substring(2) + "C";
        accuMinTemperatures[1] = driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div/div[1]/a[2]/div[2]/span[2]")).getText().substring(2) + "C";
        accuMinTemperatures[2] = driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div/div[1]/a[3]/div[2]/span[2]")).getText().substring(2) + "C";
        accuMinTemperatures[3] = driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div/div[1]/a[4]/div[2]/span[2]")).getText().substring(2) + "C";
        accuMinTemperatures[4] = driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div/div[1]/a[5]/div[2]/span[2]")).getText().substring(2) + "C";

        //creating an array to store values for days
        String[] accuDays = new String[5];

        accuDays[0] = driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[1]/p[1]")).getText();
        accuDays[1] = driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div/div[1]/a[2]/div[1]/p[1]")).getText();
        accuDays[2] = driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div/div[1]/a[3]/div[1]/p[1]")).getText();
        accuDays[3] = driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div/div[1]/a[4]/div[1]/p[1]")).getText();
        accuDays[4] = driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div/div[1]/a[5]/div[1]/p[1]")).getText();

        //Created FOR LOOP with IF STATEMENT to display and compare the maximum temperature arrays
        System.out.println("<<<<< COMPARE MAXIMUM TEMPERATURES >>>>>");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Day" + "          " + "|Weather24" + "         " + "|Accuweather" + "            " + "|Comment");
        System.out.println("------------------------------------------------------------------------------------------");
        for (int x = 0; x <= 4; x++) {

            if (weatherMaxTemperatures[x].equals(accuMaxTemperatures[x])) {
                System.out.println(accuDays[x] + "          " + weatherMaxTemperatures[x] + "                 " + accuMaxTemperatures[x] + "                    " + "The temperatures are the same.");
            }

            else {
                System.out.println(accuDays[x] + "          " + weatherMaxTemperatures[x] + "                 " + accuMaxTemperatures[x] + "                    " + "The temperatures are different.");
            }
        }

        System.out.println("\n");

        //Created FOR LOOP with IF STATEMENT to display and compare the minimum temperature arrays
        System.out.println("<<<<< COMPARE MINIMUM TEMPERATURES >>>>>");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Day" + "          " + "|Weather24" + "         " + "|Accuweather" + "            " + "|Comment");
        System.out.println("------------------------------------------------------------------------------------------");
        for (int j = 0; j <= 4; j++) {

            if (weatherMinTemperatures[j].equals(accuMinTemperatures[j])) {
                System.out.println(accuDays[j] + "          " + weatherMinTemperatures[j] + "                 " + accuMinTemperatures[j] + "                    " + "The temperatures are the same.");
            }
            else {
                System.out.println(accuDays[j] + "          " + weatherMinTemperatures[j] + "                 " + accuMinTemperatures[j] + "                    " + "The temperatures are different.");
            }
        }
    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}

