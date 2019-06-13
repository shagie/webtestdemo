package net.shagie.seleniumdemo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class WebTest {
    private static WebDriver driver;

    @BeforeClass
    public static void BrowserOpen() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void BrowserClose() {
        driver.quit();
    }

    @Test
    public void VerifyH1() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://localhost/");
        assertEquals("Hello World", driver.findElement(By.tagName("h1")).getText());
    }

    @Test
    public void VerifyTwoLinks() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://localhost/");
        assertEquals(2, driver.findElements(By.xpath("//a")).size());
    }

    @Test
    public void VerifyClickNextLink() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://localhost/");
        driver.findElement(By.partialLinkText("Next")).click();
        assertEquals("This is the next page.",
                driver.findElement(By.tagName("p")).getText().trim());
    }
}
