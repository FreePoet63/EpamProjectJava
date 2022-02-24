package selenium.webdriver.hurtmeplenty;

import org.junit.Test;
import org.openqa.selenium.WindowType;
import selenium.webdriver.BasePage;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static selenium.webdriver.icanwin.constants.TestData.*;
import static selenium.webdriver.icanwin.constants.UrlAddress.URL_CLOUD_GOOGLE;
import static selenium.webdriver.icanwin.constants.UrlAddress.URL_EMAIL;
import static selenium.webdriver.icanwin.drivers.DriverInitialization.driver;

public class GoogleCalculatorTest extends BasePage {
    @Test
    public void testGoogleCloudPlatformPricingCalculator() {
        driver.get(URL_CLOUD_GOOGLE);
        googlePage
                .getSearch("Google Cloud Platform Pricing Calculator")
                .getWriteForm("4")
                .getValueSeries(0)
                .getMenuMachineType(3)
                .addGpus(1,3,1)
                .addLocalSsd(2)
                .addLocation(9)
                .addCommited(1)
                .clickButton(0);
        assertThat(googlePage.resultDataCalc(), hasItems(
                containsString(VM_CLASS),
                containsString(REGION),
                containsString(INSTANCE_TYPE),
                containsString(LOCAL_SSD),
                containsString(COMMITMENT_TERM),
                containsString(ESTIMATED_COST_ONE_MONTH)));
    }

    @Test
    public void checkCostOnEmail() {
        driver.get(URL_CLOUD_GOOGLE);
        String mainTab = driver.getWindowHandle();
        googlePage
                .getSearch("Google Cloud Platform Pricing Calculator")
                .getWriteForm("4")
                .getValueSeries(0)
                .getMenuMachineType(3)
                .addGpus(1,3,1)
                .addLocalSsd(2)
                .addLocation(9)
                .addCommited(1)
                .clickButton(0);
        assertThat(googlePage.resultDataCalc(), hasItem(containsString(COST)));
        googlePage
                .sendEmail()
                         .closeFrame();
        driver.switchTo().newWindow(WindowType.TAB).get(URL_EMAIL);
        String newTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        emailPage
                .getGenerationEmail(0)
                         .getCopyEmail();
        driver.switchTo().window(mainTab);
        googlePage
                .openFrame()
                         .addEmail()
                                  .clickButton(6);
        driver.switchTo().window(newTab);
        emailPage.getEmailCost();
        assertEquals(COST, emailPage.getCostEmail());
    }
}