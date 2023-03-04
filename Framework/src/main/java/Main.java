import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://cloud.google.com/");
        driver.findElement(By.xpath("/html/body/section/devsite-header/div/div[1]" +
                "/div/div/div[2]/div[1]/cloudx-tabs-nav/nav/tab[9]/a")).click();

        CompletableFuture<Void> textFuture = CompletableFuture.runAsync(() -> {
            WebElement text = null;
            while (text == null) {
                text = driver.findElement(By.id("talk-to-a-google-cloud-sales-specialist"));
            }
            text.click();
        });
        textFuture.join();
        driver.quit();
    }
}
