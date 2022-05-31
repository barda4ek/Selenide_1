package pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    public static final String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    public static final String EXPECTED_TITLE = "My Store";

    public LoginPage() {super(URL, EXPECTED_TITLE);}

    public static SelenideElement emailField = $(byName("email"));
    public static SelenideElement passwordField = $(byName("passwd"));
    public SelenideElement signInButton = $(byName("SubmitLogin"));
    public SelenideElement errorMessage = $(byClassName("alert-danger"));

    public void setCorrectEmailAndPassword(){ //корректные данные для авторизации
        String EMAIL = "qa@test.ru";
        String PASSWORD = "021022";
        emailField.setValue(EMAIL);
        passwordField.setValue(PASSWORD);
    }

    public void setFalseEmailAndPassword(){ //некорректные данные для авторизации
        String FALSE_EMAIL = "q1@test.ru";
        String FALSE_PASSWORD = "021022";
        emailField.setValue(FALSE_EMAIL);
        passwordField.setValue(FALSE_PASSWORD);
    }

}
