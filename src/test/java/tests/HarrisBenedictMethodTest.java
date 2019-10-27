package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class HarrisBenedictMethodTest extends BaseTest {

    @Test(description = "проверка зависимости результатов от выбора метода расчета")
    public void checkChooseCalculationMethod() {
        inputAllData.inputCorrectAllData(47, 75, 199);
        String constWeight = resultsComponent.getValueConstWeightString();
        String losingWeight = resultsComponent.getValueLosingWeightString();
        String fastLosingWeight = resultsComponent.getValueFastLosingWeightString();
        input.chooseHarrisBenedictMethod()
                .getCalculate();
        result.comparisonCalculationResults(constWeight, losingWeight, fastLosingWeight);
    }

    @Test(description = "проверка зависимости результатов от пола")
    public void checkChooseGender() {
        input.chooseHarrisBenedictMethod();
        inputAllData.inputCorrectAllData(47, 75, 199);
        String constWeight = resultsComponent.getValueConstWeightString();
        String losingWeight = resultsComponent.getValueLosingWeightString();
        String fastLosingWeight = resultsComponent.getValueFastLosingWeightString();
        input.chooseGender()
                .getCalculate();
        result.comparisonCalculationResults(constWeight, losingWeight, fastLosingWeight);
    }

    @Test(description = "зависимость результатов от выбор единиц измерения результатов расчета")
    public void checkChooseResult() {
        input.chooseHarrisBenedictMethod();
        inputAllData.inputCorrectAllData(47, 75, 199);
        String constWeight = resultsComponent.getValueConstWeightString();
        String losingWeight = resultsComponent.getValueLosingWeightString();
        String fastLosingWeight = resultsComponent.getValueFastLosingWeightString();
        input.chooseResultKj()
                .getCalculate();
        result.comparisonCalculationResults(constWeight, losingWeight, fastLosingWeight);
    }

    @Test(description = "зависимость результатов от выбор единицы измерения веса")
    public void checkChoosePound() {
        input.chooseHarrisBenedictMethod();
        inputAllData.inputCorrectAllData(47, 75, 199);
        String constWeight = resultsComponent.getValueConstWeightString();
        String losingWeight = resultsComponent.getValueLosingWeightString();
        String fastLosingWeight = resultsComponent.getValueFastLosingWeightString();
        input.choosePound()
                .getCalculate();
        result.comparisonCalculationResults(constWeight, losingWeight, fastLosingWeight);
    }

    @Test(description = "зависимость результатов от изменения возраста")
    public void checkResultDependingInputFieldAge() {
        input.chooseHarrisBenedictMethod();
        inputAllData.inputCorrectAllData(47, 75, 199);
        String constWeight = resultsComponent.getValueConstWeightString();
        String losingWeight = resultsComponent.getValueLosingWeightString();
        String fastLosingWeight = resultsComponent.getValueFastLosingWeightString();
        inputAllData.inputCorrectAllData(25, 75, 199);
        result.comparisonCalculationResults(constWeight, losingWeight, fastLosingWeight);
    }

    @Test(description = "зависимость результатов от изменения веса")
    public void checkResultDependingInputFieldWeight() {
        input.chooseHarrisBenedictMethod();
        inputAllData.inputCorrectAllData(47, 75, 199);
        String constWeight = resultsComponent.getValueConstWeightString();
        String losingWeight = resultsComponent.getValueLosingWeightString();
        String fastLosingWeight = resultsComponent.getValueFastLosingWeightString();
        inputAllData.inputCorrectAllData(47, 150, 199);
        result.comparisonCalculationResults(constWeight, losingWeight, fastLosingWeight);
    }

    @Test(description = "зависимость результатов от изменения роста")
    public void checkResultDependingInputFieldGrowth() {
        input.chooseHarrisBenedictMethod();
        inputAllData.inputCorrectAllData(47, 75, 199);
        String constWeight = resultsComponent.getValueConstWeightString();
        String losingWeight = resultsComponent.getValueLosingWeightString();
        String fastLosingWeight = resultsComponent.getValueFastLosingWeightString();
        inputAllData.inputCorrectAllData(47, 75, 170);
        result.comparisonCalculationResults(constWeight, losingWeight, fastLosingWeight);
    }

    @Test(description = "проверка зависимости результата расчета от активности",
            dataProvider = "dataForCheckChooseIntensiveLoad", dataProviderClass = DataProviderClass.class)
    public void checkChooseIntensiveOfLoad(String load) {
        input.chooseHarrisBenedictMethod();
        inputAllData.inputCorrectAllData(47, 75, 199);
        String constWeight = resultsComponent.getValueConstWeightString();
        String losingWeight = resultsComponent.getValueLosingWeightString();
        String fastLosingWeight = resultsComponent.getValueFastLosingWeightString();
        input.chooseIntensityOfLoad(load)
                .getCalculate();
        result.comparisonCalculationResults(constWeight, losingWeight, fastLosingWeight);
    }

    @Test(description = "проверка зависимости результата расчета от значения роста в футах и дюймах",
            dataProvider = "dataForTestGrowthInFt", dataProviderClass = DataProviderClass.class)
    public void checkResultDependingInputFieldGrowthFt(String foot) {
        input.enterDataFieldAge(47)
                .enterDataFieldWeight(75)
                .chooseFt()
                .enterDataGrowthFt(foot)
                .chooseHarrisBenedictMethod()
                .getCalculate();
        String constWeight = resultsComponent.getValueConstWeightString();
        String losingWeight = resultsComponent.getValueLosingWeightString();
        String fastLosingWeight = resultsComponent.getValueFastLosingWeightString();
        input.enterDataFieldAge(47)
                .enterDataFieldWeight(75)
                .enterDataGrowthFt(foot)
                .getCalculate();
        result.comparisonCalculationResults(constWeight, losingWeight, fastLosingWeight);
    }
}
