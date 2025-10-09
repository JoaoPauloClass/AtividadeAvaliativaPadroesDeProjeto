public class PagamentoService {
    public void processarPagamento(IPagamentoFactory factory, float valorTransacao){
        IPagamento pagamento = factory.criarPagamento();
        boolean sucesso = pagamento.processarPagamento(valorTransacao);

        if (sucesso) {
            System.out.println("Pagamento processado com sucesso!\n");
        } else {
            System.out.println("Falha ao processar pagamento.\n");
        }

    }


}
