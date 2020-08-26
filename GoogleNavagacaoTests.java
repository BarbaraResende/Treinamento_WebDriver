package Tests;

import Bases.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GoogleNavagacaoTests extends BaseTests {

    @Test
    public void validaSiteGoogle(){

        carregaPaginaInicialGoogle();
        assertEquals(("Base2"), true);

    }
}
