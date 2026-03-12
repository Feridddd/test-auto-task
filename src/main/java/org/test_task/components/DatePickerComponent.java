package org.test_task.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DatePickerComponent {

    private final SelenideElement dateInput =
            $x("//input[@id='dateOfBirthInput']");

    private final SelenideElement monthSelect =
            $x("//select[@class='react-datepicker__month-select']");

    private final SelenideElement yearSelect =
            $x("//select[@class='react-datepicker__year-select']");

    public void selectDate(String day, String month, String year) {
        dateInput.click();
        yearSelect.selectOption(year);
        monthSelect.selectOption(month);
        $x("//div[contains(@class,'react-datepicker__day') and " +
                "not(contains(@class,'outside-month')) and text()='" + day + "']")
                .click();
    }
}