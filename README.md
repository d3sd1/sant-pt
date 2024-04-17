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
- 

#todo
sonar?=
çoipenapi?
docker?
