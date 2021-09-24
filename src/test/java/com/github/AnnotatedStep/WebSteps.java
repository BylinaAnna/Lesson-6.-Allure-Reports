package com.github.AnnotatedStep;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Открываем главную старинцу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-input").setValue(repo).submit();
    }

    @Step("Переходим в репозиторий {repo}")
    public void goToRepository(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открываем раздел Issues ")
    public void openIssueTab() {
        $(partialLinkText("Issues")).click();
    }

    @Step("Проверяем наличие Issue с номером {num}")
    public void shouldSeeIssueWithNumber(String num) {
        $(withText(num)).should(Condition.visible);

    }
}
