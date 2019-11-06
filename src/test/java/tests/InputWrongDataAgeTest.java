package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import utils.AllureUtils;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
public class InputWrongDataAgeTest extends BaseTest {

    @Test(dataProvider = "dataForTestFieldAgeSymbols", dataProviderClass = DataProviderClass.class,
            description = "ввод значений в поле ВОЗРАСТ")
    @Description(value = "Тест проверяет наличия сообщения при вводе нечисленных значений в поле возраст")
    public void enterWrongData(String age, String message) {
        input.enterDataFieldAge(age)
                .getCalculate();
        result.getErrorMessage(message);
        log.info("делаем снимок экрана");
        AllureUtils.takeScreenshot(getWebDriver());
    }

    @Test(dataProvider = "dataForTestFieldAgeNumber", dataProviderClass = DataProviderClass.class,
            description = "ввод значений в поле ВОЗРАСТ")
    @Description(value = "Тест проверяет наличия сообщения при вводе численных некорректных значений в поле возраст")
    public void enterWrongData(int age, String message) {
        input.enterDataFieldAge(age)
                .getCalculate();
        result.getErrorMessage(message);
        log.info("делаем снимок экрана");
        AllureUtils.takeScreenshot(getWebDriver());
    }
}