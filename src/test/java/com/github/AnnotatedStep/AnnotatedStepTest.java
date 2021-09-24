package com.github.AnnotatedStep;

import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {

    private final static String REPO = "eroshenkoam/allure-example";
    private final static String ISSUE_NUM = "68";

    @Test
    public void githubTest() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPO);
        steps.goToRepository(REPO);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUM);
    }
}
