# Atividade Avaliativa - Padrões de Projeto em Java

## Questão 3

### Enunciado
Um site de notícias deseja implementar um recurso onde os leitores podem se inscrever em determinados tópicos (política, esportes, tecnologia).
Sempre que uma nova notícia for publicada em um tópico, todos os leitores interessados devem receber uma notificação automática.
Implemente uma solução que suporte múltiplos tópicos e múltiplos leitores, sem exigir que o site mantenha manualmente o controle de quem deve ser notificado.

### Padrão Escolhido
- **Nome do Padrão:** Observer 

### Justificativa do Padrão
O padrão Observer permite que os tópicos (subjects) mantenham uma lista de leitores inscritos (observers) e os notifiquem automaticamente quando uma nova notícia for publicada. Cada leitor pode se inscrever ou desinscrever de múltiplos tópicos de interesse. Quando um tópico recebe uma nova notícia, ele percorre sua lista de inscritos e notifica cada um, sem que o sistema precise controlar manualmente essas notificações. Isso promove baixo acoplamento entre os tópicos e os leitores.

---

### Diagrama
![Diagrama Questao3](https://github.com/JoaoPauloClass/AtividadeAvaliativaPadroesDeProjeto/blob/main/Questao%203/img/Observer%20questao%203.png)

---

### Justificativa do Código
Interfaces:

ISubject: Define o contrato para os subjects com métodos inscrever(), desinscrever() e atualizar().
IObserver: Define o contrato notificar(String, String) para os observers receberem atualizações.

Subject Concreto:

TopicoNoticia: Mantém uma lista de observers inscritos e outra de notícias publicadas. Implementa os métodos de inscrição/desinscrição gerenciando a lista de inscritos. O método publicarNoticia() adiciona a notícia e automaticamente chama atualizar(), que percorre a lista de inscritos notificando cada um através da interface IObserver.

Observer Concreto:

Leitor: Armazena seu nome e uma lista de notificações recebidas. Implementa notificar() para processar notificações dos tópicos, adicionando-as à sua lista pessoal. O método exibirNotificacoes() permite visualizar o histórico recebido.

Funcionamento:
A implementação demonstra o desacoplamento característico do padrão: os tópicos não conhecem a estrutura interna dos leitores, apenas invocam o método notificar() da interface. Isso permite que múltiplos leitores se inscrevam em múltiplos tópicos de forma flexível, e qualquer nova publicação dispara automaticamente as notificações para todos os interessados, eliminando a necessidade de controle manual.
