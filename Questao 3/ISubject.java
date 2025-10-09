public interface ISubject {
    void inscrever(IObserver observer);
    void desinscrever(IObserver observer);
    void notificar(String noticia);
}