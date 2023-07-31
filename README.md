## Autorizador de exames médicos

## GIT
`https://github.com/thierry-freire/autorizador_exames_medicos`
## Dependencies
- Maven
- Openjdk8+

## Execução do ambiente de desenvolvimento
1. Colocar banco MySql em memória via xampp
2. Executar os scripts localizados: 
3. `mvn clean install`
4. Utilizar tomcat v8.5

## Docker
1. 1. Colocar banco MySql em memória via xampp
2. Executar os scripts localizados: 
3. `docker build -t autorizador-exames-medicos .`
4. `docker run -p 8080:8080 autorizador-exames-medicos`

## Link Local
`http://localhost:8080/autorizador_procedimentos_medicos/`