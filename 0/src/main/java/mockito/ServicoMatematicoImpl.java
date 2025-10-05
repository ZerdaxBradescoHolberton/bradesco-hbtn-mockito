package mockito;

import mockito.ServicoMatematico;

public class ServicoMatematicoImpl implements ServicoMatematico {

    @Override
    public int somar(int a, int b) {
        return a + b;
    }
}