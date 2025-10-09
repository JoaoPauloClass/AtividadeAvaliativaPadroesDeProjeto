import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class ComExportacaoPDF extends RelatorioDecorator {
    
    public ComExportacaoPDF(IRelatorio relatorioBase) {
        super(relatorioBase);
    }
    
    @Override
    public String gerar() {
        StringBuilder sb = new StringBuilder(relatorioBase.gerar());
        sb.append("\n");
        sb.append("EXPORTAÇÃO PDF:\n");
        sb.append("═════════════════════════════════════════════════════════════════════════\n");
        sb.append("  ✓ Relatório formatado para exportação PDF\n");
        sb.append("  ✓ Arquivo: relatorio_vendas_").append(LocalDate.now()).append(".pdf\n");
        sb.append("  ✓ Metadados incluídos\n");
        sb.append("  ✓ Compressão aplicada\n");
        sb.append("  ✓ Pronto para download\n");
        sb.append("═════════════════════════════════════════════════════════════════════════\n");
        
        return sb.toString();
    }
    
    @Override
    public double getCustoProcessamento() {
        return relatorioBase.getCustoProcessamento() + 4.5;
    }
}

// Decorator Concreto 4: Adiciona Análise por Cliente
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
        
        List<Pedido> pedidos = obterPedidos();
        
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