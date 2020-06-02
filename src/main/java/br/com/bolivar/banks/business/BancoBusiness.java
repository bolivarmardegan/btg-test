package br.com.bolivar.banks.business;

import br.com.bolivar.banks.database.BancoDao;
import br.com.bolivar.banks.domain.Banco;
import br.com.bolivar.banks.domain.Cliente;
import br.com.bolivar.banks.domain.Conta;

public class BancoBusiness {

    private BancoDao bancoDao = new BancoDao();
    private ClienteBusiness clienteBusiness = new ClienteBusiness();
    private ContaBusiness contaBusiness = new ContaBusiness();

    public boolean cadastrar(Banco banco){
        if(this.bancoDao.naoExiste(banco))
            return this.bancoDao.cadastrar(banco);
        return false;
    }

    public Banco findBy(Integer codigo){
        return bancoDao.findBy(codigo);
    }

    public Banco atualizarBy(Integer codigo){
        return bancoDao.atualizarBy(codigo);
    }

    public boolean excluirBy(Integer codigo){
        return bancoDao.excluirBy(codigo);
    }

    public boolean cadastrar(Cliente cliente){
       return this.clienteBusiness.cadastrar(cliente);
    }

    public boolean vincular(Banco banco, Conta conta){
        Banco banc = this.bancoDao.findBy(banco.getCodigo());
        Conta cc = this.contaBusiness.findBy(conta.getNumero());
        banc.getContas().add(cc);
        return this.bancoDao.cadastrar(banc);
    }
}
