package package1.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import package1.pages.FillFormPages;


public class TestForm {
    FillFormPages fillFormPages = new FillFormPages();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserVersion = "114.0.5735.90";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void checkForm() {
        //Открыть сайт
        fillFormPages.openPage()

        //Заполнить поля
                .setFirstName("Влад")
                .setLastName("Копылов")
                .setEmail("kopyloff.vladislav@gmail.com")
                .setGender("Other")
                .setBirthDate("12","September", "2000")
                .setUserNumber("9121093456")
                .setSubjects("Arts")
                .setHobbie("Reading")
                .setPicture()
                .setAddress("Россия, СПб")
                .setCountry("NCR")
                .setCity("Delhi")

        //Нажать кнопку "Submit"
                .pressSubmit()

        //Проверить значения в полученной форме
                .checkVisibilityOfTable()
                .checkResultTable("Student Name", "Влад Копылов")
                .checkResultTable("Student Email", "kopyloff.vladislav@gmail.com")
                .checkResultTable("Gender", "Other")
                .checkResultTable("Mobile", "9121093456")
                .checkResultTable("Date of Birth", "12 September,2000")
                .checkResultTable("Subjects", "Arts")
                .checkResultTable("Hobbies", "Reading")
                .checkResultTable("Picture", "Снимок экрана 2025-06-03 231058.png")
                .checkResultTable("Address", "Россия, СПб")
                .checkResultTable("State and City", "NCR Delhi");
    }
}