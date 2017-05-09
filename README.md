# LogReader

Aplicação criada para análise de logs. Ainda falta deixar-la mais genérica para a inclusão de novos formatos de logs serem mais fáceis.
A princípio a aplicação está preparada para analisar logs onde as linhas contenham a informação **request_to="<url>"** e **response_status="<code_status>"**.

Uma vez que estas informações são processadas, são adicionadas em um banco em memória, no caso o H2, e extraído relatórios analitícos do mesmo.

## Como utilizar
Rodar o projeto é feito em SpringBoot ou tendo posse do **.jar** basta rodar o mesmo utilizando o comando:
```sh
java -jar LogReader-0.0.1.jar
```
Após a inicialização com sucesso do projeto acesse a url http://localhost:8080 para ter acesso ao sistema.
Na tela você verá um botão para fazer upload do seu arquivo de log. O arquivo será processado e em seguida será exibido as estatísticas do mesmo.

## Estatísticas
As estatísticas sobre o log que são exibidas até o momento são as três URLs da tag request_to mais frequentes e a quantidade de vezes que estas aparecem. Também são exibidos todos os reponse status (código http) que estão presentes na tag response_status e a quantidade de vezes que cada uma aparece.

## Tecnologias utilizadas
O projeto é desenvolvido com SpringBoot, SpringData para a manipulação do banco de dados, banco de dados em memória H2, Spring MVC e Thymeleaf para a criação da interface.
