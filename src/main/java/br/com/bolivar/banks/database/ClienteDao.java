package br.com.bolivar.banks.database;

import br.com.bolivar.banks.domain.Banco;
import br.com.bolivar.banks.domain.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

    private List<Cliente> clientes = new ArrayList<>();

    public boolean cadastrar(Cliente cliente){
        return  clientes.add(cliente);
    }

    public Cliente findBy(Integer cpf){
        return clientes.stream().filter(cliente ->cliente.getCpf().equals(cpf)).findFirst().orElse(null);
    }
}
