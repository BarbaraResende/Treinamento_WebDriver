package Tests;

import Bases.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CrowdTests  extends BaseTests {

    @Test
    public void AcessandoCasosDeTeste(){

        carregapaginaInicialCrowdTest();
        // Realizando login de acesso
        loginPage.preencherEmail("barbara.resende90@outlook.com");
        loginPage.preencherPassword("qaresende11");
        loginPage.clicarEntrar();

        //valida página de boas vindas
        // assertEquals(true, homePage.telaBoasvindas("Bem-vindo ao Crowdtest! O que deseja fazer hoje?"));

        //Clicar no botão gerenciar
        homePage.clicarGerenciar();
        //Clicar no botão projeto
        homePage.clicarProjeto();
        //Seleciona um projeto existente
        homePage.selecionaProjeto();
        //Clica na Aba Casos de Teste
        homePage.clicaAbaCasosDeTeste();
        //Seleciona Caso de Teste existente
        homePage.selecionaCasosTeste();

        //Valida dados retornados
        //Titulo
         assertEquals(homePage.validaTitulo(), "SiteCrowdTest");
        //Descrição
        assertEquals(homePage.validaDescricao(),"Realizando teste de navegação no site CrowdTest para treinamento de automação de teste com Selenium WebDriver." );
        //Requisito
        assertEquals(homePage.validaRequisito(),"Existir um projeto cadastrado com um caso de teste incluído.");
        //Feature
        assertEquals(homePage.validaFeature(),"Incluir_Release");
        //Tags
        assertEquals(homePage.validaTags(),"Nenhuma tag cadastrada.");
        //Resultado
        assertEquals(homePage.validaResultado(),"Caso de Teste SiteCrowdTest existente.");

    }
}
