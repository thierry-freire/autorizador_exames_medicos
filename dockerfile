FROM tomcat:8.5.85

COPY target/autorizador_procedimentos_medicos.war /usr/local/tomcat/webapps/
