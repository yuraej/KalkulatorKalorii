package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class ResultsComponentPage {

    private void waitSubmit() {
        log.info("ожидание надписи\"Сколько нужно калорий в день\". Установлено 7 сек.");
        SelenideElement wait = $(By.id("submit"));
        wait.waitUntil(value("Сколько нужно калорий в день"), 10000);
    }

    @Step("Получение результата расчета для сохранения веса из строки")
    public String getValueConstWeightString() {
        waitSubmit();
        log.info("получение расчет из строки: Постоянный вес");
        return $(By.xpath("//tr[@class=\"res_row\"][2]")).getText();
    }

    @Step("Получение результата расчета для снижения веса из строки")
    public String getValueLosingWeightString() {
        waitSubmit();
        log.info("получение расчета из строки: Снижение веса");
        return $(By.xpath("//tr[@class=\"res_row\"][4]")).getText();
    }

    @Step("Получение результата расчета для быстрого снижения веса из строки")
    public String getValueFastLosingWeightString() {
        waitSubmit();
        log.info("получение расчета из строки: Быстрое снижение веса");
        return $(By.xpath("//tr[@class=\"res_row\"][6]")).getText();
    }

    @Step("Получение результата расчета для сохранения веса из таблицы для дня {day}")
    public String getValueConstWeightTable(String day) {
        waitSubmit();
        log.info("получение расчета из таблицы для сохранения веса для дня {day}");
        return $(By.xpath("//strong[text()='" + day + "']/../../td[@align='center'][3]")).getText();
    }

    @Step("Получение результата расчета для снижения веса из таблицы для дня {day}")
    public String getValueLosingWeightTable(String day) {
        waitSubmit();
        log.info("получение расчета из таблицы для потери веса для дня {day}");
        return $(By.xpath("//strong[text()='" + day + "']/../../td[@align='center'][2]")).getText();
    }

    @Step("Получение результата расчета для быстрого снижения веса из таблицы для дня {day}")
    public String getValueFastLosingWeightTable(String day) {
        waitSubmit();
        log.info("получение расчета из таблицы для быстрой потери веса для дня {day}");
        return $(By.xpath("//strong[text()='" + day + "']/../../td[@align='center'][1]")).getText();
    }
}
