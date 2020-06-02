package br.com.bolivar.banks.business;

import br.com.bolivar.banks.dataBuilder.ClienteDataBuilder;
import br.com.bolivar.banks.domain.Cliente;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ClienteBusinessTest {

    private ClienteBusiness clienteBusiness;
    private Cliente chico;

    @Before
    public void initTest(){
        this.clienteBusiness = new ClienteBusiness();
        this.chico = new ClienteDataBuilder().recebeParametros("Francisco Lulu", 24).builder();
    }

    @Test
    public void naoDeveCadastrarClienteNull(){
        this.chico = null;
        boolean cadastrou = this.clienteBusiness.cadastrar(null);
        assertFalse(cadastrou);
    }

}
