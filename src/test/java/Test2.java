import org.testng.annotations.Test;
import pageobjects.SearchResultPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class Test2 {

    @Test
    public void test() {
        SearchResultPage a = page(SearchResultPage.class);
        open("http://automationpractice.com/index.php?controller=search&search_query=dress&submit_search=&orderby=price&orderway=asc");
        a.checkOrderOfGoodsByPrice();

    }

}
