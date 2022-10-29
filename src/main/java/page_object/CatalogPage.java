package page_object;

import com.it_academy.fraemwork.DriverManager;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class CatalogPage extends BasePage {

    public static final String CATALOG_MENU_ITEM_COMPUTER_AND_NETWORK_PATTERN =
            "//*[@class='catalog-navigation-classifier__item-title-wrapper' and contains(text(),'Компьютеры')]";
    public static final String ACCESSORIES_MENU_PATTERN =
            "//*[@class='catalog-navigation-list__aside-title' and contains(text(),'Комплектующие')]";
    private static final String CATALOG_PAGE_MENU_BAR_XPATH_PATTERN =
            "//span[@class='catalog-navigation-classifier__item-title-wrapper']";
    private static final String CATALOG_SUB_MENU_COMPUTER_AND_NETWORK_SECTION =
            "//div[contains(@class,'line-clamp-2')]";
    private static final String ACCESSORIES_ITEMS_TITLE =
            "//div[contains(@class,'catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active')]" +
                    "//span[contains(@class,'catalog-navigation-list__dropdown-title')]";
    private static final String ACCESSORIES_ITEMS_DESCRIPTION =
            "//div[contains(@class,'catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active')]" +
                    "//span[contains(@class,'catalog-navigation-list__dropdown-description')]";

    public static List<String> collectElementsFromPages(String itemsName) {
        List<String> itemCatalog = new ArrayList<>();
        DriverManager.getDriver().findElements(By.xpath
                        (itemsName))
                .stream()
                .forEach(webElement -> {
                    if (!webElement.getText().isEmpty()) {
                        itemCatalog.add(webElement.getText());
                    }
                });
        return itemCatalog;
    }

    public List<String> getCatalogPageMenuElements() {
        return collectElementsFromPages(CATALOG_PAGE_MENU_BAR_XPATH_PATTERN);
    }

    public List<String> getMenuItemsInCatalogElements() {
        return collectElementsFromPages(CATALOG_SUB_MENU_COMPUTER_AND_NETWORK_SECTION);
    }

    public void clickOnMenuItemCatalogPage() {
        waitForElementClickable(By.xpath(format(CATALOG_MENU_ITEM_COMPUTER_AND_NETWORK_PATTERN))).click();
    }

    public void clickOnAccessoriesMenu() {
        waitForElementVisible(By.xpath(format(ACCESSORIES_MENU_PATTERN))).click();
    }

    public List<String> getAccessoriesItemsTitle() {
        return collectElementsFromPages(ACCESSORIES_ITEMS_TITLE);
    }

    public List<String> getAccessoriesItemsDescription() {
        return collectElementsFromPages(ACCESSORIES_ITEMS_DESCRIPTION);
    }

    public Boolean checkForEmpty(List<String> itemsCatalog) {
        boolean isContains = itemsCatalog.contains("");
        return isContains;
    }

}


