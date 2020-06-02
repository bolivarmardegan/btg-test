package br.com.bolivar.banks.business;

import br.com.bolivar.banks.database.ContaDao;
import br.com.bolivar.banks.domain.Conta;

import java.math.BigDecimal;

public class ContaBusiness {

    private ContaDao contaDao = new ContaDao();

    public boolean cadastrar(Conta conta){
        if (conta != null && conta.getCliente() != null)
            return this.contaDao.cadastrar(conta);
        return false;
    }

    public Conta findBy(String numero){
        return this.contaDao.findBy(numero);
    }

    public BigDecimal adicionarSaldo(Conta conta, BigDecimal saldo){
       conta.setSaldo(saldo);
       return conta.getSaldo();
    }

    public BigDecimal realizarSaque(Conta conta, BigDecimal valor) {
        if(conta.getSaldo().compareTo(valor) == 1){
            conta.setSaldo(conta.getSaldo().subtract(valor));
        }
        return conta.getSaldo();
    }

    public BigDecimal realizarTransferencia(Conta contaOrigem, Conta contaDestino, BigDecimal valor) {
        if(contaOrigem.getSaldo().compareTo(valor) == 1){
            contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(valor));
            contaDestino.setSaldo(valor);
        }
        return contaOrigem.getSaldo();
    }
}
