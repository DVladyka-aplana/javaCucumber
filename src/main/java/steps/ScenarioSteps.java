package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class ScenarioSteps {
    BaseSteps baseSteps = new BaseSteps();
    MainSteps mainSteps = new MainSteps();
    InsuranceSteps insuranceSteps = new InsuranceSteps();
    TravelInsuranceSteps travelInsuranceSteps = new TravelInsuranceSteps();
    SetValuesTravelInsuranceSteps setValuesTravelInsuranceSteps = new SetValuesTravelInsuranceSteps();

    @When("^выбран пункт меню \"(.+)\"$")
    public void selectMenuItem(String itemName){
        mainSteps.stepSelectMainMenu(itemName);
    }

    @When("^выбран подпункт меню \"(.+)\"$")
    public void selectSubMenuItem(String itemName){
        mainSteps.stepSelectSubMenu(itemName);
    }

    @When("^Проверена кнопка Cookies")
    public void checkCookiesButton(){
    baseSteps.checkCookieButton();
    }
    @When("^выбран вид страхования в карусели \"(.+)\"$")
    public void setElementCarousel(String carouselItem){
        insuranceSteps.selectInCarousel(carouselItem);
    }
    @When("^Проверен заголовок: \"(.+)\"$")
    public void checkHead(String exp){
        baseSteps.checkHead(exp);
    }
    @Then("Нажать на кнопку: Оформить")
    public void clickButtonCreateInsurance(){
        travelInsuranceSteps.stepClickButtonCreate();
    }
    @Then("^Проверен заголовок на странице ввода данных: \"(.+)\"$")
    public void checkHeadVal(String exp) {
        setValuesTravelInsuranceSteps.checkHead(exp);
    }
    @When("^Заполнено поле Регион: \"(.+)\"$")
    public void setReg(String reg){
        setValuesTravelInsuranceSteps.setRegionValue(reg);
    }
    @When("^Установлена сумма страховки: \"(.+)\"$")
    public void setSum(String sum){
        setValuesTravelInsuranceSteps.setSum(sum);
    }
    @Then("^Нажата кнопка: \"(.+)\"$")
    public void clickBut(String but){
        setValuesTravelInsuranceSteps.clickButtonNext(but);
    }
    @When("^заполняется поле:$")
    public void fillFormTo(DataTable fields){
        fields.<String,String>asMap(String.class, String.class)
                .forEach((field, value) -> {
                    try {
                        setValuesTravelInsuranceSteps.setValueTo(field, value);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

    }



    @Then("^поля заполнены:$")
    public void fillFormCheckTo(DataTable fields){
        fields.<String,String>asMap(String.class, String.class)
                .forEach((field, value) -> {
                    try {
                        setValuesTravelInsuranceSteps.checkValue(field, value);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }

    @When("^Проверить пол клиента: \"(.+)\"$")
    public void checkFemale(String male){
        setValuesTravelInsuranceSteps.chekFemale(male);
    }

    @Then("^Проверить главное сообщение об ошибке: \"(.+)\"$")
    public void checkMainErr(String mainErr){
        setValuesTravelInsuranceSteps.checkErrorPage(mainErr);
    }
    @Then("^сообщения в ячейках:$")
    public void checkCellErr(DataTable fields){
        fields.<String,String>asMap(String.class, String.class)
                .forEach((field, value) -> {
                    setValuesTravelInsuranceSteps.checkCellError(value, field);
                });
    }





}
