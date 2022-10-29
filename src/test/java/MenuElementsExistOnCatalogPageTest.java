import Data.CatalogMenuItems;
import com.it_academy.fraemwork.DriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_object.CatalogPage;
import page_object.HomePage;

import static org.testng.AssertJUnit.assertEquals;

public class MenuElementsExistOnCatalogPageTest {

    private HomePage homePage;
    private CatalogPage catalogPage;

    @BeforeClass
    public void webDriverInit() {
        homePage = new HomePage();
        catalogPage = new CatalogPage();
        DriverManager.setDriver();
    }

    @Test
    public void CatalogElementsExistingTest() {
        DriverManager.getDriver().get("https://www.onliner.by/");
        homePage.clickOnCatalogLink();
        assertEquals(catalogPage.getCatalogPageMenuElements(), CatalogMenuItems.menuItemsTemplate());
    }


    @AfterClass
    public void webDriverClose() {
        DriverManager.closeDriver();
    }
}