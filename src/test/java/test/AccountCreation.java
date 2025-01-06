package test;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.List;

import java.time.Duration;

public class AccountCreation extends BaseTest {


    @Test
    public void test_account_creation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        WebElement loginButton = driver.findElement(By.id("btn-login"));
        loginButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement accountElement = driver.findElement(By.xpath("//span[text()='Accounts']"));
        accountElement.click();


        WebElement createAccountButton = driver.findElement(By.xpath("//span[normalize-space()='Create Account']"));
        createAccountButton.click();

        List<WebElement> inputElementOfForm = driver.findElements(By.xpath("//input[contains(@class, 'main-element')]"));
        inputElementOfForm.get(0).sendKeys("Vijay");

        inputElementOfForm.get(1).sendKeys("vijay.com");

        WebElement emailElement = driver.findElement(By.xpath("//input[contains(@class,'email-address')]"));
        emailElement.sendKeys("vijay123@gmail.com");


        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//div[text()='Office']"))).click().perform();
        action.moveToElement(driver.findElement(By.xpath("(//div[@class=\"option\"])[3]"))).click().perform();


        WebElement saveButton = driver.findElement(By.xpath("//button[text()='Save']"));
        saveButton.click();
    }

}
