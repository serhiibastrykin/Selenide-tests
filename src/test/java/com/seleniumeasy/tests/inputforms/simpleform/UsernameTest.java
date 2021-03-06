package com.seleniumeasy.tests.inputforms.simpleform;

import com.seleniumeasy.inputforms.SimpleFormDemoPage;
import utils.BaseTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.seleniumeasy.enums.InputForms.SIMPLE_FORM_DEMO;

public class UsernameTest extends BaseTest {
    private final String message = "Serhii Bastrykin";

    SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage();

    @Test
    public void enterMessage() {
        simpleFormDemoPage
                .openInputForms(SIMPLE_FORM_DEMO, SimpleFormDemoPage.class)
                .enterYourMessage(message)
                .clickShowMessageButton()
                .validateDisplayedMessage(exactText(message));
    }
}