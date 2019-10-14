package tests;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeMethod
    public void openSite() {
        open("https://www.calc.ru/kalkulyator-kalorii.html");
    }

    public void getCalculate() {
        $("#submit").click();
    }

    public void enterData(int age, int weight, int growth) {
        $(By.name("age")).setValue(Integer.toString(age)).pressEnter();
        $(By.name("weight")).setValue(Integer.toString(weight)).pressEnter();
        $(By.name("sm")).setValue(Integer.toString(growth)).pressEnter();
        getCalculate();
    }

    public void enterData(String age) {
        $(By.name("age")).setValue(age).pressEnter();
        getCalculate();
    }

    public void enterData(int age) {
        $(By.name("age")).setValue(Integer.toString(age)).pressEnter();
        getCalculate();
    }

    public void enterData(int age, String weight) {
        $(By.name("age")).setValue(Integer.toString(age)).pressEnter();
        $(By.name("weight")).setValue(weight).pressEnter();
        getCalculate();
    }

    public void enterData(int age, int weight) {
        $(By.name("age")).setValue(Integer.toString(age)).pressEnter();
        $(By.name("weight")).setValue(Integer.toString(weight)).pressEnter();
        getCalculate();
    }

    public void enterData(int age, int weight, String growth) {
        $(By.name("age")).setValue(Integer.toString(age)).pressEnter();
        $(By.name("weight")).setValue(Integer.toString(weight)).pressEnter();
        $(By.name("sm")).setValue(growth).pressEnter();
        getCalculate();
    }

    public String getValueConstWeightTable() {
        return $(By.xpath("//strong[text()=\"Понедельник\"]/../../td[@align=\"center\"][3]")).getText();
    }

    public String getValueConstWeightString() {
        return $(By.xpath("//tr[@class=\"res_row\"][2]")).getText();
    }

    public String getValueLosingWeightString() {
        return $(By.xpath("//tr[@class=\"res_row\"][4]")).getText();
    }

    public String getValueLosingWeightTable() {
        return $(By.xpath("//strong[text()=\"Понедельник\"]/../../td[@align=\"center\"][2]")).getText();
    }

    public String getValueFastLosingWeightString() {
        return $(By.xpath("//tr[@class=\"res_row\"][6]")).getText();
    }

    public String getValueFastLosingWeightTable() {
        return $(By.xpath("//strong[text()=\"Понедельник\"]/../../td[@align=\"center\"][1]")).getText();
    }

    public String getErrorMessage() {
        return $("#error").getText();
    }

    public void chooseSex() {
        $(By.xpath("//label[@for=\"sexFem\"]/span")).click();
    }

    public void chooseHarrisBenedictMethod() {
        $(By.xpath("//*[contains(text(),\" Харриса-Бенедикта\")]/span")).click();
    }

    public void chooseResultKj() {
        $(By.xpath("//*[contains(text(),\" килоджоулях\")]/span")).click();
    }
}
