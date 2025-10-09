import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║         SISTEMA DE RELATÓRIOS COM PADRÃO DECORATOR                     ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════╝\n");
        
        // Criando dados de exemplo
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(new Pedido(101, "João Silva", 1500.00, LocalDate.of(2025, 10, 1)));
        pedidos.add(new Pedido(102, "Maria Santos", 2300.50, LocalDate.of(2025, 10, 2)));
        pedidos.add(new Pedido(103, "Pedro Oliveira", 890.00, LocalDate.of(2025, 10, 3)));
        pedidos.add(new Pedido(104, "Ana Costa", 3200.00, LocalDate.of(2025, 10, 4)));
        pedidos.add(new Pedido(105, "João Silva", 1750.00, LocalDate.of(2025, 10, 5)));
        
        System.out.println("═══════════════════════════════════════════════════════════════════════════");
        System.out.println("EXEMPLO 1: Relatório Básico");
        System.out.println("═══════════════════════════════════════════════════════════════════════════");
        IRelatorio relatorio1 = new RelatorioBasico(pedidos);
        System.out.println(relatorio1.gerar());
        System.out.println("Custo de processamento: R$ " + relatorio1.getCustoProcessamento());
        
        System.out.println("\n\n═══════════════════════════════════════════════════════════════════════════");
        System.out.println("EXEMPLO 2: Relatório com Estatísticas");
        System.out.println("═══════════════════════════════════════════════════════════════════════════");
        IRelatorio relatorio2 = new ComEstatisticas(new RelatorioBasico(pedidos));
        System.out.println(relatorio2.gerar());
        System.out.println("Custo de processamento: R$ " + relatorio2.getCustoProcessamento());
        
        System.out.println("\n\n═══════════════════════════════════════════════════════════════════════════");
        System.out.println("EXEMPLO 3: Relatório Completo (Todas as Funcionalidades)");
        System.out.println("═══════════════════════════════════════════════════════════════════════════");
        IRelatorio relatorio3 = new ComExportacaoPDF(
                                    new ComAnalisePorCliente(
                                        new ComGrafico(
                                            new ComEstatisticas(
                                                new RelatorioBasico(pedidos)))));
        System.out.println(relatorio3.gerar());
        System.out.println("Custo de processamento: R$ " + relatorio3.getCustoProcessamento());
        
        System.out.println("\n\n═══════════════════════════════════════════════════════════════════════════");
        System.out.println("EXEMPLO 4: Relatório Customizado (Estatísticas + PDF)");
        System.out.println("═══════════════════════════════════════════════════════════════════════════");
        IRelatorio relatorio4 = new ComExportacaoPDF(
                                    new ComEstatisticas(
                                        new RelatorioBasico(pedidos)));
        System.out.println(relatorio4.gerar());
        System.out.println("Custo de processamento: R$ " + relatorio4.getCustoProcessamento());
        
        System.out.println("\n╔════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                      FIM DA DEMONSTRAÇÃO                               ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════╝");
    }
}
