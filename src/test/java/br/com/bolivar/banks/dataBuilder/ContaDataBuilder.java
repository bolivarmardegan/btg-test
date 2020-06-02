package br.com.bolivar.banks.dataBuilder;

import br.com.bolivar.banks.domain.Banco;
import br.com.bolivar.banks.domain.Cliente;
import br.com.bolivar.banks.domain.Conta;

public class ContaDataBuilder {

    private Conta conta = new Conta();

    public ContaDataBuilder recebeParams(String agencia, String numero, Cliente cliente){
        this.conta.setAgencia(agencia);
        this.conta.setNumero(numero);
        this.conta.setCliente(cliente);
        return this;
    }

    public Conta builder(){
        return this.conta;
    }
}
