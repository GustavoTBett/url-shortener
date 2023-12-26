# Encurtador de URL

<!-- SOBRE O PROJETO -->
## SOBRE O PROJETO

Encurtador de URL utilizando Java, Spring Boot e JPA, para aprendizado. 

Você manda a URL desejada para ser encurtada, e o programa te devolve um código verificando a validade no banco de dados. 

```
  Exemplo (request body):
  url: https://github.com/GustavoTBett
  
  Retorno:
  "den8fk46al"
```

Mandando esse código na url localhost:8080/find/den8fk46al - Você é redirecionado automaticamente para o link https://github.com/GustavoTBett

Tecnologias utilizadas:
* Java
* JPA
* Hibernate
* Lombok
* Postgresql
* Junit

<!-- GETTING STARTED -->
## Instalação

### Pré requisitos

* Insomnia/Postman/Google Chrome ( Para testar os endpoints ) 

* Alguma IDE que rode Java como Eclipse, Netbeans, Intellij... 

* Postgresql


### Instalação

1. Pegue o link do repositório https://github.com/GustavoTBett/url-shortener.git
2. Clone o repo
   ```sh
   git clone https://github.com/GustavoTBett/url-shortener.git
   ```
3. Abra o projeto em sua IDE de prefêrencia

4. Configure o arquivo application.properties alterando o usuario e senha (Utilize o seu usuário e senha do Postgresql), quando o projeto for executado ele se encarregará de criar a tabela e suas colunas no banco de dados

5. Na IDE execute o arquivo UrlApplication

6. No insomnia teste os endpoins no localhost:8080

```
    Exemplo de JSON (request body):
    {
    "url": "https://github.com/GustavoTBett"
    }
 ```

   ```JS
   POST /url - para criar a url encurtada
   
   GET /find/{códigoDaUrlEncurtada} - Redireciona para o link da página vinculado com o código gerado na hora de enviar a URL
   
   GET /url/{id} - Redireciona para o link da página vinculado com o ID
   ```
