package package1.pages.components;

import com.codeborne.selenide.SelenideElement;
import package1.pages.FillFormPages;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTable {
    private final static String HEADER = "Thanks for submitting the form";

    public ResultTable checkVisible() {
        $(".modal-lg").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(HEADER));
    return this;
    }

    public ResultTable tableStrCheck(String value, String assertValue) {
        $(".table-responsive").$(byText(value))
            .parent().shouldHave(text(assertValue));
        return this;
    }
}

