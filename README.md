# spring-docker-example

Sample application with Spring Boot on Docker

## Develop

When you develop, you have to start MySQL container.

This container mounts ./src/test/resources/docker-entrypoint-initdb.d to initialize database.

```bash
$ docker-compose up -d
```

Next, start Spring Boot application with spring-dev-tools.

```bash
$ ./mvnw spring-boot:run
```

## Test

Unit test is able to execute with testcontainers.

## Build

### Using Jib

```bash
$ ./mvnw clean test compile jib:dockerBuild
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
