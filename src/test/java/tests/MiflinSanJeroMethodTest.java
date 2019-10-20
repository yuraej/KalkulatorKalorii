package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MiflinSanJeroMethodTest extends BaseTest {

    @Test(description = "проверка зависимости результатов от пола",
            expectedExceptions = {AssertionError.class})
    public void checkChooseGender() {
        inputAllData.inputCorrectAllData(47, 75, 199);
        String constWeight = resultsComponent.getValueConstWeightString();
        String losingWeight = resultsComponent.getValueLosingWeightString();
        String fastLosingWeight = resultsComponent.getValueFastLosingWeightString();
        input.chooseGender()
                .getCalculate();
        result.validateDetails(constWeight, losingWeight, fastLosingWeight);
    }

    @Test(description = "зависимость результатов от выбор единиц измерения",
            expectedExceptions = {AssertionError.class})
    public void checkChooseResult() {
        inputAllData.inputCorrectAllData(47, 75, 199);
        String constWeight = resultsComponent.getValueConstWeightString();
        String losingWeight = resultsComponent.getValueLosingWeightString();
        String fastLosingWeight = resultsComponent.getValueFastLosingWeightString();
        input.chooseResultKj()
                .getCalculate();
        result.validateDetails(constWeight, losingWeight, fastLosingWeight);
    }

    @Test(description = "зависимость результатов от изменения возраста",
            expectedExceptions = {AssertionError.class})
    public void checkResultDependingInputFieldAge() {
        inputAllData.inputCorrectAllData(47, 75, 199);
        String constWeight = resultsComponent.getValueConstWeightString();
        String losingWeight = resultsComponent.getValueLosingWeightString();
        String fastLosingWeight = resultsComponent.getValueFastLosingWeightString();
        inputAllData.inputCorrectAllData(25, 75, 199);
        result.validateDetails(constWeight, losingWeight, fastLosingWeight);
    }

    @Test(description = "зависимость результатов от изменения веса",
            expectedExceptions = {AssertionError.class})
    public void checkResultDependingInputFieldWeight() {
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
        inputAllData.inputCorrectAllData(47, 75, 199);
        String constWeight = resultsComponent.getValueConstWeightString();
        String losingWeight = resultsComponent.getValueLosingWeightString();
        String fastLosingWeight = resultsComponent.getValueFastLosingWeightString();
        inputAllData.inputCorrectAllData(47, 75, 170);
        result.validateDetails(constWeight, losingWeight, fastLosingWeight);
    }

    @Test(description = "проверка зависимости результата расчета от активности",
            dataProvider = "dataForCheckChooseIntensiveLoad",
            expectedExceptions = {AssertionError.class})
    public void checkChooseIntensiveOfLoad(String load) {
        inputAllData.inputCorrectAllData(47, 75, 199);
        String constWeight = resultsComponent.getValueConstWeightString();
        String losingWeight = resultsComponent.getValueLosingWeightString();
        String fastLosingWeight = resultsComponent.getValueFastLosingWeightString();
        input.chooseIntensityOfLoad(load)
                .getCalculate();
        result.validateDetails(constWeight, losingWeight, fastLosingWeight);
    }

    @DataProvider(parallel = true)
    public Object[][] dataForCheckChooseIntensiveLoad() {
        return new Object[][]{
                {"Основной обмен"},
                {"минимум/отсутствие физической нагрузки"},
                {"3 раза в неделю"},
                {"5 раз в неделю"},
                {"5 раз в неделю (интенсивно)"},
                {"Каждый день интенсивно или два раза в день"},
                {"Ежедневная физическая нагрузка+физическая работа"}
        };
    }

}
