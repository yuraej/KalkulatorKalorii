package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class InputWrongDataGrowthTest extends BaseTest {

    @Test(dataProvider = "dataForTestFieldGrowthSymbols", dataProviderClass = DataProviderClass.class,
            description = "ввод значений в поле РОСТ")
    @Description(value = "Тест проверяет наличия сообщения при вводе нечисленных значений символов в поле рост")
    public void enterWrongData(int age, int weight, String growth, String message) {
        input.enterDataFieldAge(age)
                .enterDataFieldWeight(weight)
                .enterDataFieldGrowth(growth)
                .getCalculate();
        result.getErrorMessage(message);
    }

    @Test(dataProvider = "dataForTestFieldGrowthNumber", dataProviderClass = DataProviderClass.class,
            description = "ввод значений в поле РОСТ")
    @Description(value = "Тест проверяет наличия сообщения при вводе численных некорректных значений символов в поле рост")
    public void enterWrongData(int age, int weight, int growth, String message) {
        input.enterDataFieldAge(age)
                .enterDataFieldWeight(weight)
                .enterDataFieldGrowth(growth)
                .getCalculate();
        result.getErrorMessage(message);
    }
}
