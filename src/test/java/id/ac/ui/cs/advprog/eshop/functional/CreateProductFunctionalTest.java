package id.ac.ui.cs.advprog.eshop.functional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.github.bonigarcia.seljup.SeleniumJupiter;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class CreateProductFunctionalTest {

    @LocalServerPort
    private int port;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d", testBaseUrl, port);
    }

    @Test
    void createProduct_success(ChromeDriver driver) {
        driver.get(baseUrl + "/product/create");

        WebElement productNameInput = driver.findElement(By.id("nameInput"));
        WebElement productQuantityInput = driver.findElement(By.id("quantityInput"));

        String productName = "Test Product";
        String productQuantity = "100";


        productNameInput.clear();
        productNameInput.sendKeys(productName);

        productQuantityInput.clear();
        productQuantityInput.sendKeys(productQuantity);

        // Click the submit button
        WebElement submitButton = driver.findElement(By.id("createButton"));
        submitButton.click();


        new WebDriverWait(driver, java.time.Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("/product/list"));


        boolean productFound = driver.getPageSource().contains(productName);
        assertTrue(productFound, "The new product should be visible in the product list.");

        boolean quantityFound = driver.getPageSource().contains(productQuantity);
        assertTrue(quantityFound, "The new quantity should be visible in the product list.");
    }

    @Test
    void createProduct_empty(ChromeDriver driver) {
        driver.get(baseUrl + "/product/create");

        // Click the submit button
        WebElement submitButton = driver.findElement(By.id("createButton"));
        submitButton.click();

        new WebDriverWait(driver, java.time.Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("/product/create"));
    }

    @Test
    void createProduct_notNumber(ChromeDriver driver) {
        driver.get(baseUrl + "/product/create");

        WebElement productNameInput = driver.findElement(By.id("nameInput"));
        WebElement productQuantityInput = driver.findElement(By.id("quantityInput"));

        String productName = "Test Product";
        String productQuantity = "sem4ip4";


        productNameInput.clear();
        productNameInput.sendKeys(productName);

        productQuantityInput.clear();
        productQuantityInput.sendKeys(productQuantity);

        // Click the submit button
        WebElement submitButton = driver.findElement(By.id("createButton"));
        submitButton.click();

        new WebDriverWait(driver, java.time.Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("/product/create"));
    }
}