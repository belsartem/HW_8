package tests;

import helpers.BaseTestSettings;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class StudentRegistrationFormTest extends BaseTestSettings {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void testCompleteRegistrationForm() {

        registrationPage
                .openPage()
                .setFirstName("Тест")
                .setLastName("Тестов")
                .setEmail("test@test.test")
                .setGender("Male")
                .setPhone("9010000001")
                .setDateOfBirth("31", "March", "2000")
                .setSubject("Computer Science")
                .setSubject("Arts")
                .setHobby("Sports")
                .uploadPicture("Designer.png")
                .setAddress("620620, Тестовая обл., г. Тестбург, ул. Тестина, д. 10")
                .setState("Haryana")
                .setCity("Panipat")
                .clickSubmit()
                .checkResultWindowAppear();

        registrationPage.checkResultModalWindowComponent("Student Name", "Тест Тестов")
                .checkResultModalWindowComponent("Student Email", "test@test.test")
                .checkResultModalWindowComponent("Gender", "Male")
                .checkResultModalWindowComponent("Mobile", "9010000001")
                .checkResultModalWindowComponent("Date of Birth", "31 March,2000")
                .checkResultModalWindowComponent("Subjects", "Computer Science, Arts")
                .checkResultModalWindowComponent("Hobbies", "Sports")
                .checkResultModalWindowComponent("Picture", "Designer.png")
                .checkResultModalWindowComponent("Address", "620620, Тестовая обл., г. Тестбург, ул. Тестина, д. 10")
                .checkResultModalWindowComponent("State and City", "Haryana Panipat");
    }

    @Test
    void testOnlyRequiredRegistrationForm() {

        registrationPage
                .openPage()
                .setFirstName("Тест")
                .setLastName("Тестов")
                .setGender("Male")
                .setPhone("9010000001")
                .clickSubmit()
                .checkResultWindowAppear();

        registrationPage.checkResultModalWindowComponent("Student Name", "Тест Тестов")
                .checkResultModalWindowComponent("Gender", "Male")
                .checkResultModalWindowComponent("Mobile", "9010000001");
    }

    @Test
    void testEmptyFields() {

        registrationPage
                .openPage()
                .clickSubmit()
                .checkResultWindowAbsent();
    }

    @Test
    void testNoNameAndLastName() {

        registrationPage
                .openPage()
                .setGender("Male")
                .setPhone("9010000001")
                .clickSubmit()
                .checkResultWindowAbsent();
    }
}