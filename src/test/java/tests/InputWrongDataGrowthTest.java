package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import utils.AllureUtils;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
public class InputWrongDataGrowthTest extends BaseTest {

    @Test(dataProvider = "dataForTestFieldGrowthSymbols", dataProviderClass = DataProviderClass.class,
            description = "ввод значений в поле РОСТ")
    @Description(value = "Тест проверяет наличие сообщения при вводе нечисленных значений символов в поле рост")
    public void enterWrongData(int age, int weight, String growth, String message) {
        input.enterDataFieldAge(age)
                .enterDataFieldWeight(weight)
                .enterDataFieldGrowth(growth)
                .getCalculate();
        result.getErrorMessage(message);
        log.info("делаем снимок экрана");
        AllureUtils.takeScreenshot(getWebDriver());
    }

    @Test(dataProvider = "dataForTestFieldGrowthNumber", dataProviderClass = DataProviderClass.class,
            description = "ввод значений в поле РОСТ")
    @Description(value = "Тест проверяет наличие сообщения при вводе численных некорректных значений символов в поле рост")
    public void enterWrongData(int age, int weight, int growth, String message) {
        input.enterDataFieldAge(age)
                .enterDataFieldWeight(weight)
                .enterDataFieldGrowth(growth)
                .getCalculate();
        result.getErrorMessage(message);
        log.info("делаем снимок экрана");
        AllureUtils.takeScreenshot(getWebDriver());
    }
}
