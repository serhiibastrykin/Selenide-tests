package com.seleniumeasy.tests.listbox;

import com.seleniumeasy.listbox.JQueryListBoxPage;
import org.testng.annotations.Test;
import utils.BaseTest;

import static com.seleniumeasy.enums.ListBox.JQUERY_LIST_BOX;

public class JQueryListBoxTest extends BaseTest {

    JQueryListBoxPage jQueryListBoxPage = new JQueryListBoxPage();

    @Test
    public void testAddItem() {
        String name = "Helena";
        jQueryListBoxPage
                .openListBox(JQUERY_LIST_BOX, JQueryListBoxPage.class)
                .addItemsToResultList(name)
                .validateItemsAreNotDisplayedInPickList(name)
                .validateItemsAreDisplayedInResultList(name);
    }

    @Test
    public void testRemoveItem() {
        String name = "Alice";
        jQueryListBoxPage
                .openListBox(JQUERY_LIST_BOX, JQueryListBoxPage.class)
                .addItemsToResultList(name)
                .validateItemsAreDisplayedInResultList(name)
                .removeItemsFromResultList(name)
                .validateItemsAreNotDisplayedInResultList(name)
                .validateItemsAreDisplayedInPickList(name);
    }

    @Test
    public void testAddItems() {
        String[] names = {"Luiza", "Laura", "Isis"};
        jQueryListBoxPage
                .openListBox(JQUERY_LIST_BOX, JQueryListBoxPage.class)
                .addItemsToResultList(names)
                .validateItemsAreNotDisplayedInPickList(names)
                .validateItemsAreDisplayedInResultList(names);
    }

    @Test
    public void testRemoveItems() {
        String[] names = {"Beatriz", "Giovanna", "Lara", "Julia"};
        jQueryListBoxPage
                .openListBox(JQUERY_LIST_BOX, JQueryListBoxPage.class)
                .addItemsToResultList(names)
                .validateItemsAreDisplayedInResultList(names)
                .removeItemsFromResultList(names)
                .validateItemsAreNotDisplayedInResultList(names)
                .validateItemsAreDisplayedInPickList(names);
    }

    @Test
    public void testAddAllItems() {
        jQueryListBoxPage
                .openListBox(JQUERY_LIST_BOX, JQueryListBoxPage.class)
                .addAllItemsToResultList()
                .validatePickListSize(0)
                .validateResultListSize(15);
    }

    @Test
    public void testRemoveAllItems() {
        jQueryListBoxPage
                .openListBox(JQUERY_LIST_BOX, JQueryListBoxPage.class)
                .addAllItemsToResultList()
                .validatePickListSize(0)
                .validateResultListSize(15)
                .removeAllItemsFromResultList()
                .validateResultListSize(0)
                .validatePickListSize(15);
    }
}