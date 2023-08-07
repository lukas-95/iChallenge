# iChallenge 👨‍💻

## Tutorial para Executar o Projeto iChallenge

Este tutorial irá guiá-lo através dos passos necessários para executar o projeto iChallenge em sua máquina local.
O iChallenge é um sistema composto por dois microserviços: `person` e `notify`. Vamos executar o sistema utilizando o Docker Compose.

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

## Desenho Arquitetural do Projeto iChallenge

![Projeto Lucas iChallenge](https://github.com/lukas-95/iChallenge/assets/83048854/f570d9ee-ff5b-41c9-9a28-36eb74afa189)
<!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN" "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd">
<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" width="1382px" height="561px" viewBox="-0.5 -0.5 1382 561" content="&lt;mxfile host=&quot;Electron&quot; modified=&quot;2023-08-07T01:03:58.024Z&quot; agent=&quot;Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) draw.io/21.6.5 Chrome/114.0.5735.243 Electron/25.3.1 Safari/537.36&quot; etag=&quot;GH14MfhOcDMfbvZq525i&quot; version=&quot;21.6.5&quot; type=&quot;device&quot;&gt;&lt;diagram name=&quot;Página-1&quot; id=&quot;8iJttOCfmaQnAPLVJEfL&quot;&gt;7VpNd6IwFP01Lp1D+NIuW+u0c07b6RkX7SwjpJAKhIZQtb9+ggQQg1RbLZkZVyaPJIR7X+57D+kZo3BxRWHs3xIXBT1dcxc947Kn68C2Lf6TWZa5xbYGucGj2BWDKsMEvyFh1IQ1xS5KagMZIQHDcd3okChCDqvZIKVkXh/2RIL6XWPoIckwcWAgWx+wy/zcOtQHlf0aYc8v7gzss/xKCIvB4kkSH7pkvmYyxj1jRAlheStcjFCQgVfgks/7vuVquTGKIrbLhDi07evH5MJ6enGe8fiWLNxFX6zyCoNUPDAe+TAIUMRhybfNlgUWyRyHAYx472LuY4YmMXSyS3NOPbf5LAx4D/CmvLfiRogytFgzib1eIRIiRpd8iLjaNwVuy8IhRH9e0WDbwuavUWAVRiio98q1K3R4QwC0B1hDCRHkcmcRXUKZTzwSwWBcWS8oSSMXZatqvFeNuSEkFmA9I8aWwvNhykgdSo4gXT5m879ZRff3+rXLhVg87y3Xe/eIYv7siAqjzEubVyQkpQ5qGaeLAwmph9rWE4clQ6uVeooCyPBr/egdnEbdPPH4MR51Qy0iJfEKk35EGH7CDr89ifoOCWOSYEaoRHlFKPiInrWq6c4iB6wNkbNkkQN6g8gdTeN0u4vDcWB/Nnb1Z0spfzaa/DlGNGn35Hd8t+7oX+XJht61J5+ppPKaAipv/ZXRGoBOeQQ1FitSt/DYEWWdxeWRryW/4N29Zb693Jm69+P8cVbs5nTyWmhsBA4odfKsd9OrBHHOaB+6MM6wUzIwWZpqKdZAwvUlRSlqglaCNPFhnDWdZYCzAcb7ues0h/lmWhqgM/NW4P9MGV8GCXuSHy1grbhhq33w/tn+B2J3dgy7zo7ZUOQ3cDM8FjegY+3qNNqAnetApXQKtNfzKJiS+X9Nl1pVe7HtNf27ggzNIV/aDlgmUFz3bC9rzUjk9XHkUZQkEsl1Hjuq4I2N6GLIAmY2CJihHa2Al6vIqVuLLZ0FlWNxAAZqBRFdzpw4BXkh/++BP9wAv+EEHAv9tiR6u/93nVsdiwlrQ4uML2Si+Qk0iQoefGcZ9NrkdiIT8JX/L5V/4bUot641wKUfTbqBrBslXg8+ZHII7BQxY2h1jpi9HbFxCHHQLWIAmEA5yIbbIYvTxFcMMRWOZcdvkj9bZBz6ZWMh64rUE+X3FSd6alFEFXq6fX+vHj3DQ9OzmnpOaVZAlwNigqM8YRAr32eGtWRR30gWzY2vhzbGA23wyQlFqVw5U77nyrXKh/+Et+knb2tKkFTzNmtfb9t3gikyrQ96G+9WX+blw6vvG43xHw==&lt;/diagram&gt;&lt;/mxfile&gt;" style="background-color: rgb(24, 20, 29);"><defs/><g><path d="M 0 23 L 0 0 L 660 0 L 660 23" fill="rgb(24, 20, 29)" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="all"/><path d="M 0 23 L 0 560 L 660 560 L 660 23" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 0 23 L 660 23" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><g transform="translate(-0.5 -0.5)"><switch><foreignObject pointer-events="none" width="100%" height="100%" requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility" style="overflow: visible; text-align: left;"><div xmlns="http://www.w3.org/1999/xhtml" style="display: flex; align-items: unsafe center; justify-content: unsafe center; width: 658px; height: 1px; padding-top: 12px; margin-left: 1px;"><div data-drawio-colors="color: rgb(240, 240, 240); " style="box-sizing: border-box; font-size: 0px; text-align: center;"><div style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(240, 240, 240); line-height: 1.2; pointer-events: none; font-weight: bold; white-space: normal; overflow-wrap: normal;"></div></div></div></foreignObject></switch></g><path d="M 270 180 L 310 180 L 310 80 L 343.63 80" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 348.88 80 L 341.88 83.5 L 343.63 80 L 341.88 76.5 Z" fill="rgb(240, 240, 240)" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 210 150 L 210 130 L 200 130 L 200 126.37" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 200 121.12 L 203.5 128.12 L 200 126.37 L 196.5 128.12 Z" fill="rgb(240, 240, 240)" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><rect x="150" y="150" width="120" height="60" rx="9" ry="9" fill="rgb(24, 20, 29)" stroke="rgb(240, 240, 240)" pointer-events="none"/><g transform="translate(-0.5 -0.5)"><switch><foreignObject pointer-events="none" width="100%" height="100%" requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility" style="overflow: visible; text-align: left;"><div xmlns="http://www.w3.org/1999/xhtml" style="display: flex; align-items: unsafe center; justify-content: unsafe center; width: 118px; height: 1px; padding-top: 180px; margin-left: 151px;"><div data-drawio-colors="color: rgb(240, 240, 240); " style="box-sizing: border-box; font-size: 0px; text-align: center;"><div style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(240, 240, 240); line-height: 1.2; pointer-events: none; white-space: normal; overflow-wrap: normal;"></div></div></div></foreignObject></switch></g><path d="M 210 380 L 210 423.63" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 210 428.88 L 206.5 421.88 L 210 423.63 L 213.5 421.88 Z" fill="rgb(240, 240, 240)" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><rect x="150" y="320" width="120" height="60" rx="9" ry="9" fill="rgb(24, 20, 29)" stroke="rgb(240, 240, 240)" pointer-events="none"/><g transform="translate(-0.5 -0.5)"><switch><foreignObject pointer-events="none" width="100%" height="100%" requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility" style="overflow: visible; text-align: left;"><div xmlns="http://www.w3.org/1999/xhtml" style="display: flex; align-items: unsafe center; justify-content: unsafe center; width: 118px; height: 1px; padding-top: 350px; margin-left: 151px;"><div data-drawio-colors="color: rgb(240, 240, 240); " style="box-sizing: border-box; font-size: 0px; text-align: center;"><div style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(240, 240, 240); line-height: 1.2; pointer-events: none; white-space: normal; overflow-wrap: normal;"></div></div></div></foreignObject></switch></g><path d="M 500 180 L 465 180 L 465 80 L 436.37 80" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 431.12 80 L 438.12 76.5 L 436.37 80 L 438.12 83.5 Z" fill="rgb(240, 240, 240)" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 500 180 L 385 180 L 385 350 L 276.37 350" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 271.12 350 L 278.12 346.5 L 276.37 350 L 278.12 353.5 Z" fill="rgb(240, 240, 240)" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 560 210 L 560 323.63" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 560 328.88 L 556.5 321.88 L 560 323.63 L 563.5 321.88 Z" fill="rgb(240, 240, 240)" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><rect x="500" y="150" width="120" height="60" rx="9" ry="9" fill="rgb(24, 20, 29)" stroke="rgb(240, 240, 240)" pointer-events="none"/><g transform="translate(-0.5 -0.5)"><switch><foreignObject pointer-events="none" width="100%" height="100%" requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility" style="overflow: visible; text-align: left;"><div xmlns="http://www.w3.org/1999/xhtml" style="display: flex; align-items: unsafe center; justify-content: unsafe center; width: 118px; height: 1px; padding-top: 180px; margin-left: 501px;"><div data-drawio-colors="color: rgb(240, 240, 240); " style="box-sizing: border-box; font-size: 0px; text-align: center;"><div style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(240, 240, 240); line-height: 1.2; pointer-events: none; white-space: normal; overflow-wrap: normal;"></div></div></div></foreignObject></switch></g><path d="M 360 55 C 360 46.72 373.43 40 390 40 C 397.96 40 405.59 41.58 411.21 44.39 C 416.84 47.21 420 51.02 420 55 L 420 105 C 420 113.28 406.57 120 390 120 C 373.43 120 360 113.28 360 105 Z" fill="rgb(24, 20, 29)" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" transform="rotate(90,390,80)" pointer-events="none"/><path d="M 420 55 C 420 63.28 406.57 70 390 70 C 373.43 70 360 63.28 360 55" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" transform="rotate(90,390,80)" pointer-events="none"/><g transform="translate(-0.5 -0.5)rotate(90 377.5 80)"><switch><foreignObject pointer-events="none" width="100%" height="100%" requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility" style="overflow: visible; text-align: left;"><div xmlns="http://www.w3.org/1999/xhtml" style="display: flex; align-items: unsafe center; justify-content: unsafe center; width: 58px; height: 1px; padding-top: 80px; margin-left: 349px;"><div data-drawio-colors="color: rgb(240, 240, 240); " style="box-sizing: border-box; font-size: 0px; text-align: center;"><div style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(240, 240, 240); line-height: 1.2; pointer-events: none; white-space: normal; overflow-wrap: normal;"></div></div></div></foreignObject></switch></g><path d="M 70 280 L 110 280 L 110 180 L 143.63 180" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 148.88 180 L 141.88 183.5 L 143.63 180 L 141.88 176.5 Z" fill="rgb(240, 240, 240)" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 70 280 L 110 280 L 110 350 L 143.63 350" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 148.88 350 L 141.88 353.5 L 143.63 350 L 141.88 346.5 Z" fill="rgb(240, 240, 240)" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><rect x="30" y="130" width="40" height="300" fill="rgb(24, 20, 29)" stroke="rgb(240, 240, 240)" pointer-events="none"/><g transform="translate(-0.5 -0.5)"><switch><foreignObject pointer-events="none" width="100%" height="100%" requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility" style="overflow: visible; text-align: left;"><div xmlns="http://www.w3.org/1999/xhtml" style="display: flex; align-items: unsafe center; justify-content: unsafe center; width: 38px; height: 1px; padding-top: 280px; margin-left: 31px;"><div data-drawio-colors="color: rgb(240, 240, 240); " style="box-sizing: border-box; font-size: 0px; text-align: center;"><div style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(240, 240, 240); line-height: 1.2; pointer-events: none; white-space: normal; overflow-wrap: normal;"><br /></div></div></div></foreignObject></switch></g><path d="M 170 55 C 170 46.72 183.43 40 200 40 C 207.96 40 215.59 41.58 221.21 44.39 C 226.84 47.21 230 51.02 230 55 L 230 105 C 230 113.28 216.57 120 200 120 C 183.43 120 170 113.28 170 105 Z" fill="rgb(24, 20, 29)" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 230 55 C 230 63.28 216.57 70 200 70 C 183.43 70 170 63.28 170 55" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><g transform="translate(-0.5 -0.5)"><switch><foreignObject pointer-events="none" width="100%" height="100%" requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility" style="overflow: visible; text-align: left;"><div xmlns="http://www.w3.org/1999/xhtml" style="display: flex; align-items: unsafe center; justify-content: unsafe center; width: 58px; height: 1px; padding-top: 93px; margin-left: 171px;"><div data-drawio-colors="color: rgb(240, 240, 240); " style="box-sizing: border-box; font-size: 0px; text-align: center;"><div style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(240, 240, 240); line-height: 1.2; pointer-events: none; white-space: normal; overflow-wrap: normal;"></div></div></div></foreignObject></switch></g><path d="M 180 445 C 180 436.72 193.43 430 210 430 C 217.96 430 225.59 431.58 231.21 434.39 C 236.84 437.21 240 441.02 240 445 L 240 495 C 240 503.28 226.57 510 210 510 C 193.43 510 180 503.28 180 495 Z" fill="rgb(24, 20, 29)" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 240 445 C 240 453.28 226.57 460 210 460 C 193.43 460 180 453.28 180 445" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><g transform="translate(-0.5 -0.5)"><switch><foreignObject pointer-events="none" width="100%" height="100%" requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility" style="overflow: visible; text-align: left;"><div xmlns="http://www.w3.org/1999/xhtml" style="display: flex; align-items: unsafe center; justify-content: unsafe center; width: 58px; height: 1px; padding-top: 483px; margin-left: 181px;"><div data-drawio-colors="color: rgb(240, 240, 240); " style="box-sizing: border-box; font-size: 0px; text-align: center;"><div style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(240, 240, 240); line-height: 1.2; pointer-events: none; white-space: normal; overflow-wrap: normal;"></div></div></div></foreignObject></switch></g><path d="M 530 345 C 530 336.72 543.43 330 560 330 C 567.96 330 575.59 331.58 581.21 334.39 C 586.84 337.21 590 341.02 590 345 L 590 395 C 590 403.28 576.57 410 560 410 C 543.43 410 530 403.28 530 395 Z" fill="rgb(24, 20, 29)" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 590 345 C 590 353.28 576.57 360 560 360 C 543.43 360 530 353.28 530 345" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><g transform="translate(-0.5 -0.5)"><switch><foreignObject pointer-events="none" width="100%" height="100%" requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility" style="overflow: visible; text-align: left;"><div xmlns="http://www.w3.org/1999/xhtml" style="display: flex; align-items: unsafe center; justify-content: unsafe center; width: 58px; height: 1px; padding-top: 383px; margin-left: 531px;"><div data-drawio-colors="color: rgb(240, 240, 240); " style="box-sizing: border-box; font-size: 0px; text-align: center;"><div style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(240, 240, 240); line-height: 1.2; pointer-events: none; white-space: normal; overflow-wrap: normal;"></div></div></div></foreignObject></switch></g><path d="M 867 53 L 867 30 L 1067 30 L 1067 53" fill="rgb(24, 20, 29)" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 867 53 L 867 230 L 1067 230 L 1067 53" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 867 53 L 1067 53" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><g transform="translate(-0.5 -0.5)"><switch><foreignObject pointer-events="none" width="100%" height="100%" requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility" style="overflow: visible; text-align: left;"><div xmlns="http://www.w3.org/1999/xhtml" style="display: flex; align-items: unsafe center; justify-content: unsafe center; width: 198px; height: 1px; padding-top: 42px; margin-left: 868px;"><div data-drawio-colors="color: rgb(240, 240, 240); " style="box-sizing: border-box; font-size: 0px; text-align: center;"><div style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(240, 240, 240); line-height: 1.2; pointer-events: none; font-weight: bold; white-space: normal; overflow-wrap: normal;"> </div></div></div></foreignObject></switch></g><path d="M 867 308 L 867 285 L 1067 285 L 1067 308" fill="rgb(24, 20, 29)" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 867 308 L 867 485 L 1067 485 L 1067 308" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 867 308 L 1067 308" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><g transform="translate(-0.5 -0.5)"><switch><foreignObject pointer-events="none" width="100%" height="100%" requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility" style="overflow: visible; text-align: left;"><div xmlns="http://www.w3.org/1999/xhtml" style="display: flex; align-items: unsafe center; justify-content: unsafe center; width: 198px; height: 1px; padding-top: 297px; margin-left: 868px;"><div data-drawio-colors="color: rgb(240, 240, 240); " style="box-sizing: border-box; font-size: 0px; text-align: center;"><div style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(240, 240, 240); line-height: 1.2; pointer-events: none; font-weight: bold; white-space: normal; overflow-wrap: normal;"></div></div></div></foreignObject></switch></g><path d="M 1181 308 L 1181 285 L 1381 285 L 1381 308" fill="rgb(24, 20, 29)" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 1181 308 L 1181 485 L 1381 485 L 1381 308" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 1181 308 L 1381 308" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><g transform="translate(-0.5 -0.5)"><switch><foreignObject pointer-events="none" width="100%" height="100%" requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility" style="overflow: visible; text-align: left;"><div xmlns="http://www.w3.org/1999/xhtml" style="display: flex; align-items: unsafe center; justify-content: unsafe center; width: 198px; height: 1px; padding-top: 297px; margin-left: 1182px;"><div data-drawio-colors="color: rgb(240, 240, 240); " style="box-sizing: border-box; font-size: 0px; text-align: center;"><div style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(240, 240, 240); line-height: 1.2; pointer-events: none; font-weight: bold; white-space: normal; overflow-wrap: normal;"></div></div></div></foreignObject></switch></g><path d="M 1181 53 L 1181 30 L 1381 30 L 1381 53" fill="rgb(24, 20, 29)" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 1181 53 L 1181 230 L 1381 230 L 1381 53" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 1181 53 L 1381 53" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><g transform="translate(-0.5 -0.5)"><switch><foreignObject pointer-events="none" width="100%" height="100%" requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility" style="overflow: visible; text-align: left;"><div xmlns="http://www.w3.org/1999/xhtml" style="display: flex; align-items: unsafe center; justify-content: unsafe center; width: 198px; height: 1px; padding-top: 42px; margin-left: 1182px;"><div data-drawio-colors="color: rgb(240, 240, 240); " style="box-sizing: border-box; font-size: 0px; text-align: center;"><div style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(240, 240, 240); line-height: 1.2; pointer-events: none; font-weight: bold; white-space: normal; overflow-wrap: normal;"></div></div></div></foreignObject></switch></g><path d="M 620 180 L 743.5 180 L 743.5 130 L 860.63 130" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 865.88 130 L 858.88 133.5 L 860.63 130 L 858.88 126.5 Z" fill="rgb(240, 240, 240)" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 620 180 L 743.5 180 L 743.5 385 L 860.63 385" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 865.88 385 L 858.88 388.5 L 860.63 385 L 858.88 381.5 Z" fill="rgb(240, 240, 240)" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 560 210 L 560 240 L 1110 240 L 1110 130 L 1174.63 130" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 1179.88 130 L 1172.88 133.5 L 1174.63 130 L 1172.88 126.5 Z" fill="rgb(240, 240, 240)" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 560 210 L 560 250 L 1110 250 L 1110 385 L 1174.63 385" fill="none" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/><path d="M 1179.88 385 L 1172.88 388.5 L 1174.63 385 L 1172.88 381.5 Z" fill="rgb(240, 240, 240)" stroke="rgb(240, 240, 240)" stroke-miterlimit="10" pointer-events="none"/></g><switch><g requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility"/><a transform="translate(0,-5)" xlink:href="https://www.drawio.com/doc/faq/svg-export-text-problems" target="_blank"><text text-anchor="middle" font-size="10px" x="50%" y="100%">


