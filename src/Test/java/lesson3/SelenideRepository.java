package lesson3;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepository {

    @Test
    void shouldFindSelenide() {
        // Открыть github
        open("https://github.com/");
        // Ввести в поисковую строку selenide и нажать "Поиск"
        $("[data-target='qbsearch-input.inputButton']").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        // Нажать на линк от первого результата
        $$("div.List-module__List__fNMbL").first().$("a").click();
        // check: в заголовке встречается selenide.selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }


}
