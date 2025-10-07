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
(Insira aqui o diagrama UML ou outro diagrama que represente a estrutura do padrão aplicado.)

---

### Justificativa do Código
(Explique de forma breve como o código implementa o padrão, destacando os pontos principais da implementação.)
