package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class ResultsFields {

    @Step("Получение результата расчета для сохранения веса из строки")
    public String getValueConstWeightString() {
        return $(By.xpath("//tr[@class=\"res_row\"][2]")).getText();
    }

    @Step("Получение результата расчета для снижения веса из строки")
    public String getValueLosingWeightString() {
        return $(By.xpath("//tr[@class=\"res_row\"][4]")).getText();
    }

    @Step("Получение результата расчета для быстрого снижения веса из строки")
    public String getValueFastLosingWeightString() {
        return $(By.xpath("//tr[@class=\"res_row\"][6]")).getText();
    }
    @Step("Получение результата расчета для сохранения веса из таблицы")
    public String getValueConstWeightTable(String day) {
        return $(By.xpath("//strong[text()='" + day + "']/../../td[@align='center'][3]")).getText();
    }
    @Step("Получение результата расчета для снижения веса из таблицы")
    public String getValueLosingWeightTable(String day) {
        return $(By.xpath("//strong[text()='" + day + "']/../../td[@align='center'][2]")).getText();
    }
    @Step("Получение результата расчета для быстрого снижения веса из таблицы")
    public String getValueFastLosingWeightTable(String day) {
        return $(By.xpath("//strong[text()='" + day + "']/../../td[@align='center'][1]")).getText();
    }
}
