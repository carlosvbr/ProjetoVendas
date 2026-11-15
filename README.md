# ProjetoVendas

Projeto acadêmico da disciplina de Implementação Orientada aos Objetos, desenvolvido com Java, JavaScript, HTML e CSS, implementando operações CRUD em um banco de dados relacional. Estruturado em arquitetura MVC com uso de DAO.

## Escopo

Desenvolver uma aplicação web para o gerenciamento de vendas realizando operações de CRUD (inserir, deletar, atualizar, consultar por id e consultar todos), composta por 10 atributos.

### Atributos da entidade Venda

| Atributo | Tipo | Descrição |
| --- | --- | --- |
| `id` | `int` | Identificador da venda |
| `dataVenda` | `LocalDate` | Data em que a venda foi realizada |
| `valorTotal` | `double` | Valor total da venda |
| `formaPagamento` | `String` | Forma de pagamento utilizada |
| `descontoAplicado` | `double` | Desconto concedido |
| `statusVenda` | `String` | Situação atual da venda |
| `imposto` | `double` | Valor de imposto |
| `enderecoEntrega` | `String` | Endereço de entrega |
| `frete` | `double` | Valor do frete |
| `itemVendido` | `String` | Item vendido |

## Stack Tecnológico

### Frontend

- JSP
- HTML, CSS e JavaScript
- Bootstrap 4

### Backend

- Java 11
- Java EE 8 (Servlets)

### Banco de Dados

- PostgreSQL (JDBC)

### Ferramentas

- Apache Tomcat
- NetBeans (build com Ant)
- Git
- GitHub

## Arquitetura

O projeto utiliza a arquitetura **MVC (Model-View-Controller)**, com o acesso ao banco de dados isolado em uma camada **DAO (Data Access Object)**.

- **Model:** `ModeloVendas` representa a entidade Venda e encapsula seus atributos, acessados por getters e setters.
- **View:** as páginas JSP exibem os formulários e os resultados das operações.
- **Controller:** o `VendasServlet` recebe as requisições e, a partir do parâmetro `operacao`, aciona o método correspondente do DAO.
- **DAO:** o `VendasDAO` concentra todo o SQL da aplicação, de modo que as demais camadas não acessam o banco diretamente.

### Estrutura do projeto

```
ProjetoVendas/
└── ProjetoVendas/
    ├── src/java/
    │   ├── modelo/
    │   │   └── ModeloVendas.java      # Entidade Venda (Model)
    │   ├── controle/
    │   │   └── VendasServlet.java     # Recebe as requisições e direciona cada operação (Controller)
    │   ├── dao/
    │   │   └── VendasDAO.java         # Operações de CRUD no banco de dados
    │   ├── util/
    │   │   └── FabricaConexao.java    # Criação das conexões com o PostgreSQL
    │   └── teste/                     # Testes de cada operação do DAO
    ├── web/                           # Páginas JSP (View)
    │   ├── index.jsp                  # Página inicial
    │   ├── cadastrar_venda.jsp        # Inserção
    │   ├── consultar_venda.jsp        # Consulta por ID e consulta de todos
    │   ├── atualizar_venda.jsp        # Atualização
    │   └── excluir_venda.jsp          # Exclusão
    └── build.xml                      # Script de build (Ant)
```

## Segurança

Todas as consultas ao banco utilizam `PreparedStatement`, que trata os dados informados pelo usuário como parâmetros, e não como parte do comando SQL, prevenindo ataques de **SQL Injection**.

## Como executar

### Pré-requisitos

- JDK 11 ou superior
- Apache Tomcat 9
- PostgreSQL
- NetBeans
- Driver JDBC do PostgreSQL

### 1. Clonar o repositório

```bash
git clone https://github.com/carlosvbr/ProjetoVendas.git
cd ProjetoVendas
```

### 2. Criar o banco de dados

No PostgreSQL, crie um banco de dados e execute o script abaixo para criar a tabela:

```sql
CREATE TABLE vendas (
    id                 INTEGER PRIMARY KEY,
    data_venda         DATE NOT NULL,
    valor_total        NUMERIC(10, 2) NOT NULL,
    forma_pagamento    VARCHAR(50),
    desconto_aplicado  NUMERIC(10, 2),
    status_venda       VARCHAR(30),
    imposto            NUMERIC(10, 2),
    endereco_entrega   VARCHAR(255),
    frete              NUMERIC(10, 2),
    item_vendido       VARCHAR(100)
);
```

### 3. Configurar a conexão

Em `ProjetoVendas/src/java/util/FabricaConexao.java`, substitua os valores de exemplo pelos dados do seu banco:

```java
private static final String URL = "jdbc:postgresql://localhost:5432/nome_do_banco";
private static final String USER = "seu_usuario";
private static final String PASSWORD = "sua_senha";
```

### 4. Executar a aplicação

1. Abra a pasta `ProjetoVendas/ProjetoVendas` no NetBeans.
2. Adicione o driver JDBC do PostgreSQL às bibliotecas do projeto.
3. Configure o Apache Tomcat como servidor do projeto.
4. Execute o projeto (**Run**).

### 5. Acessar o sistema

| Página | Endereço |
| --- | --- |
| Página inicial | http://localhost:8080/ProjetoVendas/ |

## Testes

O pacote `teste` contém uma classe para cada operação, que pode ser executada individualmente pelo NetBeans para validar a conexão e o funcionamento do DAO:

| Classe | O que testa |
| --- | --- |
| `TesteConexao` | Conexão com o banco de dados |
| `TesteInsercao` | Inserção de uma venda |
| `TesteConsultaPorId` | Consulta de uma venda pelo ID |
| `TesteConsultarTodos` | Consulta de todas as vendas |
| `TesteAtualizacao` | Atualização de uma venda |
| `TesteExclusao` | Exclusão de uma venda |

# Desenvolvedor

- Carlos Vinicius Borba Ribeiro
