package pageobjects;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;


public class BasePage {
    String URL;
    String EXPECTED_TITLE;

    BasePage(String URL, String EXPECTED_TITLE){
        this.URL = URL;
        this.EXPECTED_TITLE = EXPECTED_TITLE;
    }

    //сюда вынесены повторяющиеся (общие) элементы и методы
    public SelenideElement searchField = $(byName("search_query"));
    public SelenideElement searchButton = $(byName("submit_search"));

    public static void go(BasePage page){
        open(page.URL);
        assertThat(title()).contains(page.EXPECTED_TITLE);}

    public static void isPage(BasePage page){
        assertThat(title()).contains(page.EXPECTED_TITLE);
    }

}
