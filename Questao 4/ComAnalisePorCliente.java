import java.util.List;

class ComAnalisePorCliente extends RelatorioDecorator {
    
    public ComAnalisePorCliente(IRelatorio relatorioBase) {
        super(relatorioBase);
    }
    
    @Override
    public String gerar() {
        StringBuilder sb = new StringBuilder(relatorioBase.gerar());
        sb.append("\n");
        sb.append("ANÁLISE POR CLIENTE:\n");
        sb.append("═════════════════════════════════════════════════════════════════════════\n");
        
        List<Pedido> pedidos = getPedidos();
        
        // Agrupa por cliente
        pedidos.stream()
            .collect(java.util.stream.Collectors.groupingBy(
                Pedido::getCliente,
                java.util.stream.Collectors.summingDouble(Pedido::getValor)
            ))
            .entrySet().stream()
            .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
            .forEach(entry -> {
                long qtdPedidos = pedidos.stream()
                    .filter(p -> p.getCliente().equals(entry.getKey()))
                    .count();
                sb.append(String.format("  Cliente:  %-20s │ %d pedido(s) │ R$ %,.2f\n",
                    entry.getKey(), qtdPedidos, entry.getValue()));
            });
        
        sb.append("═════════════════════════════════════════════════════════════════════════\n");
        
        return sb.toString();
    }
    
    @Override
    public double getCustoProcessamento() {
        return relatorioBase.getCustoProcessamento() + 3.5;
    }
    
    @Override
    public List<Pedido> getPedidos() {
        return relatorioBase.getPedidos();
    }
}
