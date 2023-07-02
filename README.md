# Reactive Web Application

## Tech stack
- JDK 17
- Spring Boot 3
- Spring WebFlux
- Spring Data R2DBC
- H2 Database (and the [R2DBC driver](https://mvnrepository.com/artifact/io.r2dbc/r2dbc-h2))
- Angular 

## Troubleshooting

### 1. Open API 3
Spring Webflux with Spring Boot 3 needs [springdoc-openapi-starter-webflux-ui](https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webflux-ui)

<br>

### 2. Inserting data: Failed to update table [X]; Row with Id [X] does not exist
Solution -> Implementing Persistable on the model
- [Issue on the spring-data-r2dbc github repository](https://github.com/spring-projects/spring-data-r2dbc/issues/275#issuecomment-645251500)
- [Stack Overflow](https://stackoverflow.com/a/64170679)

Workaround -> creating a DTO/Record to hide the id
