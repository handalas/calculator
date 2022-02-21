# Calculator
Microservicio calculadora utilizando Spring-boot y Maven que realiza funciones de sumar y restar


#Requisitos previos
 * Maven (version 3.8.4)
 * Java ( Se ha usado el JDK 1.8.0_202)

#Params

  * first -> Primer número
  * second -> Segundo número
  * Operation -> Operacion a realizar, están permitidos "sum" y "subtract"

#Ejecucion

1. Descargar el repositorio github -> `https://github.com/handalas/calculator`
2. Ejecutar instalacion de Maven: -> `mvn clean install`
3. Ejecutar en caso de tener el maven wrapper `./mvnw spring-boot:run`
4. Opcionalmente se puede ejecutar directamente el jar compilado en la carpeta target con `java -jar target/Calculator.jar`
5. Ir a `http://localhost:8080/rest/calculator` con los parametros como se indica en los ejemplos

* Ejemplo resta `http://localhost:8080/rest/calculator?first=1&second=4&operation=subtract`
* Ejemplo suma `http://localhost:8080/rest/calculator?first=5&second=6&operation=sum`

