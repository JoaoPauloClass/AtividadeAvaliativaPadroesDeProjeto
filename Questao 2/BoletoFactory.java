public class BoletoFactory implements IPagamentoFactory {
    private String cpf;

    public BoletoFactory(String cpf){
        this.cpf = cpf;
    }

    @Override
    public IPagamento criarPagamento() {
        return new Boleto(cpf);
    }

    
}
