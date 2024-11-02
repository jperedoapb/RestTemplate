# 🚀 *RestTemplate en Spring Boot: Un vistazo general*  
## 👌¿Qué es RestTemplate?
Es una clase proporcionada por Spring que simplifica enormemente la interacción con servicios RESTful. Actúa como un cliente HTTP, 
permitiendo realizar peticiones (GET, POST, PUT, DELETE, etc.) a servicios externos y procesar las respuestas.

### 😏¿Por qué se usa?
* Facilidad de uso: Abstrae la complejidad de trabajar con HTTP, permitiendo enfocarse en la lógica de negocio.
* Integración con Spring: Se integra perfectamente en el ecosistema Spring, facilitando su uso en aplicaciones Spring Boot.
* Flexibilidad: Ofrece una amplia gama de métodos para realizar diferentes tipos de peticiones y personalizarlas.

### 😯¿Se debería seguir usando?
Si bien RestTemplate ha sido una herramienta muy popular, en los últimos años ha surgido un nuevo competidor: WebClient. 

WebClient, basado en el proyecto Reactor, ofrece una interfaz más reactiva y funcional, lo que lo hace más adecuado para 
aplicaciones modernas y asíncronas.

### ✅Ventajas de RestTemplate
* Sencillo de usar: Su API es intuitiva y fácil de aprender.
* Ampliamente utilizado: Existe una gran cantidad de documentación y ejemplos disponibles.
* Madurez: Es una herramienta madura y estable.

### ⚠️Desventajas de RestTemplate
* Imperativo: Sigue un estilo de programación imperativo, lo que puede dificultar la composición de llamadas y el manejo 
de errores en escenarios complejos.
* Bloqueante: Las llamadas a RestTemplate son sincrónicas, lo que puede afectar el rendimiento en aplicaciones con alta concurrencia.
* Menos funcional: Comparado con WebClient, ofrece una interfaz menos funcional y expresiva.

### 🔀¿Cuándo usar RestTemplate y cuándo usar WebClient?
* RestTemplate: Es una buena opción para proyectos heredados o cuando se necesita una solución simple y rápida para consumir servicios REST.
* WebClient: Es más adecuado para aplicaciones modernas que requieren un alto rendimiento, asincronía y una programación más funcional.

## ✨Consideraciones adicionales:
* Spring Framework 5: Introdujo WebClient como una alternativa más moderna a RestTemplate.
* Spring Boot 2: Incluye soporte nativo para WebClient.
* Migración: Migrar de RestTemplate a WebClient puede requerir algunos cambios en el código, pero las ventajas a largo plazo suelen justificar el esfuerzo.
  En resumen, RestTemplate es una herramienta útil, pero WebClient representa el futuro de los clientes HTTP en Spring. Al evaluar cuál usar, considera tus necesidades específicas, el tamaño del proyecto y tu familiaridad con las tecnologías reactivas.

## 🌟Spring Boot 3 y RestTemplate
* Soporte continuo: A pesar de la introducción de WebClient en versiones anteriores y su promoción como la opción preferida para nuevos proyectos, RestTemplate sigue siendo totalmente compatible y soportado en Spring Boot 3.
* Decisión de diseño: La decisión de mantener RestTemplate se basa en la compatibilidad hacia atrás y en permitir que las aplicaciones existentes sigan funcionando sin necesidad de una migración inmediata.
* Recomendación: Aunque sigue siendo compatible, se recomienda encarecidamente utilizar WebClient para nuevos proyectos debido a sus ventajas en cuanto a rendimiento, asincronía y programación funcional.

### ✳️Entonces, ¿qué significa esto para ti?
Si estás trabajando en un proyecto nuevo con Spring Boot 3, WebClient es la opción ideal. Te proporcionará una base sólida para construir aplicaciones modernas y escalables.

Si estás manteniendo un proyecto existente que utiliza RestTemplate y no tienes planes de refactorizarlo a corto plazo, puedes continuar utilizándolo sin problemas en Spring Boot 3.

## 🏁Conclusión
RestTemplate sigue siendo una herramienta válida, especialmente para proyectos existentes. Sin embargo, para nuevos proyectos, 
WebClient es la opción recomendada debido a sus ventajas en términos de rendimiento, flexibilidad y alineación con las tendencias actuales de desarrollo.



¿Te gustaría profundizar en algún aspecto específico de RestTemplate ?

Si es así revisa este proyecto que se muestra un ejemplo de su uso de RestTemplate con un bono adicional aplicar un
patrón de diseño "Factory method".

## 🚧Proyecto de ejemplo RestTemplate - Spring boot
Este proyecto tiene como finalidad utilizar el componente RestTemplate de Spring como cliente para consumir un servicio.
El servicio a consumir será este:
* https://jsonplaceholder.typicode.com/

### 🏭Aplicando Factory Method
El patrón de diseño de fábrica(Factory method) puede no ser tan evidente en el contexto del servicio "ConsumirApi", 
ya que este servicio se encarga principalmente de interactuar con una API externa y no de crear instancias de PostDto de manera compleja. 

Sin embargo, hay algunas maneras en que se podría aplicar el patrón de fábrica o patrones relacionados para mejorar la organización y la 
mantenibilidad del código.

Para poder consumir el servicio se crea un clase DTO *"PostDTO"* . La implementación del patrón Factory que se realiza en *"PostDtoFactory"* 
es una buena práctica para encapsular la lógica de creación de objetos. Esto puede ser útil si en el futuro si se decid 
que la creación de un PostDto requiere más lógica (por ejemplo, validaciones, asignaciones predeterminadas, etc.).

## Stack Tecnológico 🛠️

* Java 21 JDK
* Apache Maven 4.0.x 
* [Spring boot](https://spring.io/projects/spring-boot) - Framework de java
* [Junit](https://junit.org/junit5/) - Tests y Test de integración.

## Metodología
* [Git Flow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow) - Colaboración y versionado



## Entorno de Desarrollo 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._
* Git
* Java 21 JDK
* Intellij

##### Instalar Lombok en el IDE

_Esto depende del IDE(1) que utilices, seguir indicaciones de la web de [Project Lombok](https://projectlombok.org/)_

##### Iniciar aplicación

    mvn clean install
