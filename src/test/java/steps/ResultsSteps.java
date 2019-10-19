package steps;

import io.qameta.allure.Step;
import pages.ResultsComponentPage;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertEquals;

public class ResultsSteps {
    ResultsComponentPage result = new ResultsComponentPage();

    @Step("ожидаемое количество каллорий для быстрого похудения {fastLosingWeight}\n" +
            "похудения {losingWeight}\n" +
            "неизменного веса {constWeight}")
    public void validateGeneralDetails(String constWeight, String losingWeight, String fastLosingWeight) {
        assertEquals(result.getValueConstWeightString(), constWeight.concat(" ккал/день"));
        assertEquals(result.getValueLosingWeightString(), losingWeight.concat(" ккал/день"));
        assertEquals(result.getValueFastLosingWeightString(), fastLosingWeight.concat(" ккал/день"));
    }

    @Step("Ожидаемое количество каллорий для дня {day}: быстрая потеря веса - {fastLosingWeight}\n" +
            "потеря веса - {losingWeight}\n" +
            "неизменный вес - {constWeight}")
    public void validateTableDetails(String day, String fastLosingWeight, String losingWeight, String constWeight) {
        assertEquals(result.getValueConstWeightTable(day), constWeight);
        assertEquals(result.getValueLosingWeightTable(day), losingWeight);
        assertEquals(result.getValueFastLosingWeightTable(day), fastLosingWeight);
    }

    @Step("ожидаемое сообщение при неккоректном вводе: \"{message}\"")
    public void getErrorMessage(String message) {
        assertEquals($("#error").getText(), message);
    }
}
