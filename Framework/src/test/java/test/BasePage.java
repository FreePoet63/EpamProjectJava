package test;

import driver.DriverStart;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import page.EmailPage;
import page.GooglePage;

public class BasePage {
    public WebDriver driver;
    public GooglePage googlePage;
    public EmailPage emailPage;

    @Before
    public void setUp() {
       driver = DriverStart.getDriver();
    }

    @After
    public void tearDown() {
       DriverStart.closeDriver();
    }
}
