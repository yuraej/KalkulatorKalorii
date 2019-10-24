package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class InputCorrectDataTest extends BaseTest {

    @Test(dataProvider = "dataForTestString", dataProviderClass = DataProviderClass.class,
            description = "проверка результа расчета - строки")
    @Description(value = "Тест сравнивает результаты расчета из строк с ранее полученными результатами")
    public void checkResultStrings(int age, int weight, int growth, String constWeight, String losingWeight, String fastLosingWeight) {
        inputAllData.inputCorrectAllData(age, weight, growth);
        result.validateDetails(constWeight, losingWeight, fastLosingWeight);
    }

    @Test(dataProvider = "dataForTestTable", dataProviderClass = DataProviderClass.class,
            description = "проверка результата расчета - таблица")
    @Description(value = "Тест сравнивает результаты расчета из таблицы с ранее полученными результатами")
    public void checkResultTable(int age, int weight, int growth, String day, String constWeight, String losingWeight, String fastLosingWeight) {
        inputAllData.inputCorrectAllData(age, weight, growth);
        result.validateDetails(day, constWeight, losingWeight, fastLosingWeight);
    }
}