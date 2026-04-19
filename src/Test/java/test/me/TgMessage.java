package test.me;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.commands.PressEnter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class TgMessage {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://vk.com/";
        Configuration.browser = "Chrome";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void sendMessage() {
        open("/im/convo/468358279?entrypoint=list_all");
        open("/im/convo/468358279?entrypoint=list_all");
        $("[aria-label=Сообщение]").setValue("Прикинь, я написал программку, которая отправила это сообщение");
        new PressEnter();
    }
}