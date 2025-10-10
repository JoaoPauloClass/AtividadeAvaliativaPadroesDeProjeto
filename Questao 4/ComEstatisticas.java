import java.util.ArrayList;
import java.util.List;

public class ComEstatisticas extends RelatorioDecorator {

    public ComEstatisticas(IRelatorio relatorioBase) {
        super(relatorioBase);
    }

    @Override
    public String gerar() {
        StringBuilder sb = new StringBuilder(relatorioBase.gerar());
        sb.append("\n");
        sb.append("ESTATÍSTICAS DE FATURAMENTO:\n");
        sb.append("═════════════════════════════════════════════════════════════════════════\n");
        
        List<Pedido> pedidos = getPedidos();
        
        double total = pedidos.stream().mapToDouble(Pedido::getValor).sum();
        double media = pedidos.isEmpty() ? 0 : total / pedidos.size();
        double maior = pedidos.stream().mapToDouble(Pedido::getValor).max().orElse(0);
        double menor = pedidos.stream().mapToDouble(Pedido::getValor).min().orElse(0);
        
        sb.append(String.format("Faturamento Total:     R$ %,.2f\n", total));
        sb.append(String.format("Ticket Médio:          R$ %,.2f\n", media));
        sb.append(String.format("Maior Pedido:          R$ %,.2f\n", maior));
        sb.append(String.format("Menor Pedido:          R$ %,.2f\n", menor));
        sb.append("═════════════════════════════════════════════════════════════════════════\n");
        
        return sb.toString();
    }
    
    @Override
    public double getCustoProcessamento() {
        return relatorioBase.getCustoProcessamento() + 3.0;
    }
    
    @Override
    public List<Pedido> getPedidos() {
        return relatorioBase.getPedidos();
    }
    
}
