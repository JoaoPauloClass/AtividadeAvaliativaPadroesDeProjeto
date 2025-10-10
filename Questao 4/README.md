# Atividade Avaliativa - Padrões de Projeto em Java

## Questão 4

### Enunciado
Um sistema de pedidos online precisa gerar relatórios de vendas em diferentes formatos
Inicialmente, o relatório contém apenas informações básicas (lista de pedidos).
Posteriormente, o gestor pode decidir adicionar funcionalidades adicionais, como estatísticas de faturamento, gráficos ou exportação em PDF.
Esses recursos devem ser opcionais e adicionados de forma flexível, sem alterar o código existente do relatório básico.
Implemente uma solução que permita essa extensão progressiva de funcionalidades.

### Padrão Escolhido
- **Nome do Padrão:** Decorator 

### Justificativa do Padrão
O padrão Decorator permite adicionar funcionalidades ao relatório de forma incremental e flexível, sem modificar a classe base do relatório básico. Cada funcionalidade adicional (estatísticas, gráficos, exportação PDF) é implementada como um decorador que "envolve" o relatório original, adicionando seu comportamento específico. Os decoradores podem ser combinados livremente conforme a necessidade do gestor, mantendo o código aberto para extensões e fechado para modificações. Isso promove alta flexibilidade e reutilização de código.

---

### Diagrama
![Diagrama Questao3](https://github.com/JoaoPauloClass/AtividadeAvaliativaPadroesDeProjeto/blob/main/Questao%204/img/Decorator%20Questao%204.png)

---

### Justificativa do Código
Interface Base:

IRelatorio: Define os métodos gerar() e getCustoProcessamento() que todos os relatórios devem implementar.

Componente Concreto:

RelatorioBasico: Implementação básica que exibe a lista de pedidos. Serve como base para aplicação dos decorators e fornece acesso aos dados através do método getPedidos().

Decorator Abstrato:

RelatorioDecorator: Classe abstrata que implementa IRelatorio e mantém referência ao relatorioBase. Delega as chamadas para o componente decorado, permitindo que subclasses adicionem comportamento antes ou depois da delegação.

Decorators Concretos:

ComEstatisticas: Adiciona cálculos de faturamento total, ticket médio, maior e menor pedido. Custo adicional: R$ 3,00.
ComGrafico: Gera visualização gráfica em barras dos valores dos pedidos. Custo adicional: R$ 2,50.
ComAnalisePorCliente: Agrupa pedidos por cliente e exibe totalizações. Custo adicional: R$ 3,50.
ComExportacaoPDF: Adiciona metadados de exportação em PDF. Custo adicional: R$ 4,50.

Funcionamento:
Os decorators podem ser empilhados em qualquer ordem e combinação. Cada um chama relatorioBase.gerar() primeiro, obtém o conteúdo já gerado, adiciona sua funcionalidade e retorna o resultado completo. O método getCustoProcessamento() soma os custos de forma encadeada. Os decorators concretos utilizam o método auxiliar obterPedidos() para acessar os dados originais percorrendo a cadeia de decorators até encontrar o RelatorioBasico, demonstrando a composição recursiva característica do padrão.
