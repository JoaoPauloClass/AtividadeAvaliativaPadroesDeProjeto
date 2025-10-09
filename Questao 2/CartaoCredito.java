public class CartaoCredito implements IPagamento {
    private String numeroCartao;

    public CartaoCredito(String numerocartao)
    {
        this.numeroCartao = numerocartao;
    }

    @Override
    public boolean processarPagamento(float valorTransacao) {
        
        if (numeroCartao.isBlank()) {
            System.out.println("Nenhum numero de cartão foi passado");
            return false;
        }

        System.out.println("Pagamento de R$" + valorTransacao + " Feito no Cartão de Crédito de Número: " + numeroCartao);
        return true;
    }

}
