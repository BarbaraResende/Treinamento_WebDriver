package Base2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class DropDownList {

    WebDriver driver;
    String url;

    @Before
    public void iniciar() {

        url = ("http://the-internet.herokuapp.com/dropdown");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Bárbara\\Treinamento\\Treinamento_WebDriver\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void finalizar() {
        driver.quit();
    }

    @Test
    public void CampoBusca() {

        driver.get(url);
        WebElement comboboxElement = driver.findElement(By.id("dropdown"));
        Select combobox = new Select(comboboxElement);
        combobox.selectByValue("1");
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        assertEquals(combobox, driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[2]")).getText());

    }

}
