package steps;

import pages.ResultsFields;

import static org.testng.AssertJUnit.assertEquals;

public class GetResult {
    ResultsFields result = new ResultsFields();

    public void validateGeneralDetails(String constWeight, String losingWeight, String fastLosingWeight) {
        assertEquals(result.getValueConstWeightString(), constWeight.concat(" ккал/день"));
        assertEquals(result.getValueLosingWeightString(), losingWeight.concat(" ккал/день"));
        assertEquals(result.getValueFastLosingWeightString(), fastLosingWeight.concat(" ккал/день"));
    }

    public void validateTableDetails(String day, String fastLosingWeight, String losingWeight, String constWeight) {
        assertEquals(result.getValueConstWeightTable(day), constWeight);
        assertEquals(result.getValueLosingWeightTable(day), losingWeight);
        assertEquals(result.getValueFastLosingWeightTable(day), fastLosingWeight);
    }
}
