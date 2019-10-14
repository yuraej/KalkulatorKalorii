package tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;

public class HarrisBenedictMethodTesting extends BaseTest {

    @Test(dataProvider = "dataForTest",
            expectedExceptions = {AssertionError.class})
    public void checkChooseGender(int age, int weight, int growth) {

        chooseHarrisBenedictMethod();
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
    public void checkResultDependingOnInputFieldAge() {

        enterData(25, 50, 180);

        $("#submit").shouldBe(Condition.enabled);
        String firstValueConstWeight = getValueConstWeightString();
        String firstValueLosingWeight = getValueLosingWeightString();
        String firstValueFastLosingWeight = getValueFastLosingWeightString();

        enterData(50, 50, 180);

        $("#submit").shouldBe(Condition.enabled);
        String secondValueConstWeight = getValueConstWeightString();
        String secondValueLosingWeight = getValueLosingWeightString();
        String secondValueFastLosingWeight = getValueFastLosingWeightString();

        assertEquals(firstValueConstWeight, secondValueConstWeight);
        assertEquals(firstValueLosingWeight, secondValueLosingWeight);
        assertEquals(firstValueFastLosingWeight, secondValueFastLosingWeight);
    }

    @Test(expectedExceptions = {AssertionError.class})
    public void checkResultDependingOnInputFieldWeight() {

        enterData(25, 50, 180);

        $("#submit").shouldBe(Condition.enabled);
        String firstValueConstWeight = getValueConstWeightString();
        String firstValueLosingWeight = getValueLosingWeightString();
        String firstValueFastLosingWeight = getValueFastLosingWeightString();

        enterData(25, 150, 180);

        $("#submit").shouldBe(Condition.enabled);
        String secondValueConstWeight = getValueConstWeightString();
        String secondValueLosingWeight = getValueLosingWeightString();
        String secondValueFastLosingWeight = getValueFastLosingWeightString();

        assertEquals(firstValueConstWeight, secondValueConstWeight);
        assertEquals(firstValueLosingWeight, secondValueLosingWeight);
        assertEquals(firstValueFastLosingWeight, secondValueFastLosingWeight);
    }

    @Test(expectedExceptions = {AssertionError.class})
    public void checkResultDependingOnInputFieldGrown() {

        enterData(25, 50, 180);

        $("#submit").shouldBe(Condition.enabled);
        String firstValueConstWeight = getValueConstWeightString();
        String firstValueLosingWeight = getValueLosingWeightString();
        String firstValueFastLosingWeight = getValueFastLosingWeightString();

        enterData(25, 50, 210);

        $("#submit").shouldBe(Condition.enabled);
        String secondValueConstWeight = getValueConstWeightString();
        String secondValueLosingWeight = getValueLosingWeightString();
        String secondValueFastLosingWeight = getValueFastLosingWeightString();

        assertEquals(firstValueConstWeight, secondValueConstWeight);
        assertEquals(firstValueLosingWeight, secondValueLosingWeight);
        assertEquals(firstValueFastLosingWeight, secondValueFastLosingWeight);
    }

    @DataProvider(parallel = true)
    public Object[][] dataForTest() {
        return new Object[][]{
                {13, 45, 101},
        };
    }
}
