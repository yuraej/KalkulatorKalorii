package tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.ResultsSteps;
import steps.InputDataSteps;
import utils.AllureUtils;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    InputDataSteps input;
    ResultsSteps result;

    @BeforeMethod
    public void openSite() {
        Configuration.startMaximized = true;
        open("https://www.calc.ru/kalkulyator-kalorii.html");
        input = new InputDataSteps();
        result = new ResultsSteps();
    }

    @AfterMethod
    public void getScreenShot() {
        AllureUtils.takeScreenshot(getWebDriver());
    }

    public void validateGeneralDetails(int a, int b, int c) {
        //Найти элемент на сайте и взять текст
        //Сравнить что текст с сайта совпадает с аргументов метода
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
