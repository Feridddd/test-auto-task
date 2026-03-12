package org.test_task.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

public abstract class BasePage {

    protected static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

    protected void click(SelenideElement element) {
        element.shouldBe(Condition.visible, DEFAULT_TIMEOUT)
                .shouldBe(Condition.enabled, DEFAULT_TIMEOUT)
                .click();
    }

    protected void type(SelenideElement element, String text) {
        element.shouldBe(Condition.visible, DEFAULT_TIMEOUT)
                .setValue(text);
    }

    protected void scrollTo(SelenideElement element) {
        element.shouldBe(Condition.visible, DEFAULT_TIMEOUT)
                .scrollIntoView("{block: 'center'}");
    }

    protected void scrollToAndClick(SelenideElement element) {
        scrollTo(element);
        click(element);
    }
}