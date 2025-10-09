import java.util.ArrayList;
import java.util.List;

public class Leitor implements IObserver {
    private String nome;
    private List<String> notificacoes;

    public Leitor(String nome) {
        this.nome = nome;
        this.notificacoes = new ArrayList<>();
    }

    @Override
    public void notificar(String topico, String noticia) {
        String mensagem = "[" + topico + "] " + noticia;
        notificacoes.add(mensagem);
        System.out.println("-> " + nome + " recebeu notificação: " + mensagem);
    }

    public void exibirNotificacoes() {
        System.out.println("\n Notificações de " + nome + ":");
        if (notificacoes.isEmpty()) {
            System.out.println("  Nenhuma notificação recebida.");
        } else {
            for (int i = 0; i < notificacoes.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + notificacoes.get(i));
            }
        }
    }
    
}
