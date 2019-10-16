package steps;

import io.qameta.allure.Step;
import pages.InputComponentPage;

public class InputDataSteps {
    InputComponentPage input = new InputComponentPage();

    @Step("ввод данных возраст {age}, вес {weight}, рост {growth}")
    public void inputCorrectData(int age, int weight, int growth) {
        input.enterDataFieldAge(age)
                .enterDataFieldWeight(weight)
                .enterDataFieldGrowth(growth)
                .getCalculate();
    }
    @Step("ввод данных возраст {age}, вес {weight}, рост {growth}")
    public void inputWrongData(String age, String weight, String growth) {
        input.enterDataFieldAge(age)
                .enterDataFieldWeight(weight)
                .enterDataFieldGrowth(growth)
                .getCalculate();
    }
}
