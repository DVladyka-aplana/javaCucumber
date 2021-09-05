package steps;

import io.qameta.allure.Step;
import pages.InsurancePage;

public class InsuranceSteps {
    @Step("Выбрать из списка услуг: {0}")
    public void selectInCarousel(String carouselItem){
        new InsurancePage().selectMenuCarousel(carouselItem);
    }

}
