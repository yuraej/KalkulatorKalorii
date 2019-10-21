package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class InputWrongDataWeightTest extends BaseTest {

    @Test(dataProvider = "dataForTestWeightNumber", dataProviderClass = DataProviderClass.class,
            description = "ввод значений в поле ВЕС")
    @Description(value = "Тест проверяет наличие сообщения при вводе нечисленных символов в поле вес")
    public void enterWrongData(int age, String weight, String message) {
        input.enterDataFieldAge(age)
                .enterDataFieldWeight(weight)
                .getCalculate();
        result.getErrorMessage(message);
    }

    @Test(dataProvider = "dataForTestWeightNumber", dataProviderClass = DataProviderClass.class,
            description = "ввод значений в поле ВЕС")
    @Description(value = "Тест проверяет наличия сообщения при вводе численных некорректных некорректных значений в поле вес")
    public void enterWrongData(int age, int weight, String message) {
        input.enterDataFieldAge(age)
                .enterDataFieldWeight(weight)
                .getCalculate();
        result.getErrorMessage(message);
    }
}
