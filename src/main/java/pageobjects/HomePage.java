package pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomePage extends BasePage {
    //добавить бейс самого сайта.
    public static final String URL = "http://automationpractice.com/index.php";
    public static final String EXPECTED_TITLE = "My Store";

    public HomePage(){super(URL, EXPECTED_TITLE);}

    public SelenideElement loginButton = $(byText("Sign in"));

    @FindBy(css = "")
    private SelenideElement loginButton2;



    public ElementsCollection popularItems= $$("#homefeatured");

    public SelenideElement firstItemImage =
            $("[href='http://automationpractice.com/index.php?id_product=1&controller=product']");
    public SelenideElement firstItemAdd = $("#homefeatured [data-id-product=\"1\"]");
    public SelenideElement secondItemImage =
            $("[href='http://automationpractice.com/index.php?id_product=2&controller=product']");
    public SelenideElement secondItemAdd = $("#homefeatured [data-id-product=\"2\"]");
    public SelenideElement continueShoppingButton = $("[title='Continue shopping']");
    public SelenideElement proceedCheckoutButton = $("[title='Proceed to checkout']");
}