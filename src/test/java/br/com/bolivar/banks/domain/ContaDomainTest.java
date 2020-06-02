package br.com.bolivar.banks.domain;

import br.com.bolivar.banks.dataBuilder.ClienteDataBuilder;
import br.com.bolivar.banks.dataBuilder.ContaDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ContaDomainTest {

    private Conta contaSemAgencia;
    private Conta contaSemNumero;

    @Before
    public void init(){
        Cliente joelBrinba = new ClienteDataBuilder().recebeParametros("Joél Brinba",50).builder();
        Cliente pauloPaulada = new ClienteDataBuilder().recebeParametros("Paulo Paulada",30).builder();
        this.contaSemAgencia = new ContaDataBuilder().recebeParams("3243","668899-P",pauloPaulada).builder();
        this.contaSemNumero = new ContaDataBuilder().recebeParams("2233","123098-X",joelBrinba).builder();
    }

    @Test
    public void contaNaoDeveTerAgenciaNull(){
        Assertions.assertNotNull(this.contaSemAgencia.getAgencia());
    }

    @Test
    public void contaNaoDeveTerNumeroNull(){
        Assertions.assertNotNull(this.contaSemNumero.getNumero());
    }
}
