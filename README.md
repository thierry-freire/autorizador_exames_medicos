## Autorizador de exames médicos
Sistema de autorização de procedimentos médicos

## GIT
`https://github.com/thierry-freire/autorizador_exames_medicos`
## Dependencies
- Maven
- Openjdk8+
- Tomcat v8.5

## Execução do ambiente de desenvolvimento via eclipse
1. `mvn liquibase:update` 
2. `mvn clean install`
3. `subir tomcat 8.5.85`

## Docker

## Subir MySQL
1. `docker pull mysql:latest`
2. `docker run -d -p 3306:3306 --name mysql-container -e MYSQL_ROOT_PASSWORD=admin mysql:latest`
3. `docker exec -it mysql-container bash` e digite a senha admin
4. `mysql -u root -p`

## Executar estes comandos indepentente de onde o banco for executado
1. `CREATE DATABASE zitrus;`
2. `CREATE USER 'admin'@'%' IDENTIFIED BY 'admin';`
3. `GRANT ALL PRIVILEGES ON zitrus.* TO 'admin'@'%';`

## Subir Aplicação
1. `docker build -t autorizador-exames-medicos .`
2. `docker run -p 8080:8080 autorizador-exames-medicos`

## Link Local
`http://localhost:8080/autorizador_procedimentos_medicos/`