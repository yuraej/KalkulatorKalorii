package tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;

public class MiflinSanJeroMethodTesting extends BaseTest{
    @Test(dataProvider = "dataForTest",
            expectedExceptions = {AssertionError.class})
    public void checkChooseGender(int age, int weight, int growth) {

        enterData(age, weight, growth);

        String firstValueConstWeight = getValueConstWeightString();
        String firstValueLosingWeight = getValueLosingWeightString();
        String firstValueFastLosingWeight = getValueFastLosingWeightString();

        chooseSex();
        getCalculate();

        $("#submit").shouldBe(Condition.enabled);
        String secondValueConstWeight = getValueConstWeightString();
        String secondValueLosingWeight = getValueLosingWeightString();
        String secondValueFastLosingWeight = getValueFastLosingWeightString();

        assertEquals(firstValueConstWeight, secondValueConstWeight);
        assertEquals(firstValueLosingWeight, secondValueLosingWeight);
        assertEquals(firstValueFastLosingWeight, secondValueFastLosingWeight);
    }

    @Test(dataProvider = "dataForTest",
            expectedExceptions = {AssertionError.class})
    public void checkChooseResult(int age, int weight, int growth) {

        enterData(age, weight, growth);

        String firstValueConstWeight = getValueConstWeightString();
        String firstValueLosingWeight = getValueLosingWeightString();
        String firstValueFastLosingWeight = getValueFastLosingWeightString();

        chooseResultKj();
        getCalculate();

        $("#submit").shouldBe(Condition.enabled);
        String secondValueConstWeight = getValueConstWeightString();
        String secondValueLosingWeight = getValueLosingWeightString();
        String secondValueFastLosingWeight = getValueFastLosingWeightString();

        assertEquals(firstValueConstWeight, secondValueConstWeight);
        assertEquals(firstValueLosingWeight, secondValueLosingWeight);
        assertEquals(firstValueFastLosingWeight, secondValueFastLosingWeight);
    }

    @Test(expectedExceptions = {AssertionError.class})
    public void checkResultDependingOnInputField() {

        enterData(25, 50, 180);

        String firstValueConstWeight = getValueConstWeightString();
        String firstValueLosingWeight = getValueLosingWeightString();
        String firstValueFastLosingWeight = getValueFastLosingWeightString();

        enterData(50, 50, 180);

        String secondValueConstWeight = getValueConstWeightString();
        String secondValueLosingWeight = getValueLosingWeightString();
        String secondValueFastLosingWeight = getValueFastLosingWeightString();

        assertEquals(firstValueConstWeight, secondValueConstWeight);
        assertEquals(firstValueLosingWeight, secondValueLosingWeight);
        assertEquals(firstValueFastLosingWeight, secondValueFastLosingWeight);

        enterData(50, 100, 180);

        String thirdValueConstWeight = getValueConstWeightString();
        String thirdValueLosingWeight = getValueLosingWeightString();
        String thirdValueFastLosingWeight = getValueFastLosingWeightString();

        assertEquals(thirdValueConstWeight, secondValueConstWeight);
        assertEquals(thirdValueLosingWeight, secondValueLosingWeight);
        assertEquals(thirdValueFastLosingWeight, secondValueFastLosingWeight);

        enterData(50, 100, 210);

        String fourValueConstWeight = getValueConstWeightString();
        String fourValueLosingWeight = getValueLosingWeightString();
        String fourValueFastLosingWeight = getValueFastLosingWeightString();

        assertEquals(thirdValueConstWeight, fourValueConstWeight);
        assertEquals(thirdValueLosingWeight, fourValueLosingWeight);
        assertEquals(thirdValueFastLosingWeight, fourValueFastLosingWeight);
    }

    @DataProvider(parallel = true)
    public Object[][] dataForTest() {
        return new Object[][]{
                {13, 45, 101},
        };
    }
}
