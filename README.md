# Executando o projeto

Execute o docker;

Abra o prompt de comando e navegue até a pasta do projeto;

Digite o seguinte comando para baixar a imagem do postgres e subir o banco:
```shell script
docker compose up
```

Abra um client de banco de dados, crie uma conexão com postgres e depois crie a tabela funcionarios conforme o script.

```shell script
CREATE TABLE public.funcionario(
	id BIGINT NOT NULL,
	cpf VARCHAR(20) NOT NULL,
	nome VARCHAR(100) NOT NULL,
	salario DECIMAL(10, 2) NOT NULL,
	PRIMARY KEY (id)
)
```

Abra outro prompt de comando e navegue até a pasta do projeto

Digite o seguinte comando para subir a aplicação: 
```shell script
mvn quarkus:dev
```

# Inserindo um funcionário
URL: http://localhost:8080/funcionarios

VERBO: POST

BODY:

```shell script
{
    "id": 1,
    "cpf": "706.197.001-49",
    "nome": "Alisson Melo Nascimento",
    "salario": 10000
}
```

# Detalhando um funcionário
URL: http://localhost:8080/funcionarios/1

VERBO: GET

# Listando todos os funcionários
URL: http://localhost:8080/funcionarios

VERBO: GET