package pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class OrderPage extends Page {
    public static final String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    public static final String EXPECTED_TITLE = "Order - My Store";

    public OrderPage(){super(URL, EXPECTED_TITLE);}

    public SelenideElement firstSummary= $("#cart_summary>tbody>tr:nth-of-type(1)");
    public SelenideElement totalPrice = $("#total_price");
    public SelenideElement proceedToCheckoutButton = $("#page > div.columns-container")
                                                    .$(byText("Proceed to checkout"));
    public SelenideElement commentField = $(".form-control");
    public SelenideElement agreementCheckbox = $("#cgv");
    public SelenideElement payByBandField = $(".bankwire");
    public SelenideElement confirmButton = $(byText("I confirm my order"));


    public void confirmSteps(){
        proceedToCheckoutButton.click();
        commentField.setValue("Please, deliver these dresses as soon as possible. I'm seriously.");
        proceedToCheckoutButton.click(); agreementCheckbox.click();
        proceedToCheckoutButton.click(); payByBandField.click(); confirmButton.click();
    }

    public void orderCompleteCheck(){
        $("#center_column > div > p").shouldHave(text("Your order on My Store is complete."));}






}
