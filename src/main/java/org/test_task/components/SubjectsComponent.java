package org.test_task.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SubjectsComponent {

    private final SelenideElement input = $x("//input[@id='subjectsInput']");

    public void selectSubject(String subject) {
        input.setValue(subject.substring(0, 1));

        $x("//div[contains(@class,'subjects-auto-complete__option') and text()='" + subject + "']")
                .shouldBe(Condition.visible)
                .click();
    }
}