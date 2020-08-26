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

public class CrowdTest {

    WebDriver driver;
    String url;

    @Before
    public void iniciar() {

        url = ("http://blackmirror.crowdtest.me.s3-website-us-east-1.amazonaws.com/auth");
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
        public void AcessandoCasosDeTeste() {

        //Acessa a página WEB
        driver.get(url);
        //Preenche dados do Login e Senha e clica em Entrar.
        driver.findElement(By.id("login")).sendKeys(Keys.chord("barbara.resende90@outlook.com"));
        driver.findElement(By.id("password")).sendKeys(Keys.chord("qaresende11"));
        driver.findElement(By.xpath("//button[@class='btn btn-crowdtest btn-block']")).click();

        //Valida página que abriu.
        String boasvindas = driver.findElement(By.xpath("/html/body/app-root/div[1]/app-landing/div/div[2]/div/span")).getText();
        assertEquals("Bem-vindo ao Crowdtest! O que deseja fazer hoje?", boasvindas);
        //Ao abrir a nova página, clica em Gerenciar
        driver.findElement(By.xpath("//button[@class='btn btn-crowdtest mr-1']")).click();

        //Clica em projetos.
        driver.findElement(By.xpath("//div[@class='bottom-line']")).click();
         //Seleciona projeto existente.

        driver.findElement(By.xpath("/html/body/app-root/div[1]/app-projects/div/div/app-projects-list/div[4]/div[2]/div/mat-table/mat-row")).click();
        //Clica na aba Casos de Teste.
        driver.findElement(By.xpath("/html/body/app-root/div[1]/app-projects/div/div/app-project-detail/div[3]/mat-tab-group/mat-tab-header/div[2]/div/div/div[3]")).click();
        //Clica no casos de teste retornado e valida dados

        driver.findElement(By.xpath("//mat-row[@class='mat-row ng-star-inserted']")).click();

        String titulo = driver.findElement(By.cssSelector("p._ngcontent-mkj-c41")).getText();

        //String titulo = driver.findElement(By.xpath("/html/body/app-root/div[1]/app-test-cases/div/div/app-test-case-detail/div[2]/div[2]/div/div[2]/div/p")).getText();
        assertEquals(titulo,"SiteCrowdTest" );

        String descricao = driver.findElement(By.xpath("//div[@class='col col-title']")).getText();
        assertEquals(descricao ,"Realizando teste de navegação no site CrowdTest para treinamento de automação de teste com Selenium WebDriver.");

        String requisito = driver.findElement(By.xpath("/html/body/app-root/div[1]/app-test-cases/div/div/app-test-case-detail/div[2]/div[2]/div/div[8]/div/p")).getText();
        assertEquals(requisito ,"Existir um projeto cadastrado com um caso de teste incluído.");

        String resultado = driver.findElement(By.xpath("//div[@class='col col-title']")).getText();
        assertEquals(resultado, "Caso de Teste SiteCrowdTest existente.");
    }

}
