package ru.zavrichko;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ParameterizedWebTest {

    // value source
    @DisplayName("Тестирование общего алгоритма поиска")
    @ValueSource(strings = {"car", "map"})
    @ParameterizedTest(name = "Тестирование общего алгоритма поиска с тестовыми данными: {0}")
    void commonSearchTest(String testData) {
        open("https://www.amazon.com/");
        $("#twotabsearchtextbox").setValue(testData);
        $("#nav-search-submit-button").click();
        $(".sg-col-inner")
                .shouldHave(text(testData));
    }




//    @DisplayName("Тестирование общего алгоритма поиска")
//    @CsvSource(value = {
//            "Selenide, Вышла Selenide ",
//            "Junit, 5 is the next generation of "
//    })
//    @ParameterizedTest(name = "Тестирование общего алгоритма поиска с тестовыми данными: {0}")
//    void csvSearchTest(String testData, String expectedResult) {
//        open("https://ya.ru");
//        $("#text").setValue(testData);
//        $("button[type='submit']").click();
//        $$("li.serp-item")
//                .first()
//                .shouldHave(text(expectedResult));
//    }





}
