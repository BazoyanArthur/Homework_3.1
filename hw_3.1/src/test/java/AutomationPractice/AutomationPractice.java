package AutomationPractice;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

class AutomationPractice {
    private static WebDriver chromeDriver;


    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
    }

    @BeforeEach
    public void init(){

    }

    @AfterAll
    public static void tearDown() {
        chromeDriver.quit();
    }


    @Test
    public void interactCheckBox() {
        chromeDriver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
        WebElement checkBoxVendorSelected = chromeDriver.findElement(By.id("layered_category_4"));
        checkBoxVendorSelected.click();
    }

    @Test
    public void interactGetTextFromBox(){
        chromeDriver.get("http://automationpractice.com/");
        WebElement element = chromeDriver.findElement(By.className("blockbestsellers"));
        System.out.println(element.getText());
    }

    @Test
    public void interactSearch(){
        chromeDriver.get("http://automationpractice.com/");
        WebElement element = chromeDriver.findElement(By.cssSelector("input#search_query_top"));
        element.sendKeys("RIP AND TEAR FOR THE TEDDY BEAR" + Keys.ENTER);
    }

    @Test
    public void interactDropdown(){
        chromeDriver.get("http://automationpractice.com/");
        WebElement element = chromeDriver.findElement(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']"));
        List<WebElement> dropdownItems =  element.findElements(By.tagName("li"));
        dropdownItems.get(0).click();
    }

}