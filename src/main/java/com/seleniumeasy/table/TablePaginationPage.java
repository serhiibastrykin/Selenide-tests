package com.seleniumeasy.table;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.seleniumeasy.BasePage;

import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.tagName;

public class TablePaginationPage extends BasePage {
    private final ElementsCollection pagination = $$(".pager li"),
            rows = $$("tbody tr");

    public TablePaginationPage clickPage(int pageIndex) {
        pagination.get(pageIndex).$(tagName("a")).click();
        return this;
    }

    public void verifyClickedPage(int rowIndex, int colIndex, Condition c) {
        rows.get(rowIndex).$$("td").get(colIndex).should(c);
    }
}