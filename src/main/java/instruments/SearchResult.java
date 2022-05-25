package instruments;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class SearchResult {
    private int id;
    private String name;
    private float cost;

    private static String EXPECTED_TITLE = "Search - My Store";
    public  static SelenideElement numberOfItemsFound = $(byClassName("heading-counter"));
    public SelenideElement sortByButton = $(byId("selectProductSort"));
    public static int numberOfItems = getNumbers();

    public void lowestFirstOrder(){sortByButton.selectOption("Price: Lowest first");}

    public static int getNumbers(){
        numberOfItemsFound.click();
        String text = numberOfItemsFound.getText();
        String numText = text.substring(0, 1);
        return Integer.parseInt (numText);
    }

    static String getNameByDriver(int id){
        SelenideElement itemName =
                $(byXpath("//*[@id=\"center_column\"]/ul/li[" + id + "]/div/div[2]/h5/a"));
        return itemName.getText();
    }

    static float getCostByDriver(int id){
        SelenideElement itemCost =
                $(byXpath("//*[@id=\"center_column\"]/ul/li[" + id + "]/div/div[2]/div[1]/span[1]"));
        String costString = itemCost.getText();
        String s1 = costString.substring(1); //обрезаем символ '$' в поле цены для парсинга float
        return Float.parseFloat(s1);
    }

    public int getId() {return id;}
    public String getName() {return name;} //получение имени конкретного найденного товара
    public float getCost() {return cost;} //получение цены

    // формирование списка всех найденных товаров
    /*public static TreeMap<String, SearchResult> itemsList = locateItems();

    *//*public static TreeMap<String, SearchResult> locateItems() {
        var a = new TreeMap<String, SearchResult>();
        for (int id = 1; id < SearchResult.numberOfItems + 1; id++) {
            a.put(getNameByDriver(id), new SearchResult(id, getNameByDriver(id), getCostByDriver(id)));
        }
        a.get("name");
        return a;
    }*/

    SearchResult(){


    }



}
