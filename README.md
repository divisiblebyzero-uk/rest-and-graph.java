# Rest and Graph Demonstration project - Java implementation

This is a project to demo REST and GraphQL using Java (and Spring boot). There are sister projects in Node.JS, C# and Kotlin.

## Functional Description

The application has a simple entity model: Countries and Cities

### Country Example
```json
{
  "id": 1,
  "name": "UK",
  "language": "English"
}
```

### City Example
```json
{
  "id": 1,
  "name": "London",
  "country": "UK",
  "size": "Huge"
}
```

These are modelled in the `entities` package.

## Implementation Description

By default, the application starts with a blank H2 database, and uses JPA to create the persistence structure.

There are three implementations:

### Manual JSON API using JPA and RestController

In the `service.manualrepository` package are two CrudRepositories and a web controller class.

The web controller has the following endpoints:
* http://localhost:8080/manual/ - Hello World
* http://localhost:8080/manual/insertData - Creates some data
* http://localhost:8080/manual/listAllCountries - Dumps out all countries
* http://localhost:8080/manual/listAllCities - Dumps out all cities

### RestRepository

In the `service.restrepository` package are two RestRepository implementations:

* http://localhost:8080/countries
* http://localhost:8080/cities

These are fully Spring-managed REST repositories, and so you can GET the full list, GET by id, or POST a write.

### GraphQL

To be implemented

## Running the application

Run via "mvn spring-boot:run".

As a convenience, http://localhost:8080/ will return a web page with links to the live URIs.

