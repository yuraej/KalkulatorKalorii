package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;

public class InputComponentPage {

    public InputComponentPage() {
    }

    @Step("Получение результата расчета")
    public InputComponentPage getCalculate() {
        $("#submit").click();
        return this;
    }

    @Step("Ввод численных данных в поле ВОЗРАСТ: {age}")
    public InputComponentPage enterDataFieldAge(int age) {
        $(By.name("age")).setValue(Integer.toString(age)).pressEnter();
        return this;
    }

    @Step("Ввод символьных данных в поле ВОЗРАСТ: {age}")
    public InputComponentPage enterDataFieldAge(String age) {
        $(By.name("age")).setValue(age).pressEnter();
        return this;
    }

    @Step("Ввод численных данных в поле ВОЗРАСТ: {weight}")
    public InputComponentPage enterDataFieldWeight(int weight) {
        $(By.name("weight")).setValue(Integer.toString(weight)).pressEnter();
        return this;
    }

    @Step("Ввод символьных данных в поле ВОЗРАСТ: {weight}")
    public InputComponentPage enterDataFieldWeight(String weight) {
        $(By.name("weight")).setValue(weight).pressEnter();
        return this;
    }

    @Step("Ввод численных данных в поле ВОЗРАСТ: {growth}")
    public InputComponentPage enterDataFieldGrowth(int growth) {
        $(By.name("sm")).setValue(Integer.toString(growth)).pressEnter();
        return this;
    }

    @Step("Ввод символьных данных в поле ВОЗРАСТ: {}growth")
    public InputComponentPage enterDataFieldGrowth(String growth) {
        $(By.name("sm")).setValue(growth).pressEnter();
        return this;
    }
}
