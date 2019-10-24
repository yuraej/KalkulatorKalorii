package tests;

import com.codeborne.selenide.Configuration;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.InputComponentPage;
import pages.ResultsComponentPage;
import steps.InputDataSteps;
import steps.ResultsSteps;
import utils.AllureUtils;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
public class BaseTest {
    InputComponentPage input = new InputComponentPage();
    ResultsSteps result = new ResultsSteps();
    InputDataSteps inputAllData = new InputDataSteps();
    ResultsComponentPage resultsComponent = new ResultsComponentPage();

    @BeforeMethod
    public void openSite() {
        log.info("Открываем страницу с калькулятором калорий");
        open("https://www.calc.ru/kalkulyator-kalorii.html");
    }

   /* @AfterMethod
    public void getScreenShot() {
        log.info("делаем снимок экрана");
        AllureUtils.takeScreenshot(getWebDriver());
    }*/
}
