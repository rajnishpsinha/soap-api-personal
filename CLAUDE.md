# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build & Run Commands

All commands use the Maven wrapper — no local Maven installation required.

```bash
# Run the application
mvnw.cmd spring-boot:run

# Run tests
mvnw.cmd test

# Build and package
mvnw.cmd clean package

# Run the built JAR
java -jar target/soap-0.0.1-SNAPSHOT.jar
```

## Architecture

This is a Spring Boot 3.4.1 SOAP web services project using Java 21.

**Code generation pipeline:** The `jaxb2-maven-plugin` reads XSD schemas from `src/main/resources/xsd/` and generates Java binding classes into `target/generated-sources/jaxb/` under package `com.company.hoganbankservicecode.generated`. These generated classes are then used by SOAP endpoints. XSD schemas must exist in that directory before the generated sources will appear.

**Typical SOAP service structure (to be implemented):**
- XSD schema → defines the XML contract (request/response types)
- JAXB-generated classes → Java representation of those types
- `@Endpoint` classes in `src/main/java/` → handle incoming SOAP requests
- `WebServiceConfig` (to be created) → exposes WSDL and configures `MessageDispatcherServlet`

**Endpoint exposure:** SOAP endpoints are conventionally served at `/ws/*` and the WSDL at `/ws/<service>?wsdl`.

## Key Dependencies

| Dependency | Purpose |
|---|---|
| `spring-boot-starter-web-services` | SOAP endpoint support |
| `wsdl4j` | WSDL generation |
| `lombok` | Boilerplate reduction |
| `jaxb2-maven-plugin` | XSD → Java class generation |

## Current State

The project is a starter scaffold. No XSD schemas, `@Endpoint` classes, or `WebServiceConfig` have been created yet. Follow the [Spring SOAP guide](https://spring.io/guides/gs/producing-web-service/) as the reference implementation.

## Preference

Project is getting build to make a SOAP web service. The preference is to use Spring Boot 3.4.1 with Java 21, and to follow the standard Spring SOAP guide for implementation.