package steps;

import io.qameta.allure.Step;
import pages.ResultsComponentPage;

import static org.testng.AssertJUnit.assertEquals;

public class ResultsSteps {
    ResultsComponentPage result = new ResultsComponentPage();

    public void validateGeneralDetails(String constWeight, String losingWeight, String fastLosingWeight) {
        assertEquals(result.getValueConstWeightString(), constWeight.concat(" ккал/день"));
        assertEquals(result.getValueLosingWeightString(), losingWeight.concat(" ккал/день"));
        assertEquals(result.getValueFastLosingWeightString(), fastLosingWeight.concat(" ккал/день"));
    }

    @Step("Ожидаемое количество каллорий для дня {day}: {fastLosingWeight}")
    public void validateTableDetails(String day, String fastLosingWeight, String losingWeight, String constWeight) {
        assertEquals(result.getValueConstWeightTable(day), constWeight);
        assertEquals(result.getValueLosingWeightTable(day), losingWeight);
        assertEquals(result.getValueFastLosingWeightTable(day), fastLosingWeight);
    }
}
