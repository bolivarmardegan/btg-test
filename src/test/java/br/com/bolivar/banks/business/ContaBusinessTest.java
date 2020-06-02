package br.com.bolivar.banks.business;

import br.com.bolivar.banks.dataBuilder.ClienteDataBuilder;
import br.com.bolivar.banks.dataBuilder.ContaDataBuilder;
import br.com.bolivar.banks.domain.Cliente;
import br.com.bolivar.banks.domain.Conta;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ContaBusinessTest {

    private Conta contaPedro;
    private Conta contaJose;
    private ContaBusiness contaBusiness;
    private Cliente pedroChen;
    private Cliente joseMimi;

    @Before
    public void init(){
        this.contaBusiness = new ContaBusiness();
        this.contaBusiness = new ContaBusiness();
        this.pedroChen = new ClienteDataBuilder().recebeParametros("Pedro Chen",35).builder();
        this.contaPedro = new ContaDataBuilder().recebeParams("2356", "556677-P",pedroChen).builder();
        this.joseMimi = new ClienteDataBuilder().recebeParametros("Jose Mimi",49).builder();
        this.contaJose = new ContaDataBuilder().recebeParams("2323","9999000-II",joseMimi).builder();
    }

    @Test
    public void naoDeveCadastrarContaNull(){
        this.contaPedro = null;
        boolean cadastrou = this.contaBusiness.cadastrar(this.contaPedro);
        assertFalse(cadastrou);
    }

    @Test
    public void naoDeveGerarContaCOmClienteNull(){
        this.contaPedro.setCliente(null);
        boolean cadastrouConta = this.contaBusiness.cadastrar(this.contaPedro);
        assertFalse(cadastrouConta);
    }

    @Test
    public void deveGerarContaParaClienteCadastrado(){
        boolean cadastrouConta = this.contaBusiness.cadastrar(contaPedro);
        assertTrue(cadastrouConta);
    }

    @Test
    public void deveAdicionarSaldoAContaDoCliente(){
        BigDecimal saldo = new BigDecimal("300.00");
        this.contaBusiness.adicionarSaldo(contaPedro, saldo);
        assertTrue(contaPedro.getSaldo().equals(saldo));
    }

    @Test
    public void naoDeveRetirarValorMaiorQueSaldo(){
        BigDecimal saldo = new BigDecimal("300.00");
        BigDecimal valor = new BigDecimal("900.00");
        contaBusiness.adicionarSaldo(contaPedro,saldo);
        this.contaBusiness.realizarSaque(contaPedro, valor);
        System.out.println("Saldo "+contaPedro.getSaldo());
        assertTrue(contaPedro.getSaldo().equals(saldo));
    }

    @Test
    public void deveRealizarSaque(){
        BigDecimal saldo = new BigDecimal("300.00");
        BigDecimal valor = new BigDecimal("90.00");
        contaBusiness.adicionarSaldo(contaPedro,saldo);
        this.contaBusiness.realizarSaque(contaPedro, valor);
        System.out.println("Saldo "+contaPedro.getSaldo());
        assertTrue(contaPedro.getSaldo().compareTo(saldo) == -1);
    }

    @Test
    public void naoDeveRealizarTransferenciaDeValorMaiorQueSaldoDaContaOrigem(){
        BigDecimal saldo = new BigDecimal("500.00");
        BigDecimal valor = new BigDecimal("900.00");
        this.contaBusiness.adicionarSaldo(contaPedro,saldo);
        this.contaBusiness.realizarTransferencia(contaPedro,contaJose,valor);
        assertTrue(contaPedro.getSaldo().compareTo(saldo) == 0);
    }

    @Test
    public void deveRealizarTransferenciaParaOutraConta(){
        BigDecimal saldo = new BigDecimal("1000.00");
        BigDecimal valor = new BigDecimal("90.00");
        this.contaBusiness.adicionarSaldo(contaPedro,saldo);
        this.contaBusiness.realizarTransferencia(contaPedro,contaJose,valor);
        assertTrue(contaPedro.getSaldo().compareTo(contaPedro.getSaldo().subtract(valor)) == 1);
    }
}
