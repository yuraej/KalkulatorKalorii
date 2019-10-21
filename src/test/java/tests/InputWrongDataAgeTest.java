package tests;

import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InputWrongDataAgeTest extends BaseTest {

    @Test(dataProvider = "dataForTestFieldAgeSymbols", dataProviderClass = DataProviderClass.class,
            description = "ввод значений в поле ВОЗРАСТ")
    @Description(value = "Тест проверяет наличия сообщения при вводе нечисленных значений в поле возраст")
    public void enterWrongData(String age, String message) {
        input.enterDataFieldAge(age)
                .getCalculate();
        result.getErrorMessage(message);
    }

    @Test(dataProvider = "dataForTestFieldAgeNumber", dataProviderClass = DataProviderClass.class,
            description = "ввод значений в поле ВОЗРАСТ")
    @Description(value = "Тест проверяет наличия сообщения при вводе численных некорректных значений в поле возраст")
    public void enterWrongData(int age, String message) {
        input.enterDataFieldAge(age)
                .getCalculate();
        result.getErrorMessage(message);
    }
}