package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.AllureUtils;

public class InputCorrectDataTest extends BaseTest {

    @Test(dataProvider = "dataForTestString", description = "проверка результа расчета - строки")
    @Description(value = "Тест сравнивает результаты в строках расчета с ранее полученными данными")
    public void checkResultStrings(int age, int weight, int growth, String constWeight, String losingWeight, String fastLosingWeight) {
        input.inputCorrectData(age, weight, growth);
        result.validateGeneralDetails(constWeight, losingWeight, fastLosingWeight);
    }

    @Test(dataProvider = "dataForTestTable", description = "проверка результата расчета - таблица")
    @Description(value = "Тест сравнивает результаты в таблице с ранее полученными данными")
    public void checkResultTable(int age, int weight, int growth, String day, String constWeight, String losingWeight, String fastLosingWeight) {
        input.inputCorrectData(age, weight, growth);
        result.validateTableDetails(day, constWeight, losingWeight, fastLosingWeight);
    }

    @DataProvider(parallel = false)
    public Object[][] dataForTestString() {
        return new Object[][]{
                {13, 41, 101, "1667", "1334", "1000"},
                {47, 275, 175, "7942", "6354", "4840"},
                {80, 500, 250, "13976", "11181", "8800"}
        };
    }

    @DataProvider(parallel = true)
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