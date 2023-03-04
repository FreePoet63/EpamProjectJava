package test;

import driver.DriverStart;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import util.MethodsUtils;

import javax.xml.stream.events.StartDocument;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static page.UrlPage.URL_EMAIL;
import static service.ResultTest.resultTest;

public class TestCalculation extends BasePage{
    @Test
    public void checkCostOnEmail() {
        googlePage
                .openGooglePage()
                .getSearch("Google Cloud Platform Pricing Calculator")
                .getWriteForm("4")
                .getValueSeries(0)
                .getMenuMachineType(3)
                .addGpus(1,3,1)
                .addLocalSsd(2)
                .addLocation(9)
                .addCommited(1)
                .clickButton(0);
        assertThat(googlePage.resultDataCalc(), hasItem(containsString(resultTest())));
        googlePage
                .sendEmail()
                .closeFrame();
        new MethodsUtils(driver).getOpenTabs(URL_EMAIL);
        ArrayList<String> listTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listTabs.get(0));
        emailPage
                .getGenerationEmail(0)
                .getCopyEmail();
        driver.switchTo().window(listTabs.get(1));
        googlePage
                .openFrame()
                .addEmail()
                .clickButton(6);
        driver.switchTo().window(listTabs.get(0));
        emailPage.getEmailCost();
        assertEquals(resultTest(), emailPage.getCostEmail());
    }
}
