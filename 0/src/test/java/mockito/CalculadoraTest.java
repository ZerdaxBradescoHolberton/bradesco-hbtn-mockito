package mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class CalculadoraTest {

    @Mock
    private ServicoMatematico servicoMatematico;

    @BeforeEach
    public void init() {
        openMocks(this);
    }

    @Test
    public void testSomar() {
        when(servicoMatematico.somar(3, 2)).thenReturn(5);
        assertEquals(5, new Calculadora(servicoMatematico).somar(3, 2));
    }


}