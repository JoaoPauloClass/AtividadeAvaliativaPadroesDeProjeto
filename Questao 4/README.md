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
(Insira aqui o diagrama UML ou outro diagrama que represente a estrutura do padrão aplicado.)

---

### Justificativa do Código
(Explique de forma breve como o código implementa o padrão, destacando os pontos principais da implementação.)
