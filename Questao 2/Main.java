public class Main {
    public static void main(String[] args) {
        PagamentoService service = new PagamentoService();

        service.processarPagamento( new CartaoCreditoFactory("123123123"),1500 ); //Sucesso
        service.processarPagamento( new CartaoCreditoFactory(""),1500 );//ERRO

        System.out.println();

        service.processarPagamento(new BoletoFactory("123.123.123"), 1500);//Sucesso
        service.processarPagamento(new BoletoFactory(""), 1500);//ERRO

        System.out.println();

        service.processarPagamento(new PixFactory("123.123.123"), 1500);//Sucesso
        service.processarPagamento(new PixFactory(""), 1500);//ERRO
    }
}
