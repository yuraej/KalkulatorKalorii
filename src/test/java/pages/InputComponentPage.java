package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class InputComponentPage {

    public InputComponentPage() {
    }

    @Step("Получение результата расчета")
    public void getCalculate() {
        $("#submit").click();
    }

    @Step("Ввод численных данных в поле ВОЗРАСТ: {age}")
    public InputComponentPage enterDataFieldAge(int age) {
        $(By.name("age")).setValue(Integer.toString(age));
        return this;
    }

    @Step("Ввод символьных данных в поле ВОЗРАСТ: {age}")
    public InputComponentPage enterDataFieldAge(String age) {
        $(By.name("age")).setValue(age);
        return this;
    }

    @Step("Ввод численных данных в поле ВЕС: {weight}")
    public InputComponentPage enterDataFieldWeight(int weight) {
        $(By.name("weight")).setValue(Integer.toString(weight));
        return this;
    }

    @Step("Ввод символьных данных в поле ВЕС: {weight}")
    public InputComponentPage enterDataFieldWeight(String weight) {
        $(By.name("weight")).setValue(weight);
        return this;
    }

    @Step("Ввод численных данных в поле РОСТ: {growth}")
    public InputComponentPage enterDataFieldGrowth(int growth) {
        $(By.name("sm")).setValue(Integer.toString(growth));
        return this;
    }

    @Step("Ввод символьных данных в поле РОСТ: {growth}")
    public InputComponentPage enterDataFieldGrowth(String growth) {
        $(By.name("sm")).setValue(growth);
        return this;
    }

    @Step("смена пола на жениский")
    public InputComponentPage chooseGender() {
        $(By.xpath("//label[@for=\"sexFem\"]/span")).click();
        return this;
    }

    @Step("выбор методики расчета Харриса-Бенедикта")
    public InputComponentPage chooseHarrisBenedictMethod() {
        $(By.xpath("//*[contains(text(),\" Харриса-Бенедикта\")]/span")).click();
        return this;
    }

    @Step("выбор получения результатов расчета в килоджоулях")
    public InputComponentPage chooseResultKj() {
        $(By.xpath("//*[contains(text(),\" килоджоулях\")]/span")).click();
        return this;
    }

    @Step("выбор интенсивности образа жизни - \"{load}\"")
    public InputComponentPage chooseIntensityOfLoad(String load) {
        $(By.id("activity")).selectOption(load);
        return this;
    }

    @Step("смена единицы измерения веса на фунты")
    public InputComponentPage choosePound() {
        $(By.xpath("//*[text()=' в фунтах']/span")).click();
        return  this;
    }

    @Step("смена единицы измерения роста на футы")
    public InputComponentPage chooseFt() {
        $(By.xpath("//*[text()=' футов/дюймов']/span")).click();
        return  this;
    }
}

