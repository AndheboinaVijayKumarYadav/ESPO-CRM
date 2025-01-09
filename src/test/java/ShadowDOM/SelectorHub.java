package ShadowDOM;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;


import java.util.List;

public class SelectorHub {
    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }

    @Description("Verify the behaviour of shadowDOM")
    @Test
    public void test_shadowDOM() throws InterruptedException{

        driver.manage().window().maximize();
        String URL = "https://selectorshub.com/xpath-practice-page/";
        driver.get(URL);
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor)driver;

        WebElement div_to_scroll = driver.findElement(By.xpath("//div[@id ='userName']"));
        js.executeScript("arguments[0].scrollIntoView(true);",div_to_scroll);

        Thread.sleep(3000);
        WebElement inputBoxUsername = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"input#kils\");");
        inputBoxUsername.sendKeys("vijayJS");

//        js.executeScript("window.scrollBy(0, 500);");
//        js.executeScript("alert('Hello Ji')");


    }

    @AfterTest
    public void tearDown(){
        // driver.quit();
    }
}
