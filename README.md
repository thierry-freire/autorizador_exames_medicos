## Autorizador de exames médicos
Sistema de autorização de procedimentos médicos

## GIT
`https://github.com/thierry-freire/autorizador_exames_medicos`
## Dependencies
- Maven
- Openjdk8+
- Tomcat v8.5

## Execução do ambiente de desenvolvimento
1. Colocar banco MySql em memória via xampp
2. Executar os scripts localizados: 
3. `mvn clean install`

## Docker
1. Colocar banco MySql em memória via xampp
2. `mvn liquibase:update` 
3. `docker build -t autorizador-exames-medicos .`
4. `docker run -p 8080:8080 autorizador-exames-medicos`

## Link Local
`http://localhost:8080/autorizador_procedimentos_medicos/`