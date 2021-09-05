package steps;

import io.qameta.allure.Step;
import pages.TravelInsurancePage;

public class TravelInsuranceSteps {
    @Step("Нажать на кнопку: Оформить")
    public void stepClickButtonCreate(){
        new TravelInsurancePage().selectButtonCreate();
    }
}
