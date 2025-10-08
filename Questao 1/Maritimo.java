public class Maritimo implements ITransporte{
    private double Comprimento;
    private double Largura;
    private double Altura;
    private double FatorCubagem;

    public Maritimo(double Comprimento, double Largura, double Altura, double FatorCubagem){
        this.Comprimento = Comprimento;
        this.Largura = Largura;
        this.Altura = Altura;
        this.FatorCubagem = FatorCubagem;
    }

    @Override
    public double processarTarifa() {
        double valor = Comprimento * Altura * FatorCubagem * Largura;
        return valor;
    }

}
