# Minicurso Desenvolvimento de APIs Rest com Java, Spring e Solid Pattern

## Algumas configurações importantes

### Configuração PostgreSQL

* Executar pelo terminal:
    ``` bash
    psql -h localhost -U postgres
    ```
    
    ``` sql
    CREATE DATABASE minicurso;
    ```

### application.properties

[🔗 Common Application Properties](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#appendix.application-properties.web)

``` properties
spring.datasource.url=jdbc:postgresql://localhost:5432/minicurso
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Dependencia para o Swagger

``` xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.0.0</version>
</dependency>
```

* Executar pelo terminal:
    
    ``` bash
    mvn spring-boot:run
    ```

### Modelagem Relacional

[📂 Modelo Relacional](./Minicurso-Java-Spring.pdf)
