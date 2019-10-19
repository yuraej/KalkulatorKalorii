package tests;

import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.InputDataSteps;
import steps.ResultsSteps;

public class InputWrongDataGrowthTest extends BaseTest {

    @Test(dataProvider = "dataForTestSymbols",
            description = "ввод значений в поле РОСТ")
    @Description(value = "Тест проверяет наличия сообщения при вводе нечисленных значений символов в поле рост")
    public void enterWrongData(int age, int weight, String growth, String message) {
        input.inputDataAge(age);
        input.inputDataWeight(weight);
        input.inputDataGrowth(growth);
        result.getErrorMessage(message);
    }

    @Test(dataProvider = "dataForTestNumber",
            description = "ввод значений в поле РОСТ")
    @Description(value = "Тест проверяет наличия сообщения при вводе численных некорректных значений символов в поле рост")
    public void enterWrongData(int age, int weight, int growth, String message) {
        input.inputDataAge(age);
        input.inputDataWeight(weight);
        input.inputDataGrowth(growth);
        result.getErrorMessage(message);
    }

    @DataProvider(parallel = true)
    public Object[][] dataForTestSymbols() {
        return new Object[][]{
                {50, 82, ">1", "Поле \"Рост\" должно быть числовым"},
                {15, 52, ",3", "Поле \"Рост\" должно быть числовым"},
                {79, 120, "d5", "Поле \"Рост\" должно быть числовым"},
                {60, 107, " ", "Поле \"Рост\" должно быть числовым"}
        };
    }

    @DataProvider(parallel = true)
    public Object[][] dataForTestNumber() {
        return new Object[][]{
                {14, 42, 100, "Пожалуйста, введите реальный рост"},
                {25, 499, 251, "Пожалуйста, введите реальный рост"}
        };
    }
}
