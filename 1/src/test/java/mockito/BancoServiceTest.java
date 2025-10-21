package mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BancoServiceTest {

    @Mock
    private ContaRepository repository;

    @InjectMocks
    private BancoService service;


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConsultarSaldo() {
        // Criando mock do repositório


        // Criando conta simulada
        Conta conta = new Conta("1", 100.00);

        // Definindo comportamento do mock
        when(repository.buscarConta(anyString())).thenReturn(conta);

        // Criando serviço com o mock


        // Testando consulta de saldo
        double saldo = service.consultarSaldo("1");

        // Verificando se o saldo está correto
        assertEquals(100.00, saldo);

        // Verificando se o método buscarConta foi chamado
        verify(repository, atLeast(1)).buscarConta(anyString());
    }


    @Test
    public void testDepositar() {
        // Criando mock do repositório


        // Criando conta simulada
        Conta conta = new Conta("1", 100.00);


        // Definindo comportamento do mock
        when(repository.buscarConta(anyString())).thenReturn(conta);

        // Criando serviço com o mock


        // Executando depósito
        service.depositar("1", 30.00);

        // Verificando se o saldo foi atualizado
        assertEquals(130.00, conta.getSaldo());

        // Verificando se os métodos foram chamados corretamente
        verify(repository, atLeast(1)).buscarConta(anyString());
        verify(repository, atLeast(1)).salvar(conta);
    }

}