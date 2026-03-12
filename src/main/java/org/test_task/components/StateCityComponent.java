package org.test_task.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class StateCityComponent {

    private static final Duration TIMEOUT = Duration.ofSeconds(5);

    private final DropdownComponent dropdown = new DropdownComponent();

    private final SelenideElement stateInput = $x("//input[@id='react-select-3-input']");
    private final SelenideElement cityInput = $x("//input[@id='react-select-4-input']");

    @Step("User selects state: {state}")
    public StateCityComponent selectState(String state) {
        dropdown.selectValue(stateInput, state);
        return this;
    }

    @Step("User selects city: {city}")
    public StateCityComponent selectCity(String city) {
        dropdown.selectValue(cityInput, city);
        return this;
    }

    @Step("User selects state: {state} and city: {city}")
    public StateCityComponent selectStateAndCity(String state, String city) {
        return selectState(state).selectCity(city);
    }
}