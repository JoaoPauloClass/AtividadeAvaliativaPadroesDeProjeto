public interface ISubject {
    void inscrever(IObserver observer);
    void desinscrever(IObserver observer);
    void atualizar(String noticia);
}