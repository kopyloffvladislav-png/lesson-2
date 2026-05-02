package package1.pages;

import com.codeborne.selenide.SelenideElement;
import package1.pages.components.DatepickerComponent;
import package1.pages.components.ResultTable;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FillFormPages {
    DatepickerComponent datepickerComponent = new DatepickerComponent();
    ResultTable resultTable = new ResultTable();

    // Elements
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderCheckboxCollection = $("#genterWrapper"),
            submitButton = $("#submit");


    // Actions

    public FillFormPages openPage() {
        open("/automation-practice-form");
        return this;
    }

    public FillFormPages setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }


    public FillFormPages setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public FillFormPages setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public FillFormPages setGender(String value) {
        genderCheckboxCollection.$(byText(value)).click();
        return this;
    }

    public FillFormPages setBirthDate(String day, String month, String year) {
        $(".react-datepicker-wrapper").click();
        datepickerComponent.setDate(day, month, year);
        return this;
    }

    public FillFormPages setSubjects(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }

    public FillFormPages setHobbie(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public FillFormPages setAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public FillFormPages setUserNumber(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public FillFormPages setCountry(String value) {
        $("#react-select-3-input").setValue(value).pressEnter();
        return this;
    }

    public FillFormPages setCity(String value) {
        $("#react-select-4-input").setValue(value).pressEnter();
        return this;
    }

    public FillFormPages setPicture() {
        $("#uploadPicture").uploadFromClasspath("Снимок экрана 2025-06-03 231058.png");
        return this;
    }

    public FillFormPages checkVisibilityOfTable() {
        resultTable.checkVisible();
        return this;
    }

    public FillFormPages checkResultTable(String value, String assertValue) {
        resultTable.tableStrCheck(value, assertValue);
        return this;
    }

    public FillFormPages pressSubmit() {
        submitButton.click();
        return this;
    }

}



