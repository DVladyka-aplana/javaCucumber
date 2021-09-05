package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SetValuesTravelInsurancePage;

import static org.junit.Assert.assertEquals;

public class SetValuesTravelInsuranceSteps {
    @Step("Заполнить поле: {0}; Значение: {1}")
    public void setValueTo(String cellTo, String valueTo) throws InterruptedException {
        new SetValuesTravelInsurancePage().fillFieeld(cellTo,valueTo);
    }
    @Step("Проверить поле: {1}; Ожидаемое значение: {0}")
    public void checkValue(String waitValue, String cellName) throws InterruptedException {
        new SetValuesTravelInsurancePage().getFillField(waitValue, cellName);
    }
    @Step("Заполнить поле Регион: {0}")
    public void setRegionValue(String regionValue){
        new SetValuesTravelInsurancePage().setRegion(regionValue);
    }
    @Step("Установить объем страховки (минимальная/максимальная): {0}")
    public void setSum(String sumValue){
        new SetValuesTravelInsurancePage().setSum(sumValue);
    }
    @Step("Нажать на кнопку: {0}")
    public void clickButtonNext(String buttonName){
        new SetValuesTravelInsurancePage().clickButton(buttonName);
    }
    @Step("Проверить пол клиента: {0}")
    public void chekFemale(String femaleValue){
        new SetValuesTravelInsurancePage().checkFemale(femaleValue);
    }
    @Step("Проверить отображение сообщения об ошибке: {0}")
    public void checkErrorPage(String textError){
        new SetValuesTravelInsurancePage().checkErrorMessage(textError);
    }
    @Step("Проверить что в ячейке: {1} - отображается сообщение: {0}")
    public void checkCellError(String waitErr, String cellName){
        new SetValuesTravelInsurancePage().checkCellErrorMessage(waitErr, cellName);
    }
    @Step("Проверка заголовка - {2}")
    public void checkHead(String exp){
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(BaseSteps.getDriver().findElement(By.xpath("//h2[contains(text(),'Страхование путешественников')]"))));
        assertEquals(exp,BaseSteps.getDriver().findElement((By.xpath("//h2[contains(text(),'Страхование путешественников')]"))).getText());
    }
}
