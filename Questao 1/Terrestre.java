public class Terrestre implements ITransporte {
    private double distancia;

    public Terrestre(double distancia) {
        this.distancia = distancia;
    }

    @Override
    public double processarTarifa()
    {
        double valor = this.distancia * 6.36;
        return valor;
    }
}
