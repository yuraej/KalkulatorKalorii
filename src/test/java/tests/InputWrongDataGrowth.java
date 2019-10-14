package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertEquals;

public class InputWrongDataGrowth extends  BaseTest{

    @Test(dataProvider = "dataForTestSymbols")
    public void enterWrongData(int age, int weight, String growth) {
        enterData(age, weight, growth);
        assertEquals(getErrorMessage(), "Поле \"Рост\" должно быть числовым");
    }

    @Test(dataProvider = "dataForTestNumber")
    public void enterWrongData(int age, int weight, int growth) {
        enterData(age, weight, growth);
        assertEquals(getErrorMessage(), "Пожалуйста, введите реальный рост");
    }

    @DataProvider(parallel = true)
    public Object[][] dataForTestSymbols() {
        return new Object[][]{
                {50, 82, ">1"},
                {15, 52, ",3"},
                {79, 120,"d5"},
                {60, 107, " "}
        };
    }

    @DataProvider(parallel = true)
    public Object[][] dataForTestNumber() {
        return new Object[][]{
                {14, 42, 100},
                {25, 499, 251}
        };
    }
}
