public class Aereo implements ITransporte {
    private double Peso;

    public Aereo(double Peso){
        this.Peso = Peso;
    }

    @Override
    public double processarTarifa() {
        double valor = Peso * 20; 
        return valor;
    }
    
}
