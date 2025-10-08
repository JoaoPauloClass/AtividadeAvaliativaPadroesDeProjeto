public class TarifaService {
    public double processarTarifa(ITransporteFactory factory)
    {
        ITransporte transporte = factory.criarTransporte();
        double precoTarifa = transporte.processarTarifa();
        return precoTarifa;
    }
}
