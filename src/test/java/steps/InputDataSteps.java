package steps;

import io.qameta.allure.Step;
import pages.InputComponentPage;

public class InputDataSteps {
    InputComponentPage input = new InputComponentPage();

    @Step("ввод данных: возраст {age}, вес {weight}, рост {growth}")
    public void inputCorrectAllData(int age, int weight, int growth) {
        input.enterDataFieldAge(age)
                .enterDataFieldWeight(weight)
                .enterDataFieldGrowth(growth)
                .getCalculate();
    }

    @Step("ввод значений поля возраст: {age}")
    public void inputDataAge(String age) {
        input.enterDataFieldAge(age)
                .getCalculate();
    }

    @Step("ввод значений поля возраст: {age}")
    public void inputDataAge(int age) {
        input.enterDataFieldAge(age)
                .getCalculate();
    }

    @Step("ввод значений поля вес: {weight}")
    public void inputDataWeight(String weight) {
        input.enterDataFieldWeight(weight)
                .getCalculate();
    }

    @Step("ввод значений поля вес: {weight}")
    public void inputDataWeight(int weight) {
        input.enterDataFieldWeight(weight)
                .getCalculate();
    }

    @Step("ввод значений поля рост {growth}")
    public void inputDataGrowth(String growth) {
        input.enterDataFieldGrowth(growth)
                .getCalculate();
    }

    @Step("ввод значений поля  рост {growth}")
    public void inputDataGrowth(int growth) {
        input.enterDataFieldGrowth(growth)
                .getCalculate();
    }
}
