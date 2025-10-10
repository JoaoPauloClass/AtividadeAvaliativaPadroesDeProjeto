public class Main {
    public static void main(String[] args) {
        
        TopicoNoticia politica = new TopicoNoticia("Política");
        TopicoNoticia esportes = new TopicoNoticia("Esportes");
        TopicoNoticia tecnologia = new TopicoNoticia("Tecnologia");
        
        Leitor joao = new Leitor("João");
        Leitor maria = new Leitor("Maria");
        Leitor pedro = new Leitor("Pedro");
        
        politica.inscrever(joao);
        tecnologia.inscrever(joao);
        
        politica.inscrever(maria);
        esportes.inscrever(maria);
        tecnologia.inscrever(maria);
        
        esportes.inscrever(pedro);
        

        politica.publicarNoticia("Congresso aprova nova reforma tributária");
        esportes.publicarNoticia("Brasil vence competição internacional de vôlei");
        tecnologia.publicarNoticia("Nova IA revoluciona mercado de desenvolvimento");
        
        tecnologia.desinscrever(joao);
        
        tecnologia.publicarNoticia("Lançado novo smartphone com bateria de 7 dias");
        
        joao.exibirNotificacoes();
        maria.exibirNotificacoes();
        pedro.exibirNotificacoes();
    }
}
