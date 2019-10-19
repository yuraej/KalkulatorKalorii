package tests;

import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.InputDataSteps;
import steps.ResultsSteps;

public class InputWrongDataWeightTest extends BaseTest {

    @Test(dataProvider = "dataForTestSymbols",
            description = "ввод значений в поле ВЕС")
    @Description(value = "Тест проверяет наличие сообщения при вводе нечисленных символов в поле вес")
    public void enterWrongData(int age, String weight, String message) {
        input.inputDataAge(age);
        input.inputDataWeight(weight);
        result.getErrorMessage(message);
    }

    @Test(dataProvider = "dataForTestNumber",
            description = "ввод значений в поле ВЕС")
    @Description(value = "Тест проверяет наличия сообщения при вводе численных некорректных некорректных значений в поле вес")
    public void enterWrongData(int age, int weight, String message) {
        input.inputDataAge(age);
        input.inputDataWeight(weight);
        result.getErrorMessage(message);
    }

    @DataProvider(parallel = true)
    public Object[][] dataForTestSymbols() {
        return new Object[][]{
                {50, "-1", "Поле \"Вес\" должно быть числовым"},
                {15, ".3", "Поле \"Вес\" должно быть числовым"},
                {79, "d5", "Поле \"Вес\" должно быть числовым"},
                {60, "  ", "Поле \"Вес\" должно быть числовым"}
        };
    }

    @DataProvider(parallel = true)
    public Object[][] dataForTestNumber() {
        return new Object[][]{
                {14, 40, "Пожалуйста, введите реальный вес"},
                {79, 501, "Пожалуйста, введите реальный вес"}
        };
    }
}
