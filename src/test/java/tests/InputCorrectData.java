package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class InputCorrectData extends BaseTest {

    @Test(dataProvider = "dataForTest")
    public void enterCorrectData(int age, int weight, int growth) {
        enterData(age, weight, growth);

        assertEquals(getValueConstWeightString(), getValueConstWeightTable().concat(" ккал/день"));
        assertEquals(getValueLosingWeightString(), getValueLosingWeightTable().concat(" ккал/день"));
        assertEquals(getValueFastLosingWeightString(), getValueFastLosingWeightTable().concat(" ккал/день"));
    }

    @DataProvider(parallel = true)
    public Object[][] dataForTest() {
        return new Object[][]{
                {13, 41, 101},
                {47, 275, 175},
                {80, 500, 250}
        };
    }
}