package test.me;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestForm {
    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "Chrome";
        Configuration.holdBrowserOpen = false;
        Configuration.browserVersion = "114.0.5735.90";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void checkForm() {
        //Открыть сайт
        open("/automation-practice-form");

        // Заполнить все поля
        $("#firstName").setValue("Влад");
        $("#lastName").setValue("Копылов");
        $("#userEmail").setValue("kopyloff.vladislav@gmail.com");
        $("#gender-radio-3").click();
        $("#userNumber").setValue("9121093456");
        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__year-select").click();
        $$("option").findBy(text("2000")).click();
        $(".react-datepicker__month-select").click();
        $$("option").findBy(text("September")).click();
        $(".react-datepicker__day--012").click();
        $("#subjectsInput").setValue("Arts").sendKeys(Keys.ENTER);
        $("#hobbies-checkbox-2").click();
        $("#currentAddress").setValue("СПб");
        $("#react-select-3-input").sendKeys("NCR" + Keys.ENTER);
        $("#react-select-4-input").sendKeys("Delhi" + Keys.ENTER);
        $("#uploadPicture").uploadFromClasspath("Снимок экрана 2025-06-03 231058.png");

        //Нажать кнопку "Submit"
        $("#submit").click();

        //Проверить значения в полученной форме
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $$("tr").findBy(text("Student Name")).shouldHave(text("Влад Копылов"));
        $$("tr").findBy(text("Student Email")).shouldHave(text("kopyloff.vladislav@gmail.com"));
        $$("tr").findBy(text("Gender")).shouldHave(text("Other"));
        $$("tr").findBy(text("Mobile")).shouldHave(text("9121093456"));
        $$("tr").findBy(text("Date of Birth")).shouldHave(text("12 September,2000"));
        $$("tr").findBy(text("Subjects")).shouldHave(text("Arts"));
        $$("tr").findBy(text("Hobbies")).shouldHave(text("Reading"));
        $$("tr").findBy(text("Picture")).shouldHave(text("Снимок экрана 2025-06-03 231058.png"));
        $$("tr").findBy(text("Address")).shouldHave(text("СПб"));
        $$("tr").findBy(text("State and City")).shouldHave(text("NCR Delhi"));
    }
}