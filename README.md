# spring-docker-example
Sample application with Spring Boot on Docker

## Build

### Using Jib

```bash
$ ./mvnw compile jib:dockerBuild
```

### Using Dockerfile (Amazon Corretto 8 based)

```bash
$ ./mvnw clean package
$ docker build -t spring-docker-example .
```

## Run

```bash
$ docker run --rm -p 8080:8080 spring-docker-example
```
