package Base2;


import org.junit.Assert;
import org.junit.Test;

public class DesafioJUnit {

    @Test
    public void AssercaoTrue(){

        boolean valida = true;
        Assert.assertTrue("Nome Válido", valida);
            }

    @Test
    public void AssercaoFalse(){


        boolean valida = false;
        Assert.assertFalse("Valor inválido", valida);
    }

    @Test
    public void AssercaoComparar(){

        int num1 = 5;
        int num2 = 2;

        Assert.assertEquals(10, num1 * num2);

    }

}
