package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class InputComponentPage {

    @Step("Получение результата расчета")
    public void getCalculate() {
        log.info("получить рассчет");
        $("#submit").click();
    }

    @Step("Ввод численных данных в поле ВОЗРАСТ: {age}")
    public InputComponentPage enterDataFieldAge(int age) {
        log.info("ввод данных численных в поле возраст");
        $(By.name("age")).setValue(Integer.toString(age));
        return this;
    }

    @Step("Ввод символьных данных в поле ВОЗРАСТ: {age}")
    public InputComponentPage enterDataFieldAge(String age) {
        log.info("ввод данных нечисленных в поле возраст");
        $(By.name("age")).setValue(age);
        return this;
    }

    @Step("Ввод численных данных в поле ВЕС: {weight}")
    public InputComponentPage enterDataFieldWeight(int weight) {
        log.info("ввод данных численных в поле вес");
        $(By.name("weight")).setValue(Integer.toString(weight));
        return this;
    }

    @Step("Ввод символьных данных в поле ВЕС: {weight}")
    public InputComponentPage enterDataFieldWeight(String weight) {
        log.info("ввод данных нечисленных в поле вес");
        $(By.name("weight")).setValue(weight);
        return this;
    }

    @Step("Ввод численных данных в поле РОСТ: {growth}")
    public InputComponentPage enterDataFieldGrowth(int growth) {
        log.info("ввод данных численных в поле рост");
        $(By.name("sm")).setValue(Integer.toString(growth));
        return this;
    }

    @Step("Ввод символьных данных в поле РОСТ: {growth}")
    public InputComponentPage enterDataFieldGrowth(String growth) {
        log.info("ввод данных нечисленных в поле возраст");
        $(By.name("sm")).setValue(growth);
        return this;
    }

    @Step("смена пола на жениский")
    public InputComponentPage chooseGender() {
        log.info("выбор пола: Ж");
        $(By.xpath("//label[@for=\"sexFem\"]/span")).click();
        return this;
    }

    @Step("выбор методики расчета: Харриса-Бенедикта")
    public InputComponentPage chooseHarrisBenedictMethod() {
        log.info("выбор методики расчета: Харриса-Бенедикта");
        $(By.xpath("//*[contains(text(),\" Харриса-Бенедикта\")]/span")).click();
        return this;
    }

    @Step("выбор получения результатов расчета в килоджоулях")
    public InputComponentPage chooseResultKj() {
        log.info("выбор единиц измерения результата расчета: КДж");
        $(By.xpath("//*[contains(text(),\" килоджоулях\")]/span")).click();
        return this;
    }

    @Step("выбор интенсивности образа жизни - \"{load}\"")
    public InputComponentPage chooseIntensityOfLoad(String load) {
        log.info("выбор интенсивности образа жизни");
        $(By.id("activity")).selectOption(load);
        return this;
    }

    @Step("смена единицы измерения веса на фунты")
    public InputComponentPage choosePound() {
        log.info("смена единицы измерения веса на фунты");
        $(By.xpath("//*[text()=' в фунтах']/span")).click();
        return this;
    }

    @Step("смена единицы измерения роста на футы")
    public InputComponentPage chooseFt() {
        log.info("смена едениц измерения на футы");
        $(By.xpath("//label[text()=' футов/дюймов']/span")).click();
        return this;
    }

    @Step("ввод значений поля РОСТ в футах и дюймах - \"{foot}\"")
    public InputComponentPage enterDataGrowthFt(String foot) {
        log.info("ввод значений поля рост в футах/дюймах");
        $(By.id("height_eng")).selectOption(foot);
        return this;
    }

}

