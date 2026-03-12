package org.test_task.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class DropdownComponent {

    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    @Step("Select dropdown value: {value}")
    public void selectValue(SelenideElement input, String value) {
        input.shouldBe(Condition.visible, TIMEOUT);
        executeJavaScript("arguments[0].scrollIntoView({block:'center'});", input);
        executeJavaScript("arguments[0].click();", input);

        input.setValue(value);

        SelenideElement option = $x("//div[contains(@id,'option') and text()='" + value + "']")
                .shouldBe(Condition.visible, TIMEOUT);

        executeJavaScript("arguments[0].scrollIntoView({block:'center'});", option);
        option.click();
    }
}
