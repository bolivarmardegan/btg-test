package br.com.bolivar.banks.business;

import br.com.bolivar.banks.dataBuilder.BancoDataBuilder;
import br.com.bolivar.banks.dataBuilder.ClienteDataBuilder;
import br.com.bolivar.banks.dataBuilder.ContaDataBuilder;
import br.com.bolivar.banks.domain.Banco;
import br.com.bolivar.banks.domain.Cliente;
import br.com.bolivar.banks.domain.Conta;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BancoBusinessTest {

    private BancoBusiness bancoBusiness;
    private ClienteBusiness clienteBusiness;
    private ContaBusiness contaBusiness;
    private Banco bancoAfrica;
    private Banco bancoAmerica;
    private Banco bancoFantasma;
    private boolean cadastrouBancoAfrica;
    private boolean cadastrouBancoAmerica;
    private Cliente dino;
    private Cliente maria;
    private Cliente antonio;
    private Conta contaAntonio;
    private Cliente zeze;
    private Conta contaZeze;

    @Before
    public void initTests(){
       this.bancoBusiness = new BancoBusiness();
       this.clienteBusiness = new ClienteBusiness();
       this.contaBusiness = new ContaBusiness();
       this.bancoAfrica = new BancoDataBuilder().recebeParams("Banco Africa",1).builder();
       this.bancoAmerica = new BancoDataBuilder().recebeParams("Banco America",1).builder();
       this.bancoFantasma = new BancoDataBuilder().recebeParams("Banco Fantasma", 666).builder();
       this.dino = new ClienteDataBuilder().recebeParametros("Dino Santos", 40).builder();
       this.maria = new ClienteDataBuilder().recebeParametros("Maria Joana", 40).builder();;
       this.antonio= new ClienteDataBuilder().recebeParametros("Antonio Almeida Santos", 40).builder();;
       this.contaAntonio = new ContaDataBuilder().recebeParams("5678", "11156-2",antonio).builder();
       this.zeze = new ClienteDataBuilder().recebeParametros("Jose Zeni Santos", 40).builder();;
       this.contaZeze = new ContaDataBuilder().recebeParams("9090","44400-9",zeze).builder();
    }

    @After
    public void finishTest(){
        this.bancoAfrica = new Banco();
        this.bancoAmerica = new Banco();
        this.bancoFantasma = new Banco();
        this.bancoBusiness = new BancoBusiness();
    }

    @Test
    public void naoDeveCadastrarBancoComMesmoCodigo(){
        this.cadastrouBancoAfrica = this.bancoBusiness.cadastrar(this.bancoAfrica);
        this.cadastrouBancoAmerica = this.bancoBusiness.cadastrar(this.bancoAmerica);
        assertTrue(this.cadastrouBancoAfrica);
        assertFalse(this.cadastrouBancoAmerica);
    }

    @Test
    public void deveRetornarBancoByCodigo(){
        Banco bancoTest = this.bancoBusiness.findBy(bancoAfrica.getCodigo());
        assertFalse(bancoTest.equals(null));
    }

    @Test
    public void deveAtualizarBancoCasoExistaNaBase(){
        Banco bancoAtualizar = this.bancoBusiness.findBy(bancoAfrica.getCodigo());
        bancoAtualizar.setNome("Banco Africa 2000");
        Banco bancoAtualizado = this.bancoBusiness.atualizarBy(bancoAtualizar.getCodigo());
        assertEquals(!bancoAtualizado.getNome().equals(bancoAfrica.getNome()), true);
    }

    @Test(expected = NullPointerException.class)
    public void naoDeveCadastrarContaComClienteNull(){
        this.clienteBusiness.cadastrar(antonio);
        this.contaBusiness.cadastrar(contaAntonio);
        this.contaAntonio.setCliente(null);
        boolean vinculou = this.bancoBusiness.vincular(bancoAfrica,contaAntonio);
        assertFalse(vinculou);
    }

    @Test(expected = NullPointerException.class)
    public void deveVincularContaAoBanco(){
        this.clienteBusiness.cadastrar(antonio);
        this.contaBusiness.cadastrar(contaAntonio);
        boolean vinculou = this.bancoBusiness.vincular(bancoAfrica,contaAntonio);
        assertTrue(vinculou);
    }

    @Test
    public void deveCadastrarNovoCliente(){
        boolean clienteCadastrado = this.bancoBusiness.cadastrar(this.antonio);
        assertTrue(clienteCadastrado);
    }

    @Test
    public void naoDeveExcluirBancoQueNaoExiste(){
        boolean excluido = this.bancoBusiness.excluirBy(bancoFantasma.getCodigo());
        assertFalse(excluido);
    }

    @Test
    public void deveExcluirBancoExistente(){
        this.bancoBusiness.cadastrar(this.bancoFantasma);
        boolean excluido = this.bancoBusiness.excluirBy(bancoFantasma.getCodigo());
        assertTrue(excluido);
    }
}
