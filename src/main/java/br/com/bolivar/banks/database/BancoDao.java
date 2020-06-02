package br.com.bolivar.banks.database;

import br.com.bolivar.banks.domain.Banco;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BancoDao {

    private static List<Banco> bancos = new ArrayList<Banco>();

    public boolean cadastrar(Banco banco){
        return  bancos.add(banco);
    }

    public Banco atualizarBy(Integer codigo){
        Banco banco = this.findBy(codigo);
        if(banco != null)
            return bancos.set(bancos.indexOf(banco), banco);
        return banco;
    }

    public Banco findBy(Integer codigo){
        return bancos.stream().filter(banco ->banco.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

    public boolean naoExiste(Banco banco){
        return !bancos.contains(banco);
    }

    public boolean excluirBy(Integer codigo){
        Banco banco = this.findBy(codigo);
        if(banco != null)
            return bancos.remove(banco);
        return false;
    }
}
