package br.com.bolivar.banks.database;

import br.com.bolivar.banks.domain.Conta;
import java.util.ArrayList;
import java.util.List;

public class ContaDao {

    private static List<Conta> contas = new ArrayList<Conta>();

    public boolean cadastrar(Conta conta){
        return  contas.add(conta);
    }

    public Conta findBy(String numero){
        return contas.stream().filter(conta ->conta.getNumero().equals(numero)).findFirst().orElse(null);
    }

}
