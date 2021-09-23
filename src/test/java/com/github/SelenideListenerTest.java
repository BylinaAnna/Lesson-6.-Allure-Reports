package com.github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.*;

public class SelenideListenerTest {
    @Test
    public void testGithubSelenide() {
        open("https://github.com/");
        $(".header-search-input").setValue("eroshenkoam/allure-example").submit();
        $(linkText("eroshenkoam/allure-example")).click();
        $(partialLinkText("Issues")).click();
        $(withText("68")).should(Condition.visible);
    }
}
