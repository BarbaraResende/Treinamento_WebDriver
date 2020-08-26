package Bases;

import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;


public class BaseTests {

    private static WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;

    @BeforeClass
    public void inicializar() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Bárbara\\Treinamento\\Treinamento_WebDriver\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
    }

    @BeforeMethod
     public void carregapaginaInicialCrowdTest(){
                driver.get("http://blackmirror.crowdtest.me.s3-website-us-east-1.amazonaws.com/auth");
                loginPage = new LoginPage(driver);
            }

    @AfterClass
    public void finalizar() {
        driver.quit();
    }
}