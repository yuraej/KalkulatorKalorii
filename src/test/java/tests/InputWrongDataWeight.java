package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertEquals;

public class InputWrongDataWeight extends BaseTest{

    @Test(dataProvider = "dataForTestSymbols")
    public void enterWrongData(int age, String weight) {
        enterData(age, weight);
        assertEquals(getErrorMessage(), "Поле \"Вес\" должно быть числовым");
    }

    @Test(dataProvider = "dataForTestNumber")
    public void enterWrongData(int age, int weight) {
        enterData(age, weight);
        assertEquals(getErrorMessage(), "Пожалуйста, введите реальный вес");
    }

    @DataProvider(parallel = true)
    public Object[][] dataForTestSymbols() {
        return new Object[][]{
                {50, "-1"},
                {15, ".3"},
                {79, "d5"},
                {60, "  "}
        };
    }

    @DataProvider(parallel = true)
    public Object[][] dataForTestNumber() {
        return new Object[][]{
                {14, 40},
                {79, 501},
        };
    }
}
