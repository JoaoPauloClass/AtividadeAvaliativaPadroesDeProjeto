import java.util.List;

public class RelatorioBasico implements IRelatorio {
    private List<Pedido> pedidos;

    public RelatorioBasico(List<Pedido> pedidos){
        this.pedidos = pedidos;
    }

    @Override
    public String gerar() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔════════════════════════════════════════════════════════════════════════╗\n");
        sb.append("║                        RELATÓRIO DE VENDAS                             ║\n");
        sb.append("╚════════════════════════════════════════════════════════════════════════╝\n\n");
        sb.append("LISTA DE PEDIDOS:\n");
        sb.append("─────────────────────────────────────────────────────────────────────────\n");
        
        for (Pedido pedido : pedidos) {
            sb.append("  ").append(pedido.toString()).append("\n");
        }
        
        sb.append("─────────────────────────────────────────────────────────────────────────\n");
        sb.append(String.format("Total de pedidos: %d\n", pedidos.size()));
        
        return sb.toString();
    }


    @Override
    public double getCustoProcessamento() {
        return 5.0;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }


}
