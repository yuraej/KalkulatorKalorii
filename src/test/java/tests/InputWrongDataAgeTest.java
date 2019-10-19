package tests;

import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InputWrongDataAgeTest extends BaseTest {

    @Test(dataProvider = "dataForTestSymbols",
            description = "ввод значений в поле ВОЗРАСТ")
    @Description(value = "Тест проверяет наличия сообщения при вводе нечисленных значений в поле возраст")
    public void enterWrongData(String age, String message) {
        input.inputDataAge(age);
        result.getErrorMessage(message);
    }

    @Test(dataProvider = "dataForTestNumber",
            description = "ввод значений в поле ВОЗРАСТ")
    @Description(value = "Тест проверяет наличия сообщения при вводе численных некорректных значений в поле возраст")
    public void enterWrongData(int age, String message) {
        input.inputDataAge(age);
        result.getErrorMessage(message);
    }

    @DataProvider(parallel = true)
    public Object[][] dataForTestSymbols() {
        return new Object[][]{
                {"-1", "Поле \"Возраст\" должно быть числовым"},
                {"a2", "Поле \"Возраст\" должно быть числовым"},
                {"<3", "Поле \"Возраст\" должно быть числовым"},
                {"  ", "Поле \"Возраст\" должно быть числовым"}
        };
    }

    @DataProvider(parallel = true)
    public Object[][] dataForTestNumber() {
        return new Object[][]{
                {12, "Возраст должен быть между 13 и 80"},
                {81, "Возраст должен быть между 13 и 80"}
        };
    }
}