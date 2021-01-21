package com.seleniumeasy.tests.simpleform;

import com.seleniumeasy.inputforms.SimpleFormDemoPage;
import utils.SettingsSeleniumEasy;
import org.junit.Test;

import static com.seleniumeasy.enums.InputForms.SIMPLE_FORM_DEMO;

public class UsernameTest extends SettingsSeleniumEasy {
    private final String MESSAGE = "Serhii Bastrykin";

    SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage();

    @Test
    public void enterMessage() {
        simpleFormDemoPage
                .openInputForms(SIMPLE_FORM_DEMO, SimpleFormDemoPage.class)
                .enterYourMessage(MESSAGE)
                .clickShowMessageButton()
                .validateDisplayedMessage(MESSAGE);
    }
}