package tests;

import com.codeborne.selenide.Configuration;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeMethod;
import pages.InputComponentPage;
import pages.ResultsComponentPage;
import steps.InputDataSteps;
import steps.ResultsSteps;

import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class BaseTest {
    InputComponentPage input = new InputComponentPage();
    ResultsSteps result = new ResultsSteps();
    InputDataSteps inputAllData = new InputDataSteps();
    ResultsComponentPage resultsComponent = new ResultsComponentPage();

    @BeforeMethod
    public void openSite() {
        Configuration.startMaximized = true;
        log.info("Открываем страницу с калькулятором калорий");
        open("https://www.calc.ru/kalkulyator-kalorii.html");
    }
}
