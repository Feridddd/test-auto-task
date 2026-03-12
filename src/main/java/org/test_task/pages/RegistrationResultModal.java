package org.test_task.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class RegistrationResultModal extends BasePage {

    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

    private final SelenideElement modalTitle =
            $x("//div[contains(@class,'modal-title') and text()='Thanks for submitting the form']");

    private final SelenideElement modalWindow =
            $x("//div[contains(@class,'modal-content')]");

    private final SelenideElement closeButton =
            $x("//button[@id='closeLargeModal']");

    @Step("Verify registration result modal is visible")
    public RegistrationResultModal shouldBeVisible() {
        modalTitle.shouldBe(Condition.visible, DEFAULT_TIMEOUT);
        modalWindow.shouldBe(Condition.visible, DEFAULT_TIMEOUT);
        return this;
    }

    @Step("Verify result row '{label}' has value '{expectedValue}'")
    public RegistrationResultModal shouldHaveValue(String label, String expectedValue) {
        getValueCell(label).shouldHave(Condition.exactText(expectedValue));
        return this;
    }

    @Step("Verify result row '{label}' contains value '{expectedValue}'")
    public RegistrationResultModal shouldContainValue(String label, String expectedValue) {
        getValueCell(label).shouldHave(Condition.text(expectedValue));
        return this;
    }

    private SelenideElement getValueCell(String label) {
        return $x("//td[text()='" + label + "']/following-sibling::td");
    }
}