package com.github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepTest {
    private final static String REPO = "eroshenkoam/allure-example";
    private final static String ISSUE_NUM = "68";
    @Test
    public void testGithubLambdaStep() {
        step("Открываем главную страницу",() ->
                open("https://github.com/"));
        step("Ищем репозиторий "+REPO, () ->
                $(".header-search-input").setValue(REPO).submit());
        step("Переходим в репозиторий " + REPO, ()->
                $(linkText(REPO)).click());
        step("Открываем раздел Issues ", () ->
                $(partialLinkText("Issues")).click());
        step("Проверяем наличие Issue с номером " + ISSUE_NUM, () ->
            $(withText(ISSUE_NUM)).should(Condition.visible));
    }
}