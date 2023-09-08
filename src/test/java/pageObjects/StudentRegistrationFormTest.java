package pageObjects;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pageObjects.pages.StudentRegistrationFormPage;


public class StudentRegistrationFormTest {

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
    public String photo = "photo_1.png";
    public String address = "The city of Moscow";
    public String selectState = "NCR";
    public String selectCity = "Delhi";

    StudentRegistrationFormPage studentRegistrationForm = new StudentRegistrationFormPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successfulRegistrationWithRequiredFieldsTest() {
        studentRegistrationForm
                .openPage()
                .setRequiredFields(firstName,
                        lastName,
                        gender,
                        number,
                        day,
                        month,
                        year)
                .clickSubmit()
                .checkResultRequiredFields(firstName,
                        lastName,
                        gender,
                        number,
                        day,
                        month,
                        year)
                .clickClose();
    }

    @Test
    void successfulRegistrationWithAllFieldsTest() {
        studentRegistrationForm
                .openPage()
                .setAllFields(firstName,
                        lastName,
                        email,
                        gender,
                        number,
                        day,
                        month,
                        year,
                        subjects,
                        hobbies,
                        photo,
                        address,
                        selectState,
                        selectCity)
                .clickSubmit()
                .checkResultAllFields(firstName,
                        lastName,
                        email,
                        gender,
                        number,
                        day,
                        month,
                        year,
                        subjects,
                        hobbies,
                        photo,
                        address,
                        selectState,
                        selectCity)
                .clickClose();
    }
}