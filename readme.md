# Spring Boot Elastic Search Appliction

[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2FSpring-Boot-Framework%2FSpring-Boot-Application-Template.svg?type=shield)](https://app.fossa.io/projects/git%2Bgithub.com%2FSpring-Boot-Framework%2FSpring-Boot-Application-Template?ref=badge_shield)
[![GitHub issues](https://img.shields.io/github/issues/Spring-Boot-Framework/Spring-Boot-Application-Template)](https://github.com/Spring-Boot-Framework/Spring-Boot-Application-Template/issues)
[![GitHub forks](https://img.shields.io/github/forks/Spring-Boot-Framework/Spring-Boot-Application-Template)](https://github.com/Spring-Boot-Framework/Spring-Boot-Application-Template/network)
[![GitHub stars](https://img.shields.io/github/stars/Spring-Boot-Framework/Spring-Boot-Application-Template)](https://github.com/Spring-Boot-Framework/Spring-Boot-Application-Template/stargazers)
[![Build Status](https://travis-ci.org/Spring-Boot-Framework/Spring-Boot-Application-Template.svg?branch=master)](https://travis-ci.org/Spring-Boot-Framework/Spring-Boot-Application-Template)
[![codecov](https://codecov.io/gh/Spring-Boot-Framework/Spring-Boot-Application-Template/branch/master/graph/badge.svg)](https://codecov.io/gh/Spring-Boot-Framework/Spring-Boot-Application-Template)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/4bc5385252064f0e908f445b1eba184b)](https://www.codacy.com/gh/Spring-Boot-Framework/Spring-Boot-Application-Template?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Spring-Boot-Framework/Spring-Boot-Application-Template&amp;utm_campaign=Badge_Grade)
[![](https://images.microbadger.com/badges/image/anantha/spring-boot-application-template.svg)](https://microbadger.com/images/anantha/spring-boot-application-template)
[![](https://images.microbadger.com/badges/version/anantha/spring-boot-application-template.svg)](https://microbadger.com/images/anantha/spring-boot-application-template)
![Docker Image Size (latest by date)](https://img.shields.io/docker/image-size/anantha/spring-boot-application-template)

A Spring Boot application with elastic search database with option to bulk import data.

## Built With

* 	[Maven](https://maven.apache.org/) - Dependency Management
* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* 	[ElasticSearch](https://www.mysql.com/) - Open-Source Relational Database Management System
* 	[git](https://git-scm.com/) - Free and Open-Source distributed version control system
* 	[Swagger](https://swagger.io/) - Open-Source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services.

## External Tools Used

* 	[Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)
* 	[Postman Echo](https://docs.postman-echo.com/?version=latest) - A service that can be used to test your REST clients and make sample API calls. It provides endpoints for GET, POST, PUT, various auth mechanisms and other utility endpoints.
* 	[Travis CI](https://travis-ci.org/github/Spring-Boot-Framework/Spring-Boot-Application-Template) - A hosted continuous integration service used to build and test software projects hosted at GitHub and Bitbucket.
* 	[Codecov](https://codecov.io/gh/Spring-Boot-Framework/Spring-Boot-Application-Template) - A hosted tool that is used to measure the test coverage of your codebase.
*	[Dependabot](https://dependabot.com/) - Automated dependency updates.

## To-Do

* 	[x] Logger (Console, File, Mail)
* 	[x] RESTful Web Service (CRUD)
* 	[x] Bootstrap - CSS
* 	[x] Web - HTML, JavaScript (jQuery)
* 	[x] Content Negotiation
* 	[x] Security (Basic Authentication)
* 	[ ] Material Design for Bootstrap
* 	[ ] Docker
* 	[ ] HATEOS
* 	[ ] Spring Boot Admin
* 	[ ] NoSQL (MongoDB)
* 	[ ] MySQL (Connect to Multiple Schemas)
* 	[ ] Micrometer
* 	[ ] Grafna

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. 
One way is to execute the `main` method in the `com.suhas.SampleApplications` class from your IDE.

* 	Clone the Git repository.
* 	Open Eclipse
	* File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
	* Select the project
* 	Choose the Spring Boot Application file (search for @SpringBootApplication)
* 	Right Click on the file and Run as Java Application

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html)

## Setting up elasticsearch 
```shell script
docker run -d --name elasticsearch -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" elasticsearch:6.6.2
```

## Run the application

```shell
mvn spring-boot:run
```

## Bulk Import Test Data
* 	`set initial-import.enabled to true` 
```shell script
initial-import:
  enabled: true
```

## ElasticHQ
 > Assuming that you have already started the sample application, the bean responsible for bulking index were not disabled, and you were enough patience to wait some hours until all data has been inserted into your Elasticsearch node, now it contains 100M documents of employee type. It is worth to display some information about your cluster. You can do it using Elasticsearch queries or you can download one of available GUI tools, for example ElasticHQ. Fortunately, ElasticHQ is also available as a Docker container. You have to execute the following command to start container with ElasticHQ:
```shell script
docker run -d --name elastichq -p 5000:5000 elastichq/elasticsearch-hq
```
## ElasticHQ Dashboard
```shell script
http://localhost:5000/
```

## Swagger 
```shell script
http://localhost:8002/swagger-ui.html
```

## Running the application via docker container

* 	[anantha/spring-boot-application-template](https://hub.docker.com/repository/docker/anantha/spring-boot-application-template) - DockerHub Image

DockerHub Pull Command

```text
docker pull suhaz786/elasticSearchApp
```

Ensure you build a jar of the application before building a docker image.  

```text
mvn package -Dmaven.test.skip=true     //skip all tests and build
```

```text
mvn clean package					   //run all tests and build
```

|  Command |  Description |
|----------|--------------| 
|docker images                                       | take a look at the container images. |
|docker ps                                           | list all the running containers.     |
|docker ps -a                                        | list all the containers, including the ones that have finished executing.|
|docker build -t elasticSearchApp .  | Build docker image of the project    |
|docker run elasticSearchApp         | run the project's docker container   |
|docker stop [container_id]                          | stop a container                     |
|docker rm $(docker ps -aq)                          | stop and remove all containers       |

### Elastic Search
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

### Actuator

To monitor and manage your application

|  URL |  Method |
|----------|--------------|
|`http://localhost:8080`| GET |
|`http://localhost:8080/actuator/`| GET |
|`http://localhost:8080/actuator/health`| GET |
|`http://localhost:8080/actuator/info`| GET |
|`http://localhost:8080/actuator/prometheus`| GET |
|`http://localhost:8080/actuator/httptrace`| GET |

### URLs

|  URL |  Method | Remarks |
|----------|--------------|--------------|
|`http://localhost:8080/bw/tech-stack`                           | GET | Custom Response Headers|
|`http://localhost:8080/api/generic-hello`                       | GET | |
|`http://localhost:8080/api/personalized-hello/`                 | GET | |
|`http://localhost:8080/api/personalized-hello?name=spring-boot` | GET | |
|`http://localhost:8080/api/loggers`                             | GET | |

### Person URLs

|  URL |  Method | Remarks |
|----------|--------------|--------------|
|`http://localhost:8080/api/person`                         | GET | Header `Accept:application/json` or `Accept:application/xml` for content negotiation|
|`http://localhost:8080/api/person/1`                       | GET |                                                                                     |


## Documentation

* 	[Postman Collection](https://documenter.getpostman.com/view/2449187/RWTiwzb2) - online, with code auto-generated snippets in cURL, jQuery, Ruby,Python Requests, Node, PHP and Go programming languages
* 	[Postman Collection](https://github.com/AnanthaRajuC/Spring-Boot-Application-Template/blob/master/Spring%20Boot%20Template.postman_collection.json) - offline
* 	[Swagger](http://localhost:8080/swagger-ui.html) - `http://localhost:8080/swagger-ui.html`- Documentation & Testing

## packages

* 	`models` — to hold our entities;
* 	`repositories` — to communicate with the database;
* 	`services` — to hold our business logic;
* 	`security` — security configuration;
* 	`controllers` — to listen to the client;

* 	`resources/` - Contains all the static resources, templates and property files.
* 	`resources/static` - contains static resources such as css, js and images.
* 	`resources/templates` - contains server-side templates which are rendered by Spring.
* 	`resources/application.properties` - It contains application-wide properties. Spring reads the properties defined in this file to configure your application. You can define server’s default port, server’s context path, database URLs etc, in this file.

* 	`test/` - contains unit and integration tests

* 	`pom.xml` - contains all the project dependencies