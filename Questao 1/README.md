# Atividade Avaliativa - Padrões de Projeto em Java

## Questão 1

### Enunciado
Uma empresa de logística precisa desenvolver um sistema de cálculo de tarifas para diferentes tipos de transporte: terrestre, aéreo e marítimo.
Cada modalidade tem regras próprias para determinar o valor da entrega (por exemplo, transporte terrestre leva em conta distância em quilômetros, enquanto aéreo utiliza peso da carga).
Implemente uma solução que permita tratar todos os tipos de transporte de forma genérica, mas que ao mesmo tempo respeite as regras específicas de cada modalidade.

### Padrão Escolhido
- **Nome do Padrão:** Factory Method 

### Justificativa do Padrão
O padrão Factory Method foi escolhido porque o problema exige a criação de diferentes tipos de calculadores de tarifa (terrestre, aérea e marítima) que devem ser tratados de forma genérica, respeitando as particularidades de cada modalidade. Esse padrão delega a responsabilidade de criação para as subclasses, permitindo que cada uma implemente suas regras específicas de cálculo sem alterar a classe base. Dessa forma, o código permanece aberto para extensões (novos tipos de transporte) e fechado para modificações, seguindo o princípio Open/Closed do SOLID e promovendo baixo acoplamento e alta manutenibilidade.

---

### Diagrama
![Diagrama Questao1](https://github.com/JoaoPauloClass/AtividadeAvaliativaPadroesDeProjeto/blob/main/Questao%201/img/Factory%20questao1.png)
---

### Justificativa do Código
O código implementa o padrão através de uma estrutura clara:
Interfaces:

ITransporte: Define o contrato ``processarTarifa()`` para todas as modalidades.
ITransporteFactory: Define o método ``criarTransporte()`` para as factories.

Implementações Concretas:

Terrestre: Calcula tarifa por distância (distância × 6.36).
Aereo: Calcula tarifa por peso (peso × 20).
Maritimo: Calcula tarifa volumétrica (comprimento × largura × altura × fator de cubagem).

Factories:

TerrestreFactory, AereoFactory e MaritimoFactory: Cada uma encapsula a criação de seu respectivo tipo de transporte com os parâmetros necessários.

Cliente:

TarifaService: Processa qualquer transporte de forma genérica, recebendo uma factory e delegando a criação e cálculo através das interfaces. Isso demonstra polimorfismo e baixo acoplamento, permitindo trabalhar com qualquer tipo de transporte sem conhecer detalhes de implementação.
