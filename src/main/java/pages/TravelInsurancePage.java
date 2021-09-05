package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class TravelInsurancePage {
    @FindBy(xpath = "//div[contains(@class,'kitt-row page-teaser-dict__row')]")
    WebElement travelPage;

    public TravelInsurancePage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectButtonCreate(){
        travelPage.findElement(By.xpath(".//a[contains(@data-test-id,'PageTeaserDict_button')]")).click();
    }
}
