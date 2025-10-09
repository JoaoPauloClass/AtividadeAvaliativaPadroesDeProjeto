import java.util.Random;

public class Boleto implements IPagamento {
    private String cpf;

    public Boleto(String cpf){
        this.cpf = cpf;
    }

    @Override
    public boolean processarPagamento(float valorTransacao) {
        if (cpf.isBlank()) {
            System.out.println("Nenhum cpf foi passado");
            return false;
        }

        Random rnd = new Random();
        int codigo = 1000000000 + rnd.nextInt(900000000);

        System.out.println("Pagamento de R$" + valorTransacao + " Feito no CPF: " + cpf);
        System.out.println("Código do Boleto: " + codigo);
        return true;
    }
    
}
