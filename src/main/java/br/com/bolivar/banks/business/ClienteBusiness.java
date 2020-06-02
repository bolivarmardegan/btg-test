package br.com.bolivar.banks.business;

import br.com.bolivar.banks.database.ClienteDao;
import br.com.bolivar.banks.domain.Cliente;

public class ClienteBusiness {

    private ClienteDao clienteDao = new ClienteDao();

    public boolean cadastrar(Cliente cliente){
        if(cliente != null)
            return this.clienteDao.cadastrar(cliente);
        return false;
    }

    public Cliente findBy(Integer cpf){
        return this.clienteDao.findBy(cpf);
    }
}
