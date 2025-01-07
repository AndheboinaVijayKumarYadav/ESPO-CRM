package SVG;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class flipcartSearch {
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
    public void test_search(){

        driver.manage().window().maximize();
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));

        driver.get("https://www.flipkart.com/");
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("macmini");

        // clicking on svg
        WebElement searchIconSVG = driver.findElement(By.xpath("//*[local-name()='svg']"));
        // similarly we can also use xpath as //*[name()='svg']
        searchIconSVG.click();

        // getting elements containing search titles
        List<WebElement> searchTitles = driver.findElements(By.xpath("//div[contains(@data-id,'CPU')]/div/a[2]"));

        for(WebElement title : searchTitles){
            System.out.println(title.getText());
        }


    }

    @AfterTest
    public void tearDown(){
        // driver.quit();
    }
}
