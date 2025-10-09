public class PixFactory implements IPagamentoFactory {
    private String cpf;

    public PixFactory(String cpf){
        this.cpf = cpf;
    }

    @Override
    public IPagamento criarPagamento() {
        return new Pix(cpf);
    }
    
}
