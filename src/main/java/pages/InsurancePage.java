package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class InsurancePage {

    @FindBy(xpath = "//div[contains(@class,'product-catalog__carousel_row')]")
    WebElement insurancePage;

    public InsurancePage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
    public void selectMenuCarousel(String itemName){
        insurancePage.findElement(By.xpath(".//div[contains(@data-product,'"+itemName+"')]")).click();
    }
}
