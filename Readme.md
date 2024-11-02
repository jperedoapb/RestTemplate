# 🚀 RestTemplate in Spring Boot: An Overview
## 👌What is RestTemplate?
It’s a class provided by Spring that greatly simplifies interaction with RESTful services. It acts as an HTTP client, allowing you to make requests (GET, POST, PUT, DELETE, etc.) to external services and process responses.

### 😏Why use it?
* Ease of Use: It abstracts the complexity of working with HTTP, allowing you to focus on business logic.
* Integration with Spring: It integrates seamlessly into the Spring ecosystem, making it easy to use in Spring Boot applications.
* Flexibility: It offers a wide range of methods to perform different types of requests and customize them.

### 😯Should you keep using it?
While RestTemplate has been a very popular tool, a new competitor has emerged in recent years: WebClient.

WebClient, based on the Reactor project, offers a more reactive and functional interface, making it better suited for modern, asynchronous applications.

### ✅Advantages of RestTemplate
* Easy to use: Its API is intuitive and easy to learn.
* Widely used: There is a large amount of documentation and examples available.
* Mature: It’s a stable and mature tool.

### ⚠️Disadvantages of RestTemplate
* Imperative: It follows an imperative programming style, which can make composing calls and handling errors challenging in complex scenarios.
* Blocking: RestTemplate calls are synchronous, which can affect performance in high-concurrency applications.
* Less functional: Compared to WebClient, it offers a less functional and expressive interface.

### 🔀When to use RestTemplate and when to use WebClient?
* RestTemplate: It’s a good choice for legacy projects or when you need a simple and quick solution to consume REST services.
* WebClient: It’s better suited for modern applications that require high performance, asynchrony, and more functional programming.

## ✨Additional Considerations:
* Spring Framework 5: Introduced WebClient as a more modern alternative to RestTemplate.
* Spring Boot 2: Includes native support for WebClient.
* Migration: Migrating from RestTemplate to WebClient may require some code changes, but the long-term benefits often justify the effort.
In summary, RestTemplate is a useful tool, but WebClient represents the future of HTTP clients in Spring. When deciding which to use, consider your specific needs, project size, and familiarity with reactive technologies.

## 🌟Spring Boot 3 and RestTemplate
* Continued Support: Despite the introduction of WebClient in previous versions and its promotion as the preferred choice for new projects, RestTemplate is still fully compatible and supported in Spring Boot 3.
* Design Decision: The choice to keep RestTemplate is based on backward compatibility and allowing existing applications to continue functioning without an immediate migration.
* Recommendation: Although it remains compatible, it is strongly recommended to use WebClient for new projects due to its advantages in performance, asynchrony, and functional programming.

### ✳️So, what does this mean for you?
If you’re working on a new project with Spring Boot 3, WebClient is the ideal choice. It will provide a solid foundation for building modern and scalable applications.

If you’re maintaining an existing project that uses RestTemplate and have no immediate plans to refactor, you can continue using it without any issues in Spring Boot 3.

## 🏁Conclusion
RestTemplate remains a valid tool, especially for existing projects. However, for new projects, WebClient is the recommended choice due to its advantages in terms of performance, flexibility, and alignment with current development trends.

Would you like to explore a specific aspect of RestTemplate in more detail?

If so, check out this project, which provides an example of RestTemplate usage with the added bonus of applying the "Factory Method" design pattern.

### 🚧RestTemplate - Spring Boot Example Project
This project aims to use Spring’s RestTemplate component as a client to consume a service. The service to be consumed is:

* https://jsonplaceholder.typicode.com/
### 🏭Applying the Factory Method
The Factory Method design pattern may not be immediately obvious in the context of the "ConsumeApi" service, as this service mainly interacts with an external API rather than creating complex instances of PostDto.

However, there are ways to apply the Factory pattern or related patterns to improve code organization and maintainability.

To consume the service, a DTO class "PostDTO" is created. The Factory pattern implementation in "PostDtoFactory" is a good practice for encapsulating object creation logic. This can be useful if, in the future, creating a PostDto requires more logic (e.g., validations, default assignments, etc.).

## Technology Stack 🛠️
* Java 21 JDK
* Apache Maven 4.0.x 
* Spring Boot - Java framework
* JUnit - Testing and integration tests

## Methodology
* Git Flow - Collaboration and versioning

## Development Environment 🚀
_These instructions will help you get a copy of the project up and running on your local machine for development and testing purposes._
* Git
* Java 21 JDK
* IntelliJ
* Install Lombok in your IDE
_This depends on the IDE(1) you use. Follow the instructions on Project Lombok_

##### Start Application

    mvn clean install
