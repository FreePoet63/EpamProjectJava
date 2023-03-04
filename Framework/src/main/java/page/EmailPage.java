package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailPage {
    private WebDriver driver;

    public EmailPage(WebDriver driver) {
        this.driver = driver;
    }

    private By setGeneration = By.xpath("//div[@class=\"txtlien\"]");
    private By setCopy = By.xpath("//span[text()=\"Скопировать в буфер обмена\"]");
    private By setFindEmail = By.xpath("//span[text()=\"Проверить почту\"]");
    private By setCostEmail = By.xpath("//h3");
    private By setMailFrame = By.xpath("//iframe[@id=\"ifmail\"]");

    public EmailPage getGenerationEmail(int index) {
        driver.findElements(setGeneration).get(index).click();
        return this;
    }

    public EmailPage getCopyEmail() {
        driver.findElement(setCopy).click();
        return this;
    }

    public EmailPage getEmailCost() {
        driver.findElement(setFindEmail).click();
        return this;
    }

    public String getCostEmail() {
        driver.switchTo().frame(driver.findElement(setMailFrame));
        return driver.findElements(setCostEmail).get(1).getText();
    }
}
