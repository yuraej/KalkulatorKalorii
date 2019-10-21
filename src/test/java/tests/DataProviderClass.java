package tests;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(parallel = false)
    public static Object[][] dataForTestString() {
        return new Object[][]{
                {13, 41, 101, "1667 ккал/день", "1334 ккал/день", "1000 ккал/день"},
                {47, 275, 175, "7942 ккал/день", "6354 ккал/день", "4840 ккал/день"},
                {80, 500, 250, "13976 ккал/день", "11181 ккал/день", "8800 ккал/день"}
        };
    }

    @DataProvider(parallel = false)
    public static Object[][] dataForTestTable() {
        return new Object[][]{
                {45, 95, 182, "Понедельник", "1869", "2492", "3115"},
                {45, 95, 182, "Вторник", "1672", "1994", "2492"},
                {45, 95, 182, "Среда", "2243", "2991", "3739"},
                {45, 95, 182, "Пятница", "1682", "2243", "2804"},
                {45, 95, 182, "Суббота", "2056", "2742", "3427"}
        };
    }

    @DataProvider(parallel = true)
    public static Object[][] dataForCheckChooseIntensiveLoad() {
        return new Object[][]{
                {"Основной обмен"},
                {"минимум/отсутствие физической нагрузки"},
                {"3 раза в неделю"},
                {"5 раз в неделю"},
                {"5 раз в неделю (интенсивно)"},
                {"Каждый день интенсивно или два раза в день"},
                {"Ежедневная физическая нагрузка+физическая работа"}
        };
    }

    @DataProvider(parallel = true)
    public static Object[][] dataForTestFieldAgeSymbols() {
        return new Object[][]{
                {"-1", "Поле \"Возраст\" должно быть числовым"},
                {"a2", "Поле \"Возраст\" должно быть числовым"},
                {"<3", "Поле \"Возраст\" должно быть числовым"},
                {"  ", "Поле \"Возраст\" должно быть числовым"}
        };
    }

    @DataProvider(parallel = true)
    public static Object[][] dataForTestFieldAgeNumber() {
        return new Object[][]{
                {12, "Возраст должен быть между 13 и 80"},
                {81, "Возраст должен быть между 13 и 80"}
        };
    }

    @DataProvider(parallel = true)
    public static Object[][] dataForTestFieldGrowthSymbols() {
        return new Object[][]{
                {50, 82, ">1", "Поле \"Рост\" должно быть числовым"},
                {15, 52, ",3", "Поле \"Рост\" должно быть числовым"},
                {79, 120, "d5", "Поле \"Рост\" должно быть числовым"},
                {60, 107, " ", "Поле \"Рост\" должно быть числовым"}
        };
    }

    @DataProvider(parallel = true)
    public static Object[][] dataForTestFieldGrowthNumber() {
        return new Object[][]{
                {14, 42, 100, "Пожалуйста, введите реальный рост"},
                {25, 499, 251, "Пожалуйста, введите реальный рост"}
        };
    }

    @DataProvider(parallel = true)
    public Object[][] dataForTestFieldWeightSymbols() {
        return new Object[][]{
                {50, "-1", "Поле \"Вес\" должно быть числовым"},
                {15, ".3", "Поле \"Вес\" должно быть числовым"},
                {79, "d5", "Поле \"Вес\" должно быть числовым"},
                {60, "  ", "Поле \"Вес\" должно быть числовым"}
        };
    }

    @DataProvider(parallel = true)
    public Object[][] dataForTestWeightNumber() {
        return new Object[][]{
                {14, 40, "Пожалуйста, введите реальный вес"},
                {79, 501, "Пожалуйста, введите реальный вес"}
        };
    }
}
