package steps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class BaseSteps {
    protected static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    @Before
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.sberbank.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @After
    public static void tearDown() throws Exception {
        driver.quit();
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    @Step("<<<Проверка на наличие всплывающего сообщения Cookies>>>")
    public void checkCookieButton() {
        if (!driver.findElements(By.xpath("//div[contains(@class,'kitt-cookie-warning')][contains(@style,'display: block;')]//button[contains(@class,'kitt-cookie-warning__close')]")).isEmpty()) {
            driver.findElement(By.xpath("//button[contains(@class,'kitt-cookie-warning__close')]")).click();
        }
    }
    @Step("Проверка заголовка - {2}")
    public void checkHead(String exp){
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Страхование путешественников')][contains(@class,'kitt-heading')]"))));
        assertEquals(exp,driver.findElement((By.xpath("//*[contains(text(),'Страхование путешественников')][contains(@class,'kitt-heading')]"))).getText());
    }
}
