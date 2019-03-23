# spring-docker-example
Sample application with Spring Boot on Docker

## Build

### Using Jib

```bash
$ ./mvnw compile jib:dockerBuild
```

## Run

```bash
$ docker run --rm -p 8080:8080 spring-docker-example
```
