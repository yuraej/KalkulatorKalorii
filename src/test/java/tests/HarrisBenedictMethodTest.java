package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HarrisBenedictMethodTest extends BaseTest {

    @Test(description = "проверка зависимости результатов от выбора метода расчета",
            expectedExceptions = {AssertionError.class})
    public void checkChooseCalculationMethod() {
        inputAllData.inputCorrectAllData(47, 75, 199);
        String constWeight = resultsComponent.getValueConstWeightString();
        String losingWeight = resultsComponent.getValueLosingWeightString();
        String fastLosingWeight = resultsComponent.getValueFastLosingWeightString();
        input.chooseHarrisBenedictMethod()
                .getCalculate();
        result.validateDetails(constWeight, losingWeight, fastLosingWeight);
    }

    @Test(description = "проверка зависимости результатов от пола",
            expectedExceptions = {AssertionError.class})
    public void checkChooseGender() {
        input.chooseHarrisBenedictMethod();
        inputAllData.inputCorrectAllData(47, 75, 199);
        String constWeight = resultsComponent.getValueConstWeightString();
        String losingWeight = resultsComponent.getValueLosingWeightString();
        String fastLosingWeight = resultsComponent.getValueFastLosingWeightString();
        input.chooseGender()
                .getCalculate();
        result.validateDetails(constWeight, losingWeight, fastLosingWeight);
    }

    @Test(description = "зависимость результатов от выбор единиц измерения результатов расчета", expectedExceptions = {AssertionError.class})
    public void checkChooseResult() {
        input.chooseHarrisBenedictMethod();
        inputAllData.inputCorrectAllData(47, 75, 199);
        String constWeight = resultsComponent.getValueConstWeightString();
        String losingWeight = resultsComponent.getValueLosingWeightString();
        String fastLosingWeight = resultsComponent.getValueFastLosingWeightString();
        input.chooseResultKj()
                .getCalculate();
        result.validateDetails(constWeight, losingWeight, fastLosingWeight);
    }

    @Test(description = "зависимость результатов от выбор единицы измерения веса",
            expectedExceptions = {AssertionError.class})
    public void checkChoosePound() {
        input.chooseHarrisBenedictMethod();
        inputAllData.inputCorrectAllData(47, 75, 199);
        String constWeight = resultsComponent.getValueConstWeightString();
        String losingWeight = resultsComponent.getValueLosingWeightString();
        String fastLosingWeight = resultsComponent.getValueFastLosingWeightString();
        input.choosePound()
                .getCalculate();
        result.validateDetails(constWeight, losingWeight, fastLosingWeight);
    }

    @Test(description = "зависимость результатов от изменения возраста", expectedExceptions = {AssertionError.class})
    public void checkResultDependingInputFieldAge() {
        input.chooseHarrisBenedictMethod();
        inputAllData.inputCorrectAllData(47, 75, 199);
        String constWeight = resultsComponent.getValueConstWeightString();
        String losingWeight = resultsComponent.getValueLosingWeightString();
        String fastLosingWeight = resultsComponent.getValueFastLosingWeightString();
        inputAllData.inputCorrectAllData(25, 75, 199);
        result.validateDetails(constWeight, losingWeight, fastLosingWeight);
    }

    @Test(description = "зависимость результатов от изменения веса", expectedExceptions = {AssertionError.class})
    public void checkResultDependingInputFieldWeight() {
        input.chooseHarrisBenedictMethod();
        inputAllData.inputCorrectAllData(47, 75, 199);
        String constWeight = resultsComponent.getValueConstWeightString();
        String losingWeight = resultsComponent.getValueLosingWeightString();
        String fastLosingWeight = resultsComponent.getValueFastLosingWeightString();
        inputAllData.inputCorrectAllData(47, 150, 199);
        result.validateDetails(constWeight, losingWeight, fastLosingWeight);
    }

    @Test(description = "зависимость результатов от изменения роста",
            expectedExceptions = {AssertionError.class})
    public void checkResultDependingInputFieldGrowth() {
        input.chooseHarrisBenedictMethod();
        inputAllData.inputCorrectAllData(47, 75, 199);
        String constWeight = resultsComponent.getValueConstWeightString();
        String losingWeight = resultsComponent.getValueLosingWeightString();
        String fastLosingWeight = resultsComponent.getValueFastLosingWeightString();
        inputAllData.inputCorrectAllData(47, 75, 170);
        result.validateDetails(constWeight, losingWeight, fastLosingWeight);
    }

    @Test(description = "проверка зависимости результата расчета от активности",
            dataProvider = "dataForCheckChooseIntensiveLoad", dataProviderClass = DataProviderClass.class,
            expectedExceptions = {AssertionError.class})
    public void checkChooseIntensiveOfLoad(String load) {
        input.chooseHarrisBenedictMethod();
        inputAllData.inputCorrectAllData(47, 75, 199);
        String constWeight = resultsComponent.getValueConstWeightString();
        String losingWeight = resultsComponent.getValueLosingWeightString();
        String fastLosingWeight = resultsComponent.getValueFastLosingWeightString();
        input.chooseIntensityOfLoad(load)
                .getCalculate();
        result.validateDetails(constWeight, losingWeight, fastLosingWeight);
    }
}
