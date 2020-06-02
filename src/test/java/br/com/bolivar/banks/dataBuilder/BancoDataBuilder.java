package br.com.bolivar.banks.dataBuilder;

import br.com.bolivar.banks.domain.Banco;
import br.com.bolivar.banks.domain.Cliente;
import br.com.bolivar.banks.domain.Conta;

import java.util.List;

public class BancoDataBuilder {

    private Banco banco = new Banco();

    public BancoDataBuilder(){}

    public BancoDataBuilder recebeParams(String nome, Integer codigo){
        this.banco.setNome(nome);
        this.banco.setCodigo(codigo);
        return this;
    }

    public BancoDataBuilder adicionarContas(List<Conta> contas){
        this.banco.getContas().addAll(contas);
        return this;
    }

    public Banco builder(){
        return banco;
    }
}
