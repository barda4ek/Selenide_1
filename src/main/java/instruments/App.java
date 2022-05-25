package instruments;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.OrderPage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static pageobjects.Page.go;
import static pageobjects.Page.isPage;

public class App {
        public static LoginPage loginPage = new LoginPage();
        public static HomePage homePage = new HomePage();
        public static OrderPage orderPage = new OrderPage();

        public static void incorrectLogin(){
                go(homePage);
                homePage.loginButton.click();
                isPage(loginPage);
                loginPage.setFalseEmailAndPassword();
                loginPage.signInButton.click();
                loginPage.errorMessage.shouldBe(visible.because("введены неверные данные авторизации"));
        }

        public static void correctLogin(){
                go(homePage);
                homePage.loginButton.click();
                isPage(loginPage);
                loginPage.setCorrectEmailAndPassword();
                loginPage.signInButton.click();
                loginPage.errorMessage.shouldNot(exist.because("введены верные данные авторизации"));
        }
    }


