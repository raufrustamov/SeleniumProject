import com.it_academy.fraemwork.DriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_object.CatalogPage;
import page_object.HomePage;

import static org.testng.AssertJUnit.assertFalse;

public class AccessoriesTitleAndDescriptionExistCheckTest {

    private HomePage homePage;
    private CatalogPage catalogPage;

    @BeforeClass
    public void webDriverInit() {
        homePage = new HomePage();
        catalogPage = new CatalogPage();
        DriverManager.setDriver();
    }

    @Test
    public void CheckForExistingDescriptionTest() {
        DriverManager.getDriver().get("https://www.onliner.by/");
        homePage.clickOnCatalogLink();
        catalogPage.clickOnMenuItemCatalogPage();
        catalogPage.clickOnAccessoriesMenu();
        assertFalse(catalogPage.checkForEmpty(catalogPage.getAccessoriesItemsDescription()));
    }

    @Test
    public void CheckForExistingTitleTest() {
        DriverManager.getDriver().get("https://www.onliner.by/");
        homePage.clickOnCatalogLink();
        catalogPage.clickOnMenuItemCatalogPage();
        catalogPage.clickOnAccessoriesMenu();
        assertFalse(catalogPage.checkForEmpty(catalogPage.getAccessoriesItemsTitle()));
    }

    @AfterClass
    public void webDriverClose() {
        DriverManager.closeDriver();
    }
}
