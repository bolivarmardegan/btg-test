package br.com.bolivar.banks.dataBuilder;

import br.com.bolivar.banks.domain.Cliente;
import br.com.bolivar.banks.domain.Conta;

public class ClienteDataBuilder {

    private Cliente cliente = new Cliente();

    public ClienteDataBuilder recebeParametros(String nome,Integer idade){
        this.cliente.setNome(nome);
        this.cliente.setIdade(idade);
        return this;
    }

    public Cliente builder(){
        return this.cliente;
    }
}
