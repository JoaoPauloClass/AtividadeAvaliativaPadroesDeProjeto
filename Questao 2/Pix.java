import java.util.Random;

public class Pix implements IPagamento {
    private String cpf;

    public Pix(String cpf){
        this.cpf = cpf;
    }

    @Override
    public boolean processarPagamento(float valorTransacao) {
        if (cpf.isBlank()) {
            System.out.println("Nenhum cpf foi passado");
            return false;
        }

        Random rnd = new Random();

        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        StringBuilder sb = new StringBuilder((100000 + rnd.nextInt(900000)));
        for (int i = 0; i < 10; i++)
            sb.append(chars[rnd.nextInt(chars.length)]);

        String codigo = sb.toString();

        System.out.println("Pagamento de R$" + valorTransacao + " Feito no CPF: " + cpf);
        System.out.println("Código do Pix: " + codigo);
        return true;
    }
    
}
