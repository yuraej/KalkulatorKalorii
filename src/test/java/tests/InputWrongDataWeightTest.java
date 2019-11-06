package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import utils.AllureUtils;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
public class InputWrongDataWeightTest extends BaseTest {

    @Test(dataProvider = "dataForTestFieldWeightSymbols", dataProviderClass = DataProviderClass.class,
            description = "ввод значений в поле ВЕС")
    @Description(value = "Тест проверяет наличие сообщения при вводе нечисленных символов в поле вес")
    public void enterWrongData(int age, String weight, String message) {
        input.enterDataFieldAge(age)
                .enterDataFieldWeight(weight)
                .getCalculate();
        result.getErrorMessage(message);
        log.info("делаем снимок экрана");
        AllureUtils.takeScreenshot(getWebDriver());
    }

    @Test(dataProvider = "dataForTestWeightNumber", dataProviderClass = DataProviderClass.class,
            description = "ввод значений в поле ВЕС")
    @Description(value = "Тест проверяет наличия сообщения при вводе численных некорректных некорректных значений в поле вес")
    public void enterWrongData(int age, int weight, String message) {
        input.enterDataFieldAge(age)
                .enterDataFieldWeight(weight)
                .getCalculate();
        result.getErrorMessage(message);
        log.info("делаем снимок экрана");
        AllureUtils.takeScreenshot(getWebDriver());
    }
}
