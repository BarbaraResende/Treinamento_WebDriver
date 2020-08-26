package Base2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class LocalizandoElementos {

    WebDriver driver;
    String urlgoogle;
    String urlFilling;
    String urlZoro;

    @Before
    public void iniciar() {

        urlgoogle = ("https://google.com");
        urlFilling = ("https://ultimateqa.com/filling-out-forms/");
        urlZoro = ("https://www.zoho.com/pt-br/");
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

        driver.get(urlgoogle);
        driver.findElement(By.name("q")).sendKeys(Keys.chord("src/test/Tests/Base2"));
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        assertEquals(urlgoogle, driver.findElement(By.id("cnt")).getText());
    }

    @Test
    public void SubmeterFormulario() {

        driver.get(urlFilling);
        driver.findElement(By.id("et_pb_contact_name_0")).sendKeys(Keys.chord("Maria Joaquina"));
        driver.findElement(By.id("et_pb_contact_message_0")).sendKeys(Keys.chord("Realizando Teste de WebDriver com Java"));
        driver.findElement(By.name("et_builder_submit_button")).click();
        assertTrue(true, driver.findElement(By.cssSelector("p.et_pb_contact_error_text")).getText());
    }

    @Test
    public void ValidaCampoobrigatorio() {

        driver.get(urlFilling);
        driver.findElement(By.id("et_pb_contact_name_0")).sendKeys(Keys.chord("João Augusto"));
        driver.findElement(By.name("et_builder_submit_button")).click();
        assertTrue(true, driver.findElement(By.cssSelector("div.et-pb-contact-message")).getText());
    }

    @Test
    public void NavegacaoNoZoro() {

        driver.get(urlZoro);
        // Valida tela inical da página
        assertTrue(true, driver.findElement(By.className("zh-user-account")).getText());
        //Valida menu da tela inicial
        assertTrue(true, driver.findElement(By.id("block-system-main")).getText());
        //Clica em incrição gratuita
        driver.findElement(By.cssSelector("a.zh-signup")).click();
        //preenche email e senha e clica em submit
        driver.findElement(By.id("emailfield")).sendKeys(Keys.chord("teste@gmail.com"));
        driver.findElement(By.id("password")).sendKeys(Keys.chord(""));
        driver.findElement(By.id("signupbtn")).click();
        //valida mensagem de erro
        assertTrue(true, driver.findElement(By.cssSelector("span.emailfield-error")).getText());
        //Clica na imagem Zoro pra retornar para tela inicial
        driver.findElement(By.cssSelector("a.logo")).click();
        //clica no item disponivel da pagina inicial
        By.xpath("//input[@class='promotion-app']").findElement(driver).click();
    }


}
