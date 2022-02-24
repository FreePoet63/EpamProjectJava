package selenium.webdriver.icanwin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class PastebinPage {
    private WebDriver driver;

    public PastebinPage(WebDriver driver) {
        this.driver = driver;
    }

    private By setNewPaste = By.id("postform-text");
    private By setExpiration = By.xpath("//span[@data-select2-id=\"3\"]");
    private By setSyntax = By.xpath("//span[@data-select2-id=\"1\"]");
    private By setMenuSyntax = By.xpath("//ul[@class=\"select2-results__options select2-results__options--nested\"]//li");
    private By setSearchResultExpiration = By.xpath("//ul[@id=\"select2-postform-expiration-results\"]//li");
    private By setTitlePaste = By.id("postform-name");
    private By setButton = By.xpath("//button[text()=\"Create New Paste\"]");
    private By setTextBush = By.xpath("//ol[@class=\"bash\"]");
    private By setListBush = By.xpath("//div[@class=\"de1\"]//span");

    public PastebinPage getCodePaste(String text) {
        driver.findElement(setNewPaste).sendKeys(text);
        return this;
    }

    public PastebinPage getValueSyntax(int value) {
        getElementWait(setSyntax, 20);
        driver.findElements(setMenuSyntax).get(value).click();
        return this;
    }

    public PastebinPage getExpirationTime(int index) {
        getElementWait(setExpiration, 20);
        driver.findElements(setSearchResultExpiration).get(index).click();
        return this;
    }

    public PastebinPage getTextTitlePaste(String text) {
        driver.findElement(setTitlePaste).sendKeys(text);
        return this;
    }

    public PastebinPage getClickCreatePaste() {
        getElementWait(setButton, 10);
        return this;
    }

    public String getTextBushCode() {
        getVisibilityElement(90, setTextBush);
        return driver.findElement(setTextBush).getText();
    }

    private void getElementWait(By by, int i) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by))).click();
    }

    private void getVisibilityElement(int val, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(val));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public List<String> getValueListBush() {
        getVisibilityElement(80, setListBush);
        List<WebElement> list = driver.findElements(setListBush);
        return list.stream().map(value -> value.getCssValue("color")).collect(Collectors.toList());
    }
}
