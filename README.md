# Projeto JPA e Hibernate

Este é um projeto Java que demonstra o uso do JPA (Java Persistence API) em conjunto com o framework Hibernate para realizar operações de persistência em um banco de dados MySQL.

## Descrição

O objetivo deste projeto é para práticar como utilizar o JPA e o Hibernate para realizar operações de CRUD (Create, Read, Update, Delete) em um banco de dados MySQL. Ele inclui exemplos de entidades JPA, classes DAO (Data Access Object) para acesso ao banco de dados, e configuração do arquivo `persistence.xml`.

## Pré-requisitos

Antes de executar este projeto, certifique-se de ter o seguinte software instalado em sua máquina:

- Java Development Kit (JDK) 8 ou superior
- Maven
- MySQL Server

## Configuração do Banco de Dados

1. Crie um banco de dados MySQL vazio.
2. Atualize as configurações de conexão com o banco de dados no arquivo `src/main/resources/META-INF/persistence.xml`. Certifique-se de fornecer o URL correto do banco de dados, o nome de usuário e a senha.

Exemplo de configuração no arquivo `persistence.xml` para o MySQL:

```xml
<persistence-unit name="myPersistenceUnit">
    <properties>
        <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/nome_do_seu_banco_de_dados"/>
        <property name="javax.persistence.jdbc.user" value="seu_usuario"/>
        <property name="javax.persistence.jdbc.password" value="sua_senha"/>
        <!-- Outras propriedades... -->
    </properties>
</persistence-unit>
```

## Executando o Projeto

Para executar o projeto, siga estas etapas:

1. Clone este repositório para o seu ambiente local.
2. Importe o projeto para a sua IDE..

## Estrutura do Projeto

A estrutura de diretórios do projeto é organizada da seguinte forma:

- src/main/java/com/gustavo/: Contém os arquivos-fonte Java do projeto.
- application: Contém a classe principal para iniciar a aplicação.
- config: Contém classes de configuração, como a classe responsável por criar o EntityManagerFactory.
- dao: Contém classes de acesso a dados (DAOs).
- model/entities: Contém as classes de entidades JPA.
- src/main/resources: Contém os arquivos de configuração, como o arquivo persistence.xml.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para enviar pull requests com melhorias, correções de bugs ou novos recursos.

## Licença

Este projeto está licenciado sob a MIT License.
