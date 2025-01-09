package windows;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class fileUpload {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }


    @Description("Verify File Uploaded")
    @Test
    public void test_file_upload() throws InterruptedException {

//        driver.get("https://awesomeqa.com/selenium/upload.html");
//        WebElement uploadFileInput = driver.findElement(By.id("fileToUpload"));
//
//        String dir = System.getProperty("user.dir");
//        System.out.println(dir);
//        //  /Users/promode/IdeaProjects/LearningSeleniumATB7x/src/test/java/com/thetestingacademy/ex_selenium/ex_02112024_Actions_Windows_Iframe/Hello.txt
//        uploadFileInput.sendKeys(dir+"/src/test/java/com/thetestingacademy/ex_selenium/ex_02112024_Actions_Windows_Iframe/Hello.txt");
//        driver.findElement(By.name("submit")).click();

        String URL = "https://the-internet.herokuapp.com/drag_and_drop";
        driver.get(URL);
//        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        WebElement from = driver.findElement(By.id("column-a"));
        WebElement to = driver.findElement(By.id("column-b"));

        actions.dragAndDrop(from,to).perform();


//        actions.clickAndHold(from).moveToElement(to).release(to).build().perform();



    }

    @AfterTest
    public void closeBrowser() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
