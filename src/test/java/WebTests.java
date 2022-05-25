import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.TextReportExtension;
import instruments.App;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static instruments.App.*;
import static instruments.App.orderPage;
import static pageobjects.Page.*;

@ExtendWith({TextReportExtension.class})

public class WebTests {
    @BeforeAll
    static void setupConfig(){
        //SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browserSize = "1930x1035";
        Configuration.browserPosition = "-4x0";
        Configuration.headless = false;
        Configuration.fastSetValue = true;
        App.incorrectLogin();
        App.correctLogin();
    }

    @Test //проверка покупки
    @DisplayName("Purchase test")
    void purchaseTest(){
        go(homePage);
        homePage.firstItemImage.hover(); //вынести ховер и эдд в отдельный метод?
        homePage.firstItemAdd.click();
        homePage.continueShoppingButton.click();
        homePage.secondItemImage.hover();
        homePage.secondItemAdd.click();
        homePage.proceedCheckoutButton.click();
        isPage(orderPage);
        orderPage.totalPrice.shouldHave(Condition.text("$45.51").because("cost should be 45.51!"));
        orderPage.confirmSteps();
        orderPage.orderCompleteCheck();
    }

    @Test //тест на фильтр по цене
    @DisplayName("Incorrect test")
    void secondTest(){
        go(homePage);
        System.out.println("Test 2 complete!");
    }



}
