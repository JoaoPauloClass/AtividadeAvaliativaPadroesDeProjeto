# Atividade Avaliativa - Padrões de Projeto em Java

## Questão 2

### Enunciado
Uma plataforma de pagamentos deve permitir a integração com diferentes meios, como cartão de crédito, boleto bancário e PIX.
A escolha do meio de pagamento deve ser configurável e o sistema precisa instanciar dinamicamente o processador correspondente sem que o código principal da aplicação precise conhecer detalhes da criação de cada objeto.
Implemente uma solução que atenda a esse requisito.

### Padrão Escolhido
- **Nome do Padrão:** Factory 

### Justificativa do Padrão
O padrão Factory Method foi selecionado porque o cenário demanda a instanciação de distintos processadores de pagamento (cartão de crédito, boleto bancário e PIX) que necessitam ser manipulados de maneira uniforme, mantendo as especificidades de cada modalidade. Este padrão transfere a responsabilidade de construção para um método factory especializado, possibilitando que a aplicação crie dinamicamente o processador apropriado sem que a lógica principal necessite conhecer os detalhes de instanciação de cada implementação. Assim, a solução mantém-se aberta para expansões (novos métodos de pagamento) e fechada para alterações, respeitando o princípio Open/Closed do SOLID e estabelecendo baixo acoplamento entre a plataforma e as classes concretas dos processadores.

---

### Diagrama
![Diagrama Questao2](https://github.com/JoaoPauloClass/AtividadeAvaliativaPadroesDeProjeto/blob/main/Questao%202/img/Factory%20Questao%202.png)

---

### Justificativa do Código
O código implementa o padrão através de uma estrutura clara:

#### Interfaces:
IPagamento: Define o contrato processarPagamento(float) que retorna um boolean indicando sucesso ou falha.
IPagamentoFactory: Define o método criarPagamento() para as factories.

#### Implementações Concretas:
CartaoCredito: Processa pagamento validando o número do cartão.
Boleto: Processa pagamento com CPF e gera código de boleto aleatório.
Pix: Processa pagamento com CPF e gera código PIX alfanumérico.

#### Factories:
CartaoCreditoFactory, BoletoFactory e PixFactory: Cada uma encapsula a criação de seu respectivo meio de pagamento com os parâmetros necessários (número do cartão ou CPF).

#### Cliente:
PagamentoService: Processa qualquer pagamento de forma genérica, recebendo uma factory e o valor da transação. Delega a criação do processador à factory e executa o pagamento através da interface, demonstrando polimorfismo e baixo acoplamento. O serviço não precisa conhecer qual meio de pagamento está sendo utilizado, apenas trabalha com as abstrações.
