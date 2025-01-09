package ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class CapitalText {

    WebDriver driver;

    @Test
    public void testCapitalText(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/practice.html");
        WebElement inputUserName = driver.findElement(By.name("firstname"));

        Actions action = new Actions(driver);
        action.keyDown(Keys.SHIFT).sendKeys(inputUserName,"vijay kumar").keyUp(Keys.SHIFT).build().perform();


    }

    @Test
    public void testSpiceJet(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.spicejet.com/");
        WebElement inputText = driver.findElement(By.xpath("//div[@data-testid=\"to-testID-origin\"]/div/div/input"));

        Actions action = new Actions(driver);
        // action.moveToElement(inputText).click().perform();
        action.moveToElement(inputText).click().sendKeys("BLR").perform();
    }

    //span[@data-cy='closeModal']

    @Test
    public void testMakeMyTripPopUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));
        driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();

        Actions action = new Actions(driver);
        // action.moveToElement(inputText).click().perform();

    }
}
