package br.com.bolivar.banks.domain;

import br.com.bolivar.banks.dataBuilder.BancoDataBuilder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BancoDomainTest {

    @Test
    public void nomeIsNotNull(){
        Banco banco = new BancoDataBuilder().recebeParams("Banco teste",1).builder();
        Assertions.assertEquals(new Integer(1), banco.getHasNome());
    }

    @Test
    public void nomeIsNull(){
        Banco banco = new BancoDataBuilder().recebeParams("",1).builder();
        Assertions.assertEquals(new Integer(0), banco.getHasNome());
    }

    @Test
    public void codigoIsNotNull(){
        Banco banco = new BancoDataBuilder().recebeParams("Teste",1).builder();
        Assertions.assertEquals(new Integer(1),banco.getHasCodigo());
    }

}
