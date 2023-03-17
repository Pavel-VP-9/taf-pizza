import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TerrapizzaTest {

    WebDriver driver;

    @BeforeEach
    public void warmUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(TerrapizzaPage.URL);

    }

    @Test

    public void testPizzaSelection() throws InterruptedException {

        WebElement BtnCook = driver.findElement(By.xpath(TerrapizzaPage.BTN_COOK));
        BtnCook.click();
        Thread.sleep(10000);
        // нажимаем кнопку Пицца
        WebElement BtnElementPizza = driver.findElement(By.linkText(TerrapizzaPage.CATEGORY_MENU_TEXT_PRODUCT));
        BtnElementPizza.click();
        // WebElement BtnElementPizza = driver.findElement(By.xpath(TerrapizzaPage.BTN_PIZZA));
        Thread.sleep(5000);
        //  Util.waitFor(5);
        // Util.waitForPresenceElementByXPath(driver, " ", )
      //  BtnElementPizza.click();
       // Thread.sleep(5000);
        // в каталоге Пицца находим название "Пицца Маргарита" и убеждаемся, что это она
        WebElement labelNamePizzaM = driver.findElement(By.xpath(TerrapizzaPage.LABEL_PIZZA_NAME));
        Assertions.assertEquals("Пицца Маргарита", labelNamePizzaM.getText());
        // помещаем заказ в корзину
        WebElement BtnAddCard = driver.findElement(By.xpath(TerrapizzaPage.BTN_ADD_TO_CARD));
        //  Thread.sleep(15000);
        BtnAddCard.click();
        //входим в корзину, нажимая кнопку
        WebElement BtnInputCard = driver.findElement(By.xpath(TerrapizzaPage.BTN_INPUT_TO_CARD));
        Thread.sleep(10000);
        BtnInputCard.click();
        // проверяем заказ в корзине по названию пиццы
        WebElement labelNamePizzaInOrder = driver.findElement(By.xpath(TerrapizzaPage.LABEL_PIZZA_NAME_IN_ORDER));
        Assertions.assertEquals("Пицца Маргарита Классическая 32 см", labelNamePizzaInOrder.getText());

        driver.quit();


    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


}
