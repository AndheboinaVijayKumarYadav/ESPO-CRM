package SVG;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class IndiaMap {
    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }

    @Description("Verify the search results")
    @Test
    public void test_search() throws InterruptedException {

        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        driver.get("https://www.amcharts.com/svg-maps/?map=india");

        // getting elements containing search titles
        List<WebElement> states = driver.findElements(By.xpath("//*[local-name()='svg']/*[local-name()='g'][7]/*[local-name()='g']/*[local-name()='g']/*[local-name()='path']"));
        for(WebElement state: states){
            System.out.println(state.getAttribute("aria-label"));
            if(state.getAttribute("aria-label").contains("Tripura")){
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true);", state);
                js.executeScript("arguments[0].click();", state); // JS click
                System.out.println("Clicked on Andhra Pradesh");
            }
        }

    }

    @AfterTest
    public void tearDown(){
        // driver.quit();
    }
}
