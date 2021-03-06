package com.seleniumeasy.tests.inputforms.jquerydropdown;

import com.seleniumeasy.inputforms.DropdownCategory;
import org.testng.annotations.Test;
import utils.BaseTest;

import static com.seleniumeasy.enums.InputForms.JQUERY_SELECT_DROPDOWN;

public class DropdownCategoryTest extends BaseTest {

    DropdownCategory dropdownCategory = new DropdownCategory();

    @Test
    public void testSelectFileByName() throws Exception {
        dropdownCategory
                .openInputForms(JQUERY_SELECT_DROPDOWN, DropdownCategory.class)
                .selectFileByName("Python")
                .validateDisplayedFile("Python");
    }

    @Test
    public void testSelectFileByIndex() throws Exception {
        dropdownCategory
                .openInputForms(JQUERY_SELECT_DROPDOWN, DropdownCategory.class)
                .selectFileByIndex(2, 1)
                .validateDisplayedFile("C");
    }

    @Test
    public void testSelectFileFromCategory() throws Exception {
        dropdownCategory
                .openInputForms(JQUERY_SELECT_DROPDOWN, DropdownCategory.class)
                .selectFileFromCategory("Programming languages", "Java")
                .validateDisplayedFile("Java");
    }
}