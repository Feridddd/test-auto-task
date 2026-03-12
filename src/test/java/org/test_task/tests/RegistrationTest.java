package org.test_task.tests;

import org.test_task.enums.Gender;
import org.test_task.enums.Hobby;
import org.test_task.pages.RegistrationPage;
import org.test_task.pages.RegistrationResultModal;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void openRegistrationPage() {
        open("/automation-practice-form");
    }
    @Test
    public void registrationTest() {
        RegistrationResultModal resultModal = new RegistrationPage()
                .enterFirstName("John")
                .enterLastName("Doe")
                .enterEmail("doe@gmail.com")
                .selectGender(Gender.FEMALE)
                .enterMobile("2323232323")
                .setDateOfBirth("30", "April", "1998")
                .selectSubjects("English", "Maths")
                .selectHobbies(Hobby.MUSIC, Hobby.READING)
                .uploadPicture("meow.jpg")
                .enterAddress("Labubu street")
                .selectStateAndCity("NCR", "Delhi")
                .submit();

        resultModal.shouldBeVisible()
                .shouldHaveValue("Student Name", "John Doe")
                .shouldHaveValue("Student Email", "doe@gmail.com")
                .shouldHaveValue("Gender", "Female")
                .shouldHaveValue("Mobile", "2323232323")
                .shouldHaveValue("Subjects", "English, Maths")
                .shouldHaveValue("Hobbies", "Music, Reading")
                .shouldHaveValue("Picture", "meow.jpg")
                .shouldHaveValue("Address", "Labubu street")
                .shouldHaveValue("State and City", "NCR Delhi");
    }

    @Test
    public void shouldHighlightRequiredFieldsWhenSubmittingEmptyForm() {
        RegistrationPage page = new RegistrationPage()
                .clickSubmit();

        page.shouldHaveInvalidFirstName()
                .shouldHaveInvalidLastName()
                .shouldHaveInvalidMobile();
    }
    @Test
    public void shouldSubmitFormWithOnlyRequiredFields() {
        RegistrationResultModal resultModal = new RegistrationPage()
                .enterFirstName("John")
                .enterLastName("Doe")
                .selectGender(Gender.MALE)
                .enterMobile("1234567890")
                .submit();

        resultModal.shouldBeVisible()
                .shouldHaveValue("Student Name", "John Doe")
                .shouldHaveValue("Gender", "Male")
                .shouldHaveValue("Mobile", "1234567890");
    }
}