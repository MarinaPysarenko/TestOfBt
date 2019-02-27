
import org.junit.*;
import org.junit.rules.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.xml.xpath.XPath;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.fail;
import static org.apache.xalan.xsltc.compiler.util.Type.Int;
import static org.junit.Assert.assertEquals;

public class AddToCart {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "http://bt.mirs.com.ua";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testOfCart() throws Exception {
        driver.get(baseUrl);

        driver.findElement(By.xpath("(//a[contains(@href,'/direction/bytovaya_tehnika')])")).click();
        driver.findElement(By.xpath("(//a[contains(@href,'/section/krupnaya-bytovaya-tehnika')])")).click();
        driver.findElement(By.xpath("(//a[contains(@href,'/catalog/morozilnye-kamery-i-lari')])")).click();

        WebElement element = driver.findElement(By.xpath("(//*[@id=\"card-container\"]/div[3]/div[2]/button)"));
        Thread.sleep(5000);

        Actions actions = new Actions(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(5000);
        actions.moveToElement(element).click().perform();

        driver.findElement(By.xpath("(//*[@id=\"card-container\"]/div[6]/div[2]/button)")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("(//*[@id=\"root\"]/div/header/div[1]/div/div[3]/div/div[2]/div/div)")).click();
        Thread.sleep(5000);

       String countItem = driver.findElement(By.xpath("(//*[@id=\"count-input-328\"])")).getAttribute("value");
        Thread.sleep(5000);
        int numberCountItem = Integer.parseInt(countItem);

        //Проверка количества товара в корзине
        assertEquals("The quantity of the item is changed", 2, numberCountItem);













    }

/*
    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }*/
}
