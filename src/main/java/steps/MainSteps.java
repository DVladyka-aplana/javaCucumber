package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainSteps {
    @Step("На главной панели нажать кнопку: {0}")
    public void stepSelectMainMenu(String itemName){
        new MainPage().selectMenuItem(itemName);
    }
    @Step("В дочернем окне нажать на: {0}")
    public void stepSelectSubMenu(String itemName){
        new MainPage().menuSubItem(itemName);
    }

}
