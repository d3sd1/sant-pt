# Requisitos
## En caso de correr directamente en host:
- Java 17
- Maven
- NPM
- Node 20

## En caso de virtualizar:
- Docker, si se escoge esa opción no se necesita ni java ni maven

# Como ejecutar (e instalar dependencias iniciales), asumiendo sistema unix (adaptar a windows si es el caso)
## En host plano:
cd backend
mvn i
mvn spring-boot:run
cd ../frontend
npm i
npm run start

## Con docker:
docker-compose up



# Consideraciones
- No se agregan comentarios dado que el codigo es auto descriptivo, salvo para required reminder ya que es una funcionalidad menos comun
- Se usa lombok para evitar boilerplate code
- Se usan DTO a fin de garantizar la integridad de la app
- no se agregan comentarios ya que dificultan mantener el codigo
- no se agrega fichero openapi/swagger. en su lugar se agrega swagger-ui. Los ficheros openapi son recomendables con "autogen" de manera que se generan los contratos de intercambio de informacion y solo se debe manejar la logica del controlador. dada la simplicidad de la prueba, se obvia esta parte
- la validacion de datos se realiza por spring validation y spring rest
- la gestion de errores se realiza por la capa advisor, a fin de aunar los errores y estandarizarlos. try catch en el controlador es mala praxis.
- no se usa autowired, sino inyeccion por constructor ya que permite usar constantes, mas rapido, mejor integridad de datos.
- no se utilizan smart commits para el repositorio y apenas se realizan commit. no es buena praxis, pero dado que no es el objeto de la prueba, no he puesto mucho enfasis
- no se agrega ci/cd por limitacion de tiempo
- no se agrega reporte de sonarqube por limitacion de tiempo
- se agrega mapstruct para realizar el mapping dto/entidad automatico
- se utiliza spring jpa con h2 para no tener dependencias de bbdd. se utiliza la estrategia automatica para no saturar de trabajo, no obstante lo suyo seria utilizar liquibase para la versionizacion de la bbdd
- para logear info se utiliza la dependencia @Slf4j automatizada. en los logs nunca se ponen variables para evitar hacking por trazas.
- para los tests iba a utilizar mockito pero no hizo falta
- se prueba solo la capa controller ya que esta hereda los servicios etc. y los prueba a la vez. menos tests con misma cobertura siempre es mejor. se entrega el proyecto con un >80% de cobertura (escaneado por sonarqube en local)
- se prueba un caso limite de cada, no tiene sentido lanzar todas las pruebas de codeforces ya que muchas son del mismo tipo (numeros pequeños, mismos corner case...).
- en el front no se agregan pruebas por falta de tiempo, pero si es necesario se pueden implemenbtar sin problema si se solicita
- en el front no se agrega estilo por falta de tiempo, no tiene que quedar bonito sino funcionar. si es un problema, se puede poner mas "bonito" (que es algo relativo)
- el front pretende ser simple y un extra... es cutre salchichero, pero muestra lo que tiene que mostrar
- NO SE IMPLEMENTA AUTH por tiempo. no lo considero necesario y esto podria implementarse en directo (que asi se demuestran mas cosas). se podria hacer plano con un jwt, con un oauth como keycloack, centralizado como ldap, etc....

# Como acceder a la api
URL: http://localhost:8080
Swagger: http://localhost:8080/swagger-ui/index.html

# Como lanzar pruebas
mvn test
