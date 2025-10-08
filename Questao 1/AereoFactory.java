public class AereoFactory implements ITransporteFactory {
    private double Peso;

    public AereoFactory(double Peso){
        this.Peso = Peso;
    }

    @Override
    public ITransporte criarTransporte() {
        return new Aereo(Peso);
    }
    
}
