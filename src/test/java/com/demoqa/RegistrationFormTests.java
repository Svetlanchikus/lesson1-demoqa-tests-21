package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {
    public String firstName = "Petr";
    public String lastName = "Petrov";
    public String email = "Pert@mail.com";
    public String gender = "Male";
    public String number = "1223456789";
    public String month = "March";
    public String year = "1917";
    public String day = "15";
    public String subjects = "Arts";
    public String hobbies = "Music";
    public String foto = "foto.png";
    public String address = "The city of Moscow";
    public String selectState = "NCR";
    public String selectCity = "Delhi";


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

//        Заполнение полей

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText(gender)).click();
        $("#userNumber").setValue(number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container--select").click();
        $(byText(month)).click();
        $(".react-datepicker__year-dropdown-container--select").click();
        $(byText(year)).click();
        $(byText(day)).click();
        $("#subjectsInput").setValue("a");
        $(byText(subjects)).click();
        $(byText(hobbies)).click();
        $("input#uploadPicture").uploadFromClasspath(foto);
        $("#currentAddress").setValue(address);
        $(".css-1wa3eu0-placeholder").click();
        $(byText(selectState)).click();
        $(".css-1wa3eu0-placeholder").click();
        $(byText(selectCity)).click();
        $("#submit").click();

//        Проверка формы регистрации

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//tbody/tr[1]/td[2]").shouldHave(text(firstName + " " + lastName));
        $x("//tbody/tr[2]/td[2]").shouldHave(text(email));
        $x("//tbody/tr[3]/td[2]").shouldHave(text(gender));
        $x("//tbody/tr[4]/td[2]").shouldHave(text(number));
        $x("//tbody/tr[5]/td[2]").shouldHave(text(day + " " + month + "," + year));
        $x("//tbody/tr[6]/td[2]").shouldHave(text(subjects));
        $x("//tbody/tr[7]/td[2]").shouldHave(text(hobbies));
        $x("//tbody/tr[8]/td[2]").shouldHave(text(foto));
        $x("//tbody/tr[9]/td[2]").shouldHave(text(address));
        $x("//tbody/tr[10]/td[2]").shouldHave(text(selectState + " " + selectCity));

        $("#closeLargeModal").click();
    }
}
