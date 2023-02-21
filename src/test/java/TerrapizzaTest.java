import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TerrapizzaTest {

  //  WebDriver driver;
    @Test

    public void testPizzaSelection() throws InterruptedException {
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(TerrapizzaPage.URL);
        WebElement BtnCook = driver.findElement(By.xpath(TerrapizzaPage.BTN_COOK));
        BtnCook.click();
        // нажимаем кнопку Пицца
      WebElement BtnElementPizza = driver.findElement(By.xpath(TerrapizzaPage.BTN_PIZZA));
       Thread.sleep(10000);
      BtnElementPizza.click();
      // в каталоге Пицца находим название "Пицца Маргарита" и убеждаемся, что это она
      WebElement labelNamePizzaM = driver.findElement(By.xpath(TerrapizzaPage.LABEL_PIZZA_NAME));
      Assertions.assertEquals("Пицца Маргарита",labelNamePizzaM.getText());
      // помещаем заказ в корзину
      WebElement BtnAddCard = driver.findElement(By.xpath(TerrapizzaPage.BTN_ADD_TO_CARD));
        //  Thread.sleep(15000);
      BtnAddCard.click();
        //входим в корзину, нажимая кнопку
        WebElement BtnInputCard = driver.findElement(By.xpath(TerrapizzaPage.BTN_INPUT_TO_CARD));
        BtnInputCard.click();
        // проверяем заказ в корзине по названию пиццы
        WebElement labelNamePizzaInOrder = driver.findElement(By.xpath(TerrapizzaPage.LABEL_PIZZA_NAME_IN_ORDER));
        Assertions.assertEquals("Пицца Маргарита Классическая 32 см",labelNamePizzaInOrder.getText());

      driver.quit();


    }


}
