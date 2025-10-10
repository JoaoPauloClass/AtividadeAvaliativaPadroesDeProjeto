import java.time.LocalDate;
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

    @Override
    public List<Pedido> getPedidos() {
        return relatorioBase.getPedidos();
    }
}
