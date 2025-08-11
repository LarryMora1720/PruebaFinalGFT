package org.example;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Unit test for simple App.
 */
public class AppTest 

{
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }




    @org.junit.Test
    public void openDemoQA() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("firstName")).sendKeys("Leo");
        driver.findElement(By.id("lastName")).sendKeys("Isaza");
        driver.findElement(By.id("userEmail")).sendKeys("leonardo@udea.edu.co");
        driver.findElement(By.xpath("//label[text()='Female']")).click();
        driver.findElement(By.id("userNumber")).sendKeys("1234567890");
        driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\lymd\\OneDrive - GFT Technologies SE\\Pictures\\Saved Pictures\\Captura de pantalla 2024-12-17 095849.png");
        driver.findElement(By.id("submit")).submit();
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Thanks for submitting the form')]")).isDisplayed());

// Crear una espera explícita de hasta 10 segundos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

// Esperar hasta que el elemento sea visible
        WebElement boton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("closeLargeModal"))
        );
    }

    @Test
    public void openGoogle() throws InterruptedException {
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("GFT");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(),'GFT Technologies')]")).isDisplayed());

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
