package test.me;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBox {
    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "Chrome";
        Configuration.holdBrowserOpen = false;
        Configuration.browserVersion = "114.0.5735.90";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Владислав");
        $("#userEmail").setValue("kopyloff.vladislav@gmail.com");
     //   $("[placeholder=Current Address]").setValue("СПб");
        $("#currentAddress").setValue("СПб");
        $("#permanentAddress").setValue("Коми");
        $("#submit").click();
      //  $("#output").$("#name").shouldHave(text("Владислав"));
        $("#output #name").shouldHave(text("Владислав"));
        $("#output #email").shouldHave(text("kopyloff.vladislav@gmail.com"));
        $("#output #currentAddress").shouldHave(text("СПб"));
        $("#output #permanentAddress").shouldHave(text("Коми"));
    }
    }



