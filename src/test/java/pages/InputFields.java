package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

public class InputFields {
    WebDriver driver;

    public InputFields(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Получение результата расчета")
    public InputFields getCalculate() {
        $("#submit").click();
        return this;
    }

    @Step("Ввод численных данных в поле ВОЗРАСТ")
    public InputFields enterDataFieldAge(int age) {
        $(By.name("age")).setValue(Integer.toString(age)).pressEnter();
        return this;
    }

    @Step("Ввод символьных данных в поле ВОЗРАСТ")
    public InputFields enterDataFieldAge(String age) {
        $(By.name("age")).setValue(age).pressEnter();
        return this;
    }

    @Step("Ввод численных данных в поле ВОЗРАСТ")
    public InputFields enterDataFieldWeight(int weight) {
        $(By.name("weight")).setValue(Integer.toString(weight)).pressEnter();
        return this;
    }

    @Step("Ввод символьных данных в поле ВОЗРАСТ")
    public InputFields enterDataFieldWeight(String weight) {
        $(By.name("weight")).setValue(weight).pressEnter();
        return this;
    }

    @Step("Ввод численных данных в поле ВОЗРАСТ")
    public InputFields enterDataFieldGrowth(int growth) {
        $(By.name("sm")).setValue(Integer.toString(growth)).pressEnter();
        return this;
    }

    @Step("Ввод символьных данных в поле ВОЗРАСТ")
    public InputFields enterDataFieldGrowth(String growth) {
        $(By.name("sm")).setValue(growth).pressEnter();
        return this;
    }
}
