public class TerrestreFactory implements ITransporteFactory {
    private double distancia;

    public TerrestreFactory(double distancia){
        this.distancia = distancia;
    }

    @Override
    public ITransporte criarTransporte() {
       return new Terrestre(distancia);
    }
    
}
