package org.test_task.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.test_task.components.DatePickerComponent;
import org.test_task.components.HobbiesComponent;
import org.test_task.components.StateCityComponent;
import org.test_task.components.SubjectsComponent;
import org.test_task.enums.Gender;
import org.test_task.enums.Hobby;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage extends BasePage {

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement mobileInput = $("#userNumber");
    private final SelenideElement uploadPictureInput = $("#uploadPicture");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement submitButton = $("#submit");

    private final DatePickerComponent datePicker = new DatePickerComponent();
    private final SubjectsComponent subjectsComponent = new SubjectsComponent();
    private final HobbiesComponent hobbiesComponent = new HobbiesComponent();
    private final StateCityComponent stateCityComponent = new StateCityComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    @Step("User enters first name: {firstName}")
    public RegistrationPage enterFirstName(String firstName) {
        type(firstNameInput, firstName);
        return this;
    }

    @Step("User enters last name: {lastName}")
    public RegistrationPage enterLastName(String lastName) {
        type(lastNameInput, lastName);
        return this;
    }

    @Step("User enters email: {email}")
    public RegistrationPage enterEmail(String email) {
        type(emailInput, email);
        return this;
    }

    @Step("User selects gender: {gender}")
    public RegistrationPage selectGender(Gender gender) {
        click($x(gender.getXpath()));
        return this;
    }

    @Step("User enters mobile number: {mobile}")
    public RegistrationPage enterMobile(String mobile) {
        type(mobileInput, mobile);
        return this;
    }

    @Step("User sets date of birth: {day} {month} {year}")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        datePicker.selectDate(day, month, year);
        return this;
    }

    @Step("User selects subjects")
    public RegistrationPage selectSubjects(String... subjects) {
        for (String subject : subjects) {
            subjectsComponent.selectSubject(subject);
        }
        return this;
    }

    @Step("User selects hobbies")
    public RegistrationPage selectHobbies(Hobby... hobbies) {
        hobbiesComponent.selectHobbies(hobbies);
        return this;
    }

    @Step("User uploads picture: {fileName}")
    public RegistrationPage uploadPicture(String fileName) {
        File file = new File("src/test/resources/images/" + fileName);
        uploadPictureInput.uploadFile(file);
        return this;
    }

    @Step("User enters current address: {address}")
    public RegistrationPage enterAddress(String address) {
        type(currentAddressInput, address);
        return this;
    }

    @Step("User selects state: {state} and city: {city}")
    public RegistrationPage selectStateAndCity(String state, String city) {
        stateCityComponent.selectStateAndCity(state, city);
        return this;
    }

    @Step("First name field should be invalid")
    public RegistrationPage shouldHaveInvalidFirstName() {
        Boolean valid = executeJavaScript("return arguments[0].checkValidity();", firstNameInput);
        if (Boolean.TRUE.equals(valid)) {
            throw new AssertionError("First name field is valid, but expected invalid");
        }
        return this;
    }

    @Step("Last name field should be invalid")
    public RegistrationPage shouldHaveInvalidLastName() {
        Boolean valid = executeJavaScript("return arguments[0].checkValidity();", lastNameInput);
        if (Boolean.TRUE.equals(valid)) {
            throw new AssertionError("Last name field is valid, but expected invalid");
        }
        return this;
    }

    @Step("Mobile field should be invalid")
    public RegistrationPage shouldHaveInvalidMobile() {
        Boolean valid = executeJavaScript("return arguments[0].checkValidity();", mobileInput);
        if (Boolean.TRUE.equals(valid)) {
            throw new AssertionError("Mobile field is valid, but expected invalid");
        }
        return this;
    }


    @Step("User submits registration form")
    public RegistrationResultModal submit() {
        scrollToAndClick(submitButton);
        return new RegistrationResultModal();
    }

    @Step("User submits registration form")
    public RegistrationPage clickSubmit() {
        scrollToAndClick(submitButton);
        return this;
    }
}