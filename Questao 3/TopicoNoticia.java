import java.util.ArrayList;
import java.util.List;

public class TopicoNoticia implements ISubject {
    private String nome;
    private List<IObserver> inscritos;
    private List<String> noticias;

    public TopicoNoticia(String nome) {
        this.nome = nome;
        this.inscritos = new ArrayList<>();
        this.noticias = new ArrayList<>();

    }

    @Override
    public void inscrever(IObserver observer) {
        if (!inscritos.contains(observer)) {
            inscritos.add(observer);
            System.out.println("Leitor inscrito no tópico: " + nome);
        }
    }

    @Override
    public void desinscrever(IObserver observer) {
        if (inscritos.remove(observer)) {
            System.out.println("Leitor desinscrito do tópico: " + nome);
        }
    }

    @Override
    public void notificar(String noticia) {
        System.out.println("\n Notificando " + inscritos.size() + " leitores do tópico '" + nome);
        for (IObserver leitor : inscritos) {
            leitor.notificar(noticia, nome);
        }

    }

    public void publicarNoticia(String noticia) {
        noticias.add(noticia);

        System.out.println("\nNOVA NOTÍCIA PUBLICADA em [" + nome + "]");
        System.out.println("Conteúdo: " + noticia);
        notificar(noticia);
    }

    public void listarNoticias(){
        for(String noticia : noticias){
            System.out.println("\n" + noticia);
        }
    }

}
