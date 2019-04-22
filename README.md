# spring-docker-example

[![CircleCI](https://circleci.com/gh/os1ma/spring-docker-example.svg?style=svg)](https://circleci.com/gh/os1ma/spring-docker-example)

[![MIT License](http://img.shields.io/badge/license-MIT-blue.svg?style=flat)](LICENSE)

Sample application with Spring Boot on Docker

## Dependencies
- Docker
- Docker Compose

## Using Tools
- Spirng Boot
- Testcontainers
- Jib
- Amazon Corretto 8
- OWASP Dependency Check

## Usage

### Develop

When you develop, you are able to start Spring Boot container and MySQL container by following command.

```bash
$ docker-compose up
```

### Test

You can use Testcontainers in unit test.

### Build

#### Using Dockerfile (Amazon Corretto 8 based)

```bash
$ ./build.sh
```

#### Using Jib

```bash
$ ./mvnw clean test compile jib:dockerBuild
```

### Run

```bash
$ docker run --rm -p 8080:8080 spring-docker-example
```

## CI Job
- Run OWASP Dependency Check for DevSecOps
- Run unit tests and Build JAR
- Build Docker image
