package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By email = By.id("login");
    private By password = By.id("password");
    private By botaoEntrar = By.xpath("//button[@class='btn btn-crowdtest btn-block']");

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    public void preencherEmail(String texto) {
        driver.findElement(email).sendKeys(texto);
    }
    public void preencherPassword(String texto) {
        driver.findElement(password).sendKeys(texto);
    }
    public void clicarEntrar() {
        driver.findElement(botaoEntrar).click();
    }

}
