package selenium.webdriver;

import org.junit.After;
import org.junit.Before;
import selenium.webdriver.icanwin.drivers.DriverEnum;
import selenium.webdriver.icanwin.page.EmailPage;
import selenium.webdriver.icanwin.page.GooglePage;
import selenium.webdriver.icanwin.page.PastebinPage;

import static selenium.webdriver.icanwin.drivers.DriverInitialization.driver;
import static selenium.webdriver.icanwin.drivers.DriverInitialization.startDriver;

public class BasePage {
    public PastebinPage pastebinPage;
    public GooglePage googlePage;
    public EmailPage emailPage;

    @Before
    public void setUp() {
        startDriver(DriverEnum.FIREFOX.getBrowser());
        driver.manage().window().maximize();
        pastebinPage = new PastebinPage(driver);
        googlePage = new GooglePage(driver);
        emailPage = new EmailPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
