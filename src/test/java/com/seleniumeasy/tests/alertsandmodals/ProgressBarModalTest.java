package com.seleniumeasy.tests.alertsandmodals;

import com.seleniumeasy.alertsandmodals.ProgressBarModalPage;
import org.testng.annotations.Test;
import utils.BaseTest;

import static com.codeborne.selenide.Condition.exactText;
import static com.seleniumeasy.enums.AlertsAndModals.PROGRESS_BAR_MODAL;

public class ProgressBarModalTest extends BaseTest {

    ProgressBarModalPage progressBarModalPage = new ProgressBarModalPage();

    @Test
    public void testSimpleDialog() {
        progressBarModalPage
                .openAlertsAndModals(PROGRESS_BAR_MODAL, ProgressBarModalPage.class)
                .openSimpleDialog()
                .verifySimpleDialog(exactText("Loading"));
    }

    @Test
    public void testDialogWithCustomMessage() {
        progressBarModalPage
                .openAlertsAndModals(PROGRESS_BAR_MODAL, ProgressBarModalPage.class)
                .openDialogWithCustomMessage()
                .verifyDialogWithCustomMessage(exactText("Custom message"));
    }

    @Test
    public void testDialogWithCustomSettings() {
        progressBarModalPage
                .openAlertsAndModals(PROGRESS_BAR_MODAL, ProgressBarModalPage.class)
                .openDialogWithCustomSettings()
                .verifyDialogWithCustomSettings(exactText("Hello Mr. Alert !"));
    }
}