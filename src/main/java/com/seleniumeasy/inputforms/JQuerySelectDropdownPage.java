package com.seleniumeasy.inputforms;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$$;

public class JQuerySelectDropdownPage extends DemoHomePage {
    private final SelenideElement selectedTerritory = $x("//span[@style='width: 50%;']" +
            "//span[@class='select2-selection__rendered']");
    private final ElementsCollection dropdownSelectTerritories = $$(".js-example-disabled-results option");

    public JQuerySelectDropdownPage selectTerritoryByName(String name) throws Exception {
        if (dropdownSelectTerritories.find(exactText(name)).isEnabled()) {
            dropdownSelectTerritories.find(exactText(name)).setSelected(true);
        } else {
            throw new Exception("This option is disabled!");
        }
        return this;
    }

    public JQuerySelectDropdownPage selectTerritoryByIndex(int index) throws Exception {
        if (dropdownSelectTerritories.get(index).isEnabled()) {
            dropdownSelectTerritories.get(index).setSelected(true);
        } else {
            throw new Exception("This option is disabled!");
        }
        return this;
    }

    public void validateDisplayedOption(Condition c) {
        selectedTerritory.shouldHave(c);
    }
}