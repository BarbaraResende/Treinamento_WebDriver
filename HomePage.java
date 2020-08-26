package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private By botaoGerenciar = By.cssSelector(".container button");
    private By botaoProjeto = By.xpath("//div[@class='bottom-line']");
    private By projeto = By.cssSelector("mat-row.ng-star-inserted ");
    private By abaCasosTeste = By.xpath("//div[text()='Casos de teste']");
    private By casosTeste = By.xpath("//mat-row[@class='mat-row ng-star-inserted']");
    private By titulo = By.xpath("//*[text()='ID# 1']/following::p[1]");
    private By descricao = By.xpath("//*[text()='ID# 1']/following::p[2]");
    private By requisito = By.xpath("//*[text()='ID# 1']/following::p[3]");
    private By feature = By.xpath("//*[text()='ID# 1']/following::p[4]");
    private By tags = By.xpath("//*[text()='Tags']/following::div[1]");
    private By resultado = By.xpath("//*[text()='ID# 1']/following::p[11]");

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    // Clicar em botões

    public void clicarGerenciar() {
        driver.findElement(botaoGerenciar).click();

    }
    public void clicarProjeto() {

        driver.findElement(botaoProjeto).click();
    }

    public void clicaAbaCasosDeTeste() {

        driver.findElement(abaCasosTeste).click();
    }

    //Seleciona Itens

    public void selecionaProjeto() {

        driver.findElement(projeto).click();
    }

    public void selecionaCasosTeste() {

        driver.findElement(casosTeste).click();
    }

    //Valida Itens
    public String validaTitulo() {

        return driver.findElement(titulo).getText();
    }
    public String validaDescricao(){

        return driver.findElement(descricao).getText();
    }
    public String validaRequisito(){

        return driver.findElement(requisito).getText();
    }
    public String validaFeature(){

        return driver.findElement(feature).getText();
    }
    public String validaTags(){

        return driver.findElement(tags).getText();
    }
    public String validaResultado(){

        return driver.findElement(resultado).getText();
    }

}




