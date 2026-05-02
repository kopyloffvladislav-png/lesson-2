package package1.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import package1.pages.FillFormPages;
import package1.pages.components.ResultTable;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestForm {
    FillFormPages fillFormPages = new FillFormPages();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "Chrome";
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
                .setUserNumber("9121093456");


        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbies-checkbox-2").click();
        $("#currentAddress").setValue("СПб");
        $("#react-select-3-input").sendKeys("NCR" + Keys.ENTER);
        $("#react-select-4-input").sendKeys("Delhi" + Keys.ENTER);
        $("#uploadPicture").uploadFromClasspath("Снимок экрана 2025-06-03 231058.png");

        //Нажать кнопку "Submit"
        fillFormPages.pressSubmit();

        //Проверить значения в полученной форме
        fillFormPages.checkVisibilityOfTable()
                .checkResultTable("Student Name", "Влад Копылов")
                .checkResultTable("Student Email", "kopyloff.vladislav@gmail.com")
                .checkResultTable("Gender", "Other")
                .checkResultTable("Mobile", "9121093456")
                .checkResultTable("Date of Birth", "12 September,2000")
                .checkResultTable("Subjects", "Arts")
                .checkResultTable("Hobbies", "Reading")
                .checkResultTable("Picture", "Снимок экрана 2025-06-03 231058.png")
                .checkResultTable("Address", "Влад Копылов")
                .checkResultTable("Student Name", "СПб")
                .checkResultTable("State and City", "NCR Delhi");
    }
}