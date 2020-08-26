package Base2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Navegacao {

    WebDriver driver;
    String url;

    @Before
    public void Iniciar() {

        url = ("https://www.google.com/");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Bárbara\\Treinamento\\Treinamento_WebDriver\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }
    @After
    public void Finalizar(){
        driver.quit();
    }

    @Test
    public void SiteGoogle(){

        driver.get(url);
        driver.findElement(By.name("q")).sendKeys(Keys.chord("src/test/Tests/Base2"));
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Test
    public void ValidaSitegoogle(){

        driver.get(url);
        String titulo = driver.getTitle();
        assertEquals(titulo, "Google");
    }

    @Test
    public void validaLink(){


        driver.get(url);
        assertEquals(url, driver.findElement(By.linkText("/?hl=en&amp;sa=X&amp;ved=0ahUKEwj7-cHXzYnrAhX6GrkGHa98A9QQPAgH\" rel=\"canonical")));

    }

    }
