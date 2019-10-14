package tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertEquals;

public class InputWrongDataAge extends  BaseTest{

    @Test(dataProvider = "dataForTestSymbols")
    public void enterWrongData(String age) {
        enterData(age);
        assertEquals(getErrorMessage(), "Поле \"Возраст\" должно быть числовым");
    }

    @Test(dataProvider = "dataForTestNumber")
    public void enterWrongData(int age) {
        enterData(age);
        assertEquals(getErrorMessage(), "Возраст должен быть между 13 и 80");
    }

    @DataProvider(parallel = true)
    public Object[][] dataForTestSymbols() {
        return new Object[][]{
                {"-1"},
                {"a2"},
                {"<3"},
                {"  "}
        };
    }

    @DataProvider(parallel = true)
    public Object[][] dataForTestNumber() {
        return new Object[][]{
                {12},
                {81},
        };
    }
}