package mockito;

public class BancoService {
    private ContaRepository contaRepository;


    public BancoService(ContaRepository contaRepository) {
        //implemente aqui
        this.contaRepository = contaRepository;
    }


    public double consultarSaldo(String numeroConta) {
        //implemente aqui
        return contaRepository.buscarConta(numeroConta).getSaldo();
    }


    public void depositar(String numeroConta, double valor) {
        //implemente aqui
        Conta conta = contaRepository.buscarConta(numeroConta);
        conta.setSaldo(conta.getSaldo() + valor);
        contaRepository.salvar(conta);
    }
}