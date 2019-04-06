# spring-docker-example

[![CircleCI](https://circleci.com/gh/os1ma/spring-docker-example.svg?style=svg)](https://circleci.com/gh/os1ma/spring-docker-example)

Sample application with Spring Boot on Docker

## Develop

When you develop, you have to start Spring Boot container and MySQL container by following command.

```bash
$ docker-compose up
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
$ ./build.sh
```

## Run

```bash
$ docker run --rm -p 8080:8080 spring-docker-example
```
