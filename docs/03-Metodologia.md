
# Metodologia

<span style="color:red">Pré-requisitos: <a href="2-Especificação do Projeto.md"> Documentação de Especificação</a></span>

A métodologia utilizada será o método ágil Scrum. O Scrum é uma metodologia ágil que se encaixa bem em projetos de desenvolvimento de software como o CineFácil, proporcionando flexibilidade, foco na entrega de valor, envolvimento do usuário e melhoria contínua. Esses benefícios tornam o Scrum uma escolha sólida para o sucesso do projeto.

## Relação de Ambientes de Trabalho

| Ambiente | Descrição | Acesso |
| --- | --- | --- |
| Repositório GitHub   | Repositório com arquivos do projeto     | https://github.com/LucasSoaresMagalhaes/CineFacil    |
| Planner     | Planejamento de entregas de tarefas       | https://tasks.office.com/sgapucminasbr.onmicrosoft.com/pt-BR/Home/Planner#/plantaskboard?groupId=c898b2eb-f6bd-43da-bc94-35939cc944e5&planId=L0tRUXjQsE6wD9LOL5UarWQAABVA      |
| Teams   | Comunicação remota entre a equipe     | https://teams.microsoft.com/    |


## Controle de Versão

A ferramenta de controle de versão adotada no projeto foi o
[Git](https://git-scm.com/), sendo que o [Github](https://github.com)
foi utilizado para hospedagem do repositório.

O projeto segue a seguinte convenção para o nome de branches:

- `main`: versão estável já testada do software
- `unstable`: versão já testada do software, porém instável
- `testing`: versão em testes do software
- `dev`: versão de desenvolvimento do software

Quanto à gerência de issues, o projeto adota a seguinte convenção para
etiquetas:

- `documentation`: melhorias ou acréscimos à documentação
- `bug`: uma funcionalidade encontra-se com problemas
- `enhancement`: uma funcionalidade precisa ser melhorada
- `feature`: uma nova funcionalidade precisa ser introduzida

Sprint:
Uma sprint é uma unidade de tempo fixa durante a qual a equipe de desenvolvimento trabalha em um conjunto específico de tarefas. Geralmente, as sprints têm duração de duas a quatro semanas. Durante uma sprint, a equipe se concentra em concluir as tarefas definidas no backlog do sprint.

Branches do Projeto:
Para organizar o desenvolvimento de software de forma eficiente, muitas equipes usam um sistema de controle de versão, como o Git. Nesse contexto, um "branch" é uma ramificação do código principal (normalmente chamado de "master" ou "main"). Cada sprint pode iniciar com a criação de um novo branch a partir do branch principal. Esses branches são usados para desenvolver as funcionalidades ou correções específicas planejadas para aquela sprint.

Controle de Tarefas:
Dentro de um sistema de controle de tarefas (como o JIRA, Trello, ou Asana), as tarefas a serem realizadas durante a sprint são atribuídas à equipe. Cada tarefa é associada a uma funcionalidade específica ou a um problema a ser resolvido. A equipe trabalha nessas tarefas em seus branches específicos durante a sprint.

Merge com a Master:
Após a conclusão de cada tarefa ou funcionalidade, a equipe cria uma solicitação de pull request (ou merge request) para integrar as mudanças do branch da sprint de volta ao branch principal (master). Antes de fazer o merge, é comum realizar revisões de código para garantir a qualidade do código e evitar erros. Uma vez que todas as tarefas da sprint estão completas e as revisões de código foram aprovadas, o merge é realizado, e as alterações são mescladas na branch principal.

Esse processo de criação de branches da sprint, desenvolvimento de tarefas, revisões de código e merges ajuda a manter um controle rigoroso sobre o que está sendo desenvolvido em cada sprint e permite que a equipe trabalhe de forma colaborativa, mantendo a integridade do código principal. Isso também facilita a implantação de novas funcionalidades ou correções de bugs, uma vez que o código na branch principal (master) representa sempre uma versão estável e testada do software.


## Gerenciamento de Projeto

### Divisão de Papéis

- Scrum Master: Brenda Moreira Rodrigues;
- Product Owner: Lucas Soares Magalhães;
- Equipe de Desenvolvimento: Samuel Carlos da Silva;
- Equipe de Design: Victor Ribeiro de Souza.

### Processo

A implementação do Scrum no projeto CineFácil pode ser complementada pelo uso do recurso de gerenciamento de projeto oferecido pelo GitHub, o qual permite acompanhar o andamento do projeto, a execução das tarefas e o status de desenvolvimento da solução de forma mais eficaz. Aqui estão detalhes sobre como essa implementação pode ocorrer:

1. Configuração do Repositório do GitHub:

    Crie um repositório dedicado para o projeto CineFácil no GitHub, onde todo o código-fonte e recursos relacionados ao projeto serão armazenados.
    Utilize as seções de "Projetos" e "Issues" no GitHub para criar e gerenciar tarefas, funcionalidades e metas do projeto.

2. Criação de Sprints:

    Defina sprints com duração fixa (por exemplo, duas semanas) para organizar o trabalho.
    Utilize os "Projetos" do GitHub para criar painéis de sprint, onde as tarefas e histórias de usuário planejadas para a sprint atual estarão visíveis.

3. Criação de Issues:

    Crie "Issues" no GitHub para cada história de usuário, requisito funcional, requisito não funcional e tarefa técnica identificados no Backlog do Produto.
    Atribua responsáveis a cada "Issue", indicando qual membro da equipe é responsável por sua execução.

4. Priorização e Atribuição de Pontuação:

    Priorize as "Issues" no "Backlog" do GitHub com base nas necessidades e nas expectativas do usuário.
    Atribua pontos de complexidade ou estimativas de esforço a cada "Issue" usando rótulos (labels) no GitHub, como "baixa", "média" e "alta".

5. Acompanhamento e Execução:

    Durante a sprint, a equipe se concentra na execução das "Issues" planejadas para aquela sprint.
    À medida que as tarefas são concluídas, os membros da equipe podem movê-las entre as colunas do "Projetos" do GitHub, refletindo seu status atual (por exemplo, "Em Progresso", "Concluído").

6. Revisão e Testes:

    Após a conclusão das "Issues", a equipe conduz revisões internas e testes de validação para garantir que as funcionalidades estejam de acordo com as expectativas.
    Qualquer problema ou bug encontrado pode ser relatado como uma nova "Issue" para correção.

7. Revisão da Sprint:

    Ao final de cada sprint, a equipe realiza uma reunião de revisão da sprint para demonstrar as funcionalidades completas ao Product Owner.
    O Product Owner pode então revisar e aceitar as funcionalidades entregues.

8. Retrospectivas:

    Após a revisão da sprint, a equipe realiza uma retrospectiva para discutir o que funcionou bem e o que pode ser melhorado no processo de desenvolvimento.

9. Melhorias Contínuas:

    Com base no feedback recebido durante as retrospectivas, a equipe atualiza e melhora o processo de desenvolvimento, ajustando-o conforme necessário.

10. Integração com CI/CD:
- Integre o GitHub com sistemas de integração contínua e entrega contínua (CI/CD) para automatizar a compilação, testes e implantação.

A utilização do GitHub como ferramenta de gerenciamento de projeto complementa o Scrum, fornecendo uma plataforma centralizada para o acompanhamento do progresso, documentação e colaboração eficiente da equipe. Isso facilita a comunicação, a transparência e a gestão de tarefas, contribuindo para o sucesso do projeto CineFácil.

### Ferramentas

As ferramentas empregadas no projeto são:
Controle de Versão
- GitHub
- Git
Gerenciamento de Projeto
- Teams
- Planner
Ferramentas
- VsCode
- Moqups
- Nclass
- Android Studio
Tecnologias
- Kotlin
- Android SDK
- Firebase
- MongoDB

