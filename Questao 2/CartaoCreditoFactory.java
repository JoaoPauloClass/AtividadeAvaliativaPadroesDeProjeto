public class CartaoCreditoFactory implements IPagamentoFactory {
    private String numeroCartao;

    public CartaoCreditoFactory(String numeroCartao){
        this.numeroCartao = numeroCartao;
    }

    @Override
    public IPagamento criarPagamento() {
        return new CartaoCredito(numeroCartao);    
    }
    
}
