import java.util.ArrayList;
import java.util.List;

class ComGrafico extends RelatorioDecorator {
    
    public ComGrafico(IRelatorio relatorioBase) {
        super(relatorioBase);
    }
    
    @Override
    public String gerar() {
        StringBuilder sb = new StringBuilder(relatorioBase.gerar());
        sb.append("\n");
        sb.append("GRÁFICO DE VENDAS (últimos pedidos):\n");
        sb.append("═════════════════════════════════════════════════════════════════════════\n");
        
        List<Pedido> pedidos = obterPedidos();
        
        if (pedidos.isEmpty()) {
            sb.append("  Sem dados para exibir\n");
        } else {
            double maxValor = pedidos.stream().mapToDouble(Pedido::getValor).max().orElse(1);
            int maxBarras = 50;
            
            for (Pedido pedido : pedidos) {
                int barras = (int) ((pedido.getValor() / maxValor) * maxBarras);
                sb.append(String.format("  Pedido #%-3d │", pedido.getId()));
                sb.append("█".repeat(Math.max(0, barras)));
                sb.append(String.format(" R$ %,.2f\n", pedido.getValor()));
            }
        }
        
        sb.append("═════════════════════════════════════════════════════════════════════════\n");
        
        return sb.toString();
    }
    
    @Override
    public double getCustoProcessamento() {
        return relatorioBase.getCustoProcessamento() + 2.5;
    }
    
    private List<Pedido> obterPedidos() {
        IRelatorio temp = relatorioBase;
        while (temp instanceof RelatorioDecorator) {
            temp = ((RelatorioDecorator) temp).relatorioBase;
        }
        if (temp instanceof RelatorioBasico) {
            return ((RelatorioBasico) temp).getPedidos();
        }
        return new ArrayList<>();
    }
}