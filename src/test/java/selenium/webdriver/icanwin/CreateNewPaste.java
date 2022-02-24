package selenium.webdriver.icanwin;

import org.junit.Assert;
import org.junit.Test;
import selenium.webdriver.BasePage;
import selenium.webdriver.icanwin.page.PastebinPage;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static selenium.webdriver.icanwin.constants.TestData.*;
import static selenium.webdriver.icanwin.constants.UrlAddress.URL_PASTEBIN;
import static selenium.webdriver.icanwin.drivers.DriverInitialization.driver;

public class CreateNewPaste extends BasePage {
    @Test
    public void createNewPasteTest() {
        driver.get(URL_PASTEBIN);
        pastebinPage
                .getCodePaste(CODE_CREATE_PASTE)
                .getExpirationTime(2)
                .getTextTitlePaste(TITLE_PASTE)
                .getClickCreatePaste();
    }

    @Test
    public void createNewPasteWithParams() {
        driver.get(URL_PASTEBIN);
        PastebinPage newPastebinPage = pastebinPage
                .getCodePaste(CODE_CREATE_PASTE_BUSH)
                .getValueSyntax(0)
                .getExpirationTime(2)
                .getTextTitlePaste(NEW_TITLE_PASTE)
                .getClickCreatePaste();
        Assert.assertEquals(CODE_CREATE_PASTE_BUSH, newPastebinPage.getTextBushCode());
        Assert.assertTrue(driver.getTitle().contains(NEW_TITLE_PASTE));
        assertThat(newPastebinPage.getValueListBush(),
                hasItems(
                "rgb(194, 12, 185)",
                "rgb(102, 0, 51)",
                "rgb(255, 0, 0)"));
    }
}
