package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class SearchResultPage {

    @FindBy(css = "#center_column > ul > li")
    private ElementsCollection searchResults;


    public void checkOrderOfGoodsByPrice() {
        Map<String, String> namesPrices = new HashMap<>();
        for (int i = 0; i < searchResults.size(); i++ ) {
            namesPrices.put(searchResults.get(i).$(By.cssSelector(".product-name")).getText(),
                            searchResults.get(i).$(By.cssSelector("#center_column > ul > li:nth-child(" + i+1 + ") > div > div.right-block > div.content_price > span")).getText());
        }
        System.out.println(namesPrices);

    }




}
