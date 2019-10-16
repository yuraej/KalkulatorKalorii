package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.InputFields;

public class InputData {
    WebDriver driver;
    InputFields input = new InputFields(driver);
    @Step("ввод корректных данных")
    public void inputCorrectData(int age, int weight, int growth) {
        input.enterDataFieldAge(age)
                .enterDataFieldWeight(weight)
                .enterDataFieldGrowth(growth)
                .getCalculate();
    }
    @Step("ввод не корретных данных")
    public void inputWrongData(String age, String weight, String growth) {
        input.enterDataFieldAge(age)
                .enterDataFieldWeight(weight)
                .enterDataFieldGrowth(growth)
                .getCalculate();
    }
}
