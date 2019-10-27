package steps;

import io.qameta.allure.Step;
import pages.ResultsComponentPage;

import static com.codeborne.selenide.Selenide.$;

public class ResultsSteps {
    ResultsComponentPage result = new ResultsComponentPage();

    @Step("ожидаемое количество каллорий для быстрого похудения {fastLosingWeight};" + " похудения {losingWeight};" +
            " неизменного веса {constWeight}")
    public void validateDetails(String constWeight, String losingWeight, String fastLosingWeight) {
        if (!result.getValueConstWeightString().equals(constWeight)) {
            throw new AssertionError("Результат расчета - " + result.getValueConstWeightString() +
                    " не совпадает с предыдущим - " + constWeight);
        }
        if (!result.getValueLosingWeightString().equals(losingWeight)) {
            throw new AssertionError("Результат расчета - " + result.getValueLosingWeightString() +
                    " не совпадает с предыдущим - " + losingWeight);
        }
        if (!result.getValueFastLosingWeightString().equals(fastLosingWeight)) {
            throw new AssertionError("Результат расчета - " + result.getValueFastLosingWeightString() +
                    " не совпадает с предыдущим - " + fastLosingWeight);
        }
    }

    @Step("Ожидаемое количество каллорий для дня {day}: быстрая потеря веса - {fastLosingWeight}" +
            " потеря веса - {losingWeight}" +
            " неизменный вес - {constWeight}")
    public void validateDetails(String day, String fastLosingWeight, String losingWeight, String constWeight) {
        if (!result.getValueConstWeightTable(day).equals(constWeight)) {
            throw new AssertionError("Результат расчета - " + result.getValueConstWeightTable(day) +
                    " не совпадает с предыдущим - " + constWeight);
        }
        if (!result.getValueLosingWeightTable(day).equals(losingWeight)) {
            throw new AssertionError("Результат расчета - " + result.getValueLosingWeightTable(day) +
                    " не совпадает с предыдущим - " + losingWeight);
        }
        if (!result.getValueFastLosingWeightTable(day).equals(fastLosingWeight)) {
            throw new AssertionError("Результат расчета - " + result.getValueFastLosingWeightTable(day) +
                    " не совпадает с предыдущим - " + fastLosingWeight);
        }
    }

    @Step("ожидаемое сообщение при неккоректном вводе: \"{message}\"")
    public void getErrorMessage(String message) {
        if (!$("#error").getText().equals(message)) {
            throw new AssertionError("Полученно неверное сообщение об ошибке");
        }
    }

    @Step("сравнение результатов расчета, НЕ ДОЛЖНЫ СОВПАДАТЬ, при различных значениях полей ввода")
    public void comparisonCalculationResults(String constWeight, String losingWeight, String fastLosingWeight) {
        if (result.getValueConstWeightString().equals(constWeight)) {
            throw new AssertionError("Результат расчета - " + result.getValueConstWeightString() +
                    " совпадает с предыдущим - " + constWeight);
        }
        if (result.getValueLosingWeightString().equals(losingWeight)) {
            throw new AssertionError("Результат расчета - " + result.getValueLosingWeightString() +
                    " совпадает с предыдущим - " + losingWeight);
        }
        if (result.getValueFastLosingWeightString().equals(fastLosingWeight)) {
            throw new AssertionError("Результат расчета - " + result.getValueFastLosingWeightString() +
                    " совпадает с предыдущим - " + fastLosingWeight);
        }
    }
}
