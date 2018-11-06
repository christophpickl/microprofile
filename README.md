# Eclipse Microprofile

It's time to challenge Spring Boot: [Eclipse Microprofile](https://microprofile.io) FTW!

Build and run:

    ./gradlew libertyStart
    curl http://localhost:8080/microprofile/rest/accounts


Using following tutorials:

* https://www.baeldung.com/eclipse-microprofile
* https://github.com/IBM/java-microprofile-config


Some cool things:

* /metrics and /health endpoints
* `@ConfigProperty`, `@Retry`, `@CircuitBreaker`, `@Fallback`
* use JsonWebToken and `@RolesAllowed("read-accounts")`
