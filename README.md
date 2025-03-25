# CSV-JAVA-APS
Um programa de acesso para uma faculdade que permite ao usuário adicionar alunos com seus respectivos nomes e IDs, cursos com seus nomes e IDs, e suas relações, como notas, substitutivas e exames. Todas as informações serão armazenadas em um arquivo CSV, que funcionará como um banco de dados no formato Excel.
# Gerenciador de Alunos e Cursos

Este projeto é um sistema de gerenciamento de alunos e cursos utilizando a linguagem Java. O armazenamento dos dados é feito em arquivos CSV, e a interação com o usuário ocorre via terminal.

## Estrutura do Projeto

A estrutura de diretórios do projeto é organizada da seguinte forma:

```
📂 Aps_java-main/src
│── 📂 view/terminal
│   ├── ViewTerminal.java
    ├── ViewTerminal.class
│
│── 📂 controller
│   ├── Controller.java
│   ├── Controller.class
│   ├── package-info.java
│   ├── package-info.class
│
│── 📂 dao/csv
│   ├── DaoCSV.java
│
│── 📂 entidades
│   ├── Aluno.java
│   ├── Aluno.class
│   ├── Curso.java
│   ├── Curso.class
│   ├── Relacao.java
│   ├── Relacao.class
│   ├── Rendimento.java
│   ├── Rendimento.class
│
│── 📂 dados
│   ├── alunos.csv
│   ├── cursos.csv
│   ├── relacao.csv
```

## Funcionalidades

O sistema permite a gestão de alunos, cursos e relações entre eles. As principais funcionalidades incluem:

### Gerenciamento de Alunos
- Adicionar um novo aluno
- Listar todos os alunos
- Buscar um aluno pelo nome
- Buscar um aluno pelo ID
- Remover um aluno pelo ID

### Gerenciamento de Cursos
- Adicionar um novo curso
- Listar todos os cursos
- Buscar um curso pelo nome
- Buscar um curso pelo ID
- Buscar um curso pelo ano
- Remover um curso pelo ID

### Gerenciamento de Relações
- Adicionar uma relação entre aluno e curso
- Listar todas as relações
- Buscar uma relação pelo ID
- Buscar relações por ID do aluno
- Buscar relações por ID do curso
- Remover uma relação pelo ID


## Dependências
Este projeto não utiliza bibliotecas externas, apenas as bibliotecas padrão do Java.

## Autor
Desenvolvido pelo grupo de Trabalho semestral de Análise e Projeto de Sistemas.

---

Caso tenha alguma dúvida ou queira contribuir com o projeto, sinta-se à vontade para entrar em contato!

