package tests;

import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InputCorrectDataTest extends BaseTest {

    @Test(dataProvider = "dataForTestString", description = "проверка результа расчета - строки")
    @Description(value = "Тест сравнивает результаты расчета из строк с ранее полученными результатами")
    public void checkResultStrings(int age, int weight, int growth, String constWeight, String losingWeight, String fastLosingWeight) {
        inputAllData.inputCorrectAllData(age, weight, growth);
        result.validateDetails(constWeight, losingWeight, fastLosingWeight);
    }

    @Test(dataProvider = "dataForTestTable", description = "проверка результата расчета - таблица")
    @Description(value = "Тест сравнивает результаты расчета из таблицы с ранее полученными результатами")
    public void checkResultTable(int age, int weight, int growth, String day, String constWeight, String losingWeight, String fastLosingWeight) {
        inputAllData.inputCorrectAllData(age, weight, growth);
        result.validateDetails(day, constWeight, losingWeight, fastLosingWeight);
    }

    @DataProvider(parallel = true)
    public Object[][] dataForTestString() {
        return new Object[][]{
                {13, 41, 101, "1667 ккал/день", "1334 ккал/день", "1000 ккал/день"},
                {47, 275, 175, "7942 ккал/день", "6354 ккал/день", "4840 ккал/день"},
                {80, 500, 250, "13976 ккал/день", "11181 ккал/день", "8800 ккал/день"}
        };
    }

    @DataProvider(parallel = false)
    public Object[][] dataForTestTable() {
        return new Object[][]{
                {45, 95, 182, "Понедельник", "1869", "2492", "3115"},
                {45, 95, 182, "Вторник", "1672", "1994", "2492"},
                {45, 95, 182, "Среда", "2243", "2991", "3739"},
                {45, 95, 182, "Пятница", "1682", "2243", "2804"},
                {45, 95, 182, "Суббота", "2056", "2742", "3427"}
        };
    }
}