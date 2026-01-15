# 📔 Agenda de Contatos - Java CRUD

Sistema de gerenciamento de contatos desenvolvido em Java para praticar a persistência de dados em banco de dados **MySQL**, utilizando o padrão **DAO (Data Access Object)**.
## 🚀 Como utilizar a aplicação

1. **Banco de Dados:**
    - Certifique-se de ter o MySQL instalado.
    - Crie um banco de dados chamado `agenda`.
    - Crie a tabela necessária:

``` SQL
CREATE TABLE contatos (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(40),
	idade INT,
	dataCadastro DATE
);
```

2. **Configuração da Conexão:**
    - Vá em `src/br/com/agenda/factory/ConnectionFactory.java`.
    - Ajuste o `USERNAME` e `PASSWORD` de acordo com as suas configurações do MySQL.

3. **Execução:**
    - Importe o projeto em sua IDE (IntelliJ, Eclipse ou VS Code).
    - Adicione o driver `mysql-connector-j-9.4.0.jar` (localizado na pasta de bibliotecas) ao Path do projeto.
    - Execute a classe `Main.java` em `br.com.agenda.aplicacao`.
## 📁 Estrutura de Pastas

O projeto está organizado da seguinte forma para garantir a separação de responsabilidades:

```
crud-agenda-java/
├── README.md
├── .gitignore
│
├── src/
│   └── br/
│       └── com/
│           └── agenda/
│               ├── dao/
│               │   └── ContatoDAO.java
│               │
│               ├── factory/
│               │   └── ConnectionFactory.java
│               │
│               ├── models/
│               │   └── Contato.java
│               │
│               └── Main.java
``` 

---

### 🛠 Tecnologias Utilizadas

- **Java** (JDK)
- **MySQL** (Banco de dados)
- **JDBC** (Java Database Connectivity)
- **IntelliJ IDEA** (Ambiente de desenvolvimento)
