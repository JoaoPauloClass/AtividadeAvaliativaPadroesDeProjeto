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
![Diagrama Questao1](https://github.com/JoaoPauloClass/AtividadeAvaliativaPadroesDeProjeto/blob/main/Questao%201/img/Observer%20questao%203.png)

---

### Justificativa do Código
(Explique de forma breve como o código implementa o padrão, destacando os pontos principais da implementação.)
