package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
    public void fillField(WebElement element, String value) throws InterruptedException {
        element.click();
        element.clear();
        Thread.sleep(1000);
        element.sendKeys(value);
    }

}
