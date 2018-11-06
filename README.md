# Eclipse Microprofile

It's time to challenge Spring Boot: [Eclipse Microprofile](https://microprofile.io) FTW!

Build and run:

    ./gradlew libertyStart
    curl http://localhost:8080/microprofile/micro/accounts
    curl http://localhost:8080/metrics 
    curl http://localhost:8080/health 

Using following tutorials:

* https://www.baeldung.com/eclipse-microprofile
* https://github.com/IBM/java-microprofile-config

Some cool things:
* `@ConfigProperty`, `@Retry`, `@CircuitBreaker`, `@Fallback`
* use JsonWebToken and `@RolesAllowed("read-accounts")`
