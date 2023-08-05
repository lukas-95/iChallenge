# iChallenge 👨‍💻

## Tutorial para Executar o Projeto iChallenge

Este tutorial irá guiá-lo através dos passos necessários para executar o projeto iChallenge em sua máquina local. O iChallenge é um sistema composto por três microserviços: `iChallenge`, `person` e `notify`. Vamos executar o sistema utilizando o Docker Compose.

### Pré-requisitos

Antes de prosseguir, certifique-se de ter as seguintes ferramentas instaladas em seu sistema:

* Docker: Instruções de instalação do Docker: https://docs.docker.com/get-docker/
* Docker Compose: Instruções de instalação do Docker Compose: https://docs.docker.com/compose/install/

### Passo 1: Clonar o Repositório

Clone o repositório do iChallenge em sua máquina local. Para fazer isso, execute o seguinte comando no terminal:

```
git clone https://github.com/lukas-95/iChallenge.git
cd iChallenge
```

### Passo 2: Executar o Docker Compose

Abra um terminal na pasta do projeto onde está localizado o arquivo `docker-compose.yml`. Em seguida, execute o seguinte comando para iniciar o ambiente do Docker Compose:

```
docker-compose up -d
```

Esse comando criará e iniciará os containers do PostgreSQL e de todos os outros serviços especificados no arquivo `docker-compose.yml`.

### Passo 3: Criar as Bases de Dados

Conecte-se ao container do PostgreSQL usando o comando `psql`:

```
docker-compose exec postgres psql -U ichallenge
```

Dentro do terminal do `psql`, crie as bases de dados `person` e `notify`:

```
CREATE DATABASE person;
CREATE DATABASE notify;
\q
```

### Passo 4: Executar os Microserviços

Com as bases de dados criadas, você pode executar os microserviços `person` e `notify`. Abra dois terminais separados, um para cada serviço, e execute os seguintes comandos:

**Microserviço Person:**

```
cd person
mvn spring-boot:run
```
***Atenção*** Agora você deve abrir um **NOVO PROMPT** de comando e navegar até a pasta *iChallenge* e colar o código abaixo

**Microserviço Notify:**

```
cd notify
mvn spring-boot:run
```

### Passo 5: Testar os Microserviços

***Atenção*** Agora você deve abrir um **NOVO PROMPT** de comando e navegar até a pasta *iChallenge* e colar o código abaixo

```
mvn test
```

### Passo 6: Testar as APIs

Certifique-se de ter o Postman instalado no seu computador.

* Postman: https://www.postman.com/downloads/

Acesse o link da documentação:

* Documentação: https://documenter.getpostman.com/view/15506429/2s9XxyRtNb

Clique no botão laranja no canto superior direito ***Run in Postman***






