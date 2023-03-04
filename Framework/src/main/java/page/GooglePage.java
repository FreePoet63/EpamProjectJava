package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static page.UrlPage.URL_CLOUD_GOOGLE;

public class GooglePage {
    private WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    private By setSearch = By.xpath("//input[@name=\"q\"]");
    private By setValueCalc = By.xpath("//b[text()=\"Google Cloud Pricing Calculator\"]");
    private By setFieldInstances = By.xpath("//input[@ng-model=\"listingCtrl.computeServer.quantity\"]");
    private By setSeries = By.xpath("//md-select[@ng-model=\"listingCtrl.computeServer.series\"]");
    private By setMenuSeries = By.xpath("//md-option[@ng-repeat=\"item in listingCtrl.computeServerGenerationOptions[listingCtrl.computeServer.family]\"]");
    private By setMenuMachineType = By.xpath("//md-option[@ng-repeat=\"instance in typeInfo\"]");
    private By iFrame = By.xpath("//iframe[contains(@name, \"goog\")]");
    private By newFrame = By.xpath("//iframe[@id=\"myFrame\"]");
    private By setMachineType = By.xpath("//md-select[@ng-model=\"listingCtrl.computeServer.instance\"]");
    private By setGpu = By.xpath("//div[@class=\"md-container md-ink-ripple\"]");
    private By setGpuTypeNumber = By.xpath("//div[@class=\"layout-row flex-gt-sm-90 flex-80\"]//md-select");
    private By setMenuElement = By.xpath("//div[@class=\"md-select-menu-container md-active md-clickable\"]//md-option[@class=\"ng-scope md-ink-ripple\"]");
    private By setLocalSsd = By.xpath("//md-select[@ng-model=\"listingCtrl.computeServer.ssd\"]");
    private By setLocation = By.xpath("//md-select[@ng-model=\"listingCtrl.computeServer.location\"]");
    private By setMenuCity = By.xpath("//div[contains(@class, \"cpc-region-select md-active md-clickable\")]//md-option[@class=\"ng-scope md-ink-ripple\"]");
    private By setCommited = By.xpath("//md-select[@ng-model=\"listingCtrl.computeServer.cud\"]");
    private By setMenuCommited = By.xpath("//div[@class=\"md-select-menu-container md-active md-clickable\"]//md-option[@class=\"md-ink-ripple\"]");
    private By setButton = By.xpath("//button[contains(@class, \"cpc-button md-button md-ink-ripple\")]");
    private By setMunuResult = By.xpath("//md-list-item");
    private By setEmail = By.xpath("//button[@id=\"email_quote\"]");
    private By setEmailField = By.xpath("//input[@ng-model=\"emailQuote.user.email\"]");

    public GooglePage getFrame(By by) {
        WebElement frame = driver.findElement(by);
        driver.switchTo().frame(frame);
        return this;
    }

    public GooglePage getSearch(String string) {
        driver.findElement(setSearch).sendKeys(string);
        driver.findElement(setSearch).sendKeys(Keys.ENTER);
        getElementWaitVisibility(setValueCalc, 30);
        driver.findElement(setValueCalc).click();
        return this;
    }

    public GooglePage getWriteForm(String value) {
        getWaitFrame(iFrame, 50);
        getFrame(newFrame);
        getElementWaitVisibility(setFieldInstances, 70);
        driver.findElement(setFieldInstances).sendKeys(value);
        return this;
    }

    public GooglePage getValueSeries(int index) {
        getElementWaitVisibility(setSeries, 20);
        driver.findElement(setSeries).click();
        driver.findElements(setMenuSeries).get(index).click();
        return this;
    }

    public GooglePage getMenuMachineType(int value) {
        getElementWaitVisibility(setSeries, 20);
        driver.findElement(setMachineType).click();
        driver.findElements(setMenuMachineType).get(value).click();
        return this;
    }

    public GooglePage addGpus(int indexElement, int type, int numberGpu) {
        List<WebElement> gpu = driver.findElements(setGpu);
        getElementWaitClick(gpu.get(indexElement), 30);
        gpu.get(indexElement).click();
        driver.findElements(setGpuTypeNumber).get(1).click();
        driver.findElements(setMenuElement).get(type).click();
        driver.findElements(setGpuTypeNumber).get(2).click();
        driver.findElements(setMenuElement).get(numberGpu).click();
        return this;
    }

    public GooglePage addLocalSsd(int discSSD) {
        driver.findElement(setLocalSsd).click();
        driver.findElements(setMenuElement).get(discSSD).click();
        return this;
    }

    public GooglePage addLocation(int city) {
        driver.findElement(setLocation).click();
        driver.findElements(setMenuCity).get(city).click();
        return this;
    }

    public GooglePage addCommited(int commitUsage) {
        driver.findElement(setCommited).click();
        driver.findElements(setMenuCommited).get(commitUsage).click();
        return this;
    }

    public GooglePage clickButton(int button) {
        driver.findElements(setButton).get(button).click();
        return this;
    }

    public GooglePage sendEmail() {
        getElementWaitClick(driver.findElement(setEmail), 45);
        driver.findElement(setEmail).click();
        return this;
    }

    public GooglePage addEmail() {
        getElementWaitClick(driver.findElement(setEmailField), 40);
        driver.findElement(setEmailField).sendKeys(Keys.CONTROL + "v");
        return this;
    }

    public List<String> resultDataCalc() {
        List<WebElement> list = driver.findElements(setMunuResult);
        return list.stream().map(webElement -> webElement.getText()).collect(Collectors.toList());
    }

    public GooglePage openFrame() {
        getFrame(iFrame);
        getFrame(newFrame);
        return this;
    }

    public GooglePage closeFrame() {
        driver.switchTo().defaultContent();
        return this;
    }

    private void getElementWaitClick(WebElement element, int sec) {
        new WebDriverWait(driver, Duration.ofSeconds(sec))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    private void getElementWaitVisibility(By by, int i) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebDriver getWaitFrame(By by, int sec) {
        return new WebDriverWait(driver, Duration.ofSeconds(sec))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }

    public GooglePage openGooglePage() {
        driver.navigate().to(URL_CLOUD_GOOGLE);
        return this;
    }
}
