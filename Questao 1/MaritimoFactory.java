public class MaritimoFactory implements ITransporteFactory {
    private double Comprimento;
    private double Largura;
    private double Altura;
    private double FatorCubagem;

    public MaritimoFactory(double Comprimento, double Largura, double Altura, double FatorCubagem){
        this.Comprimento = Comprimento;
        this.Largura = Largura;
        this.Altura = Altura;
        this.FatorCubagem = FatorCubagem;
    }

    @Override
    public ITransporte criarTransporte() {
        return new Maritimo(Comprimento, Largura, Altura, FatorCubagem);
    }

}
