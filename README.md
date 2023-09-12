# Spring Boot CRUD 3.1.1 with Thymeleaf
This project demonstrates the implementation of thymeleaf using Spring Boot 3.1.1
<img src="https://www.svgrepo.com/show/354380/spring-icon.svg" style="height: 40px">
## [Springboot_Document](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)

## Spring-Boot-Crud-Application (Project_Structure)
````

StudentFormRegistrationApp
├── README.md
├── pom.xml
├── src
│ ├── main
│ │ ├── java
│ │ │ └── com
│ │ │     └── crudapp
│ │ │         ├── StudentCrudApplication.java
│ │ │         ├── controller
│ │ │         │ └── StudentController.java
│ │ │         ├── entity
│ │ │         │ └── Student.java
│ │ │         ├── exception
│ │ │         │ └── StudentNotFoundException.java
│ │ │         ├── repo
│ │ │         │ └── StudentRepository.java
│ │ │         └── service
│ │ │             ├── IStudentService.java
│ │ │             └── impl
│ │ │                 └── StudentServiceImpl.java
│ │ └── resources
│ │     ├── application.yml
│ │     ├── static
│ │     │ └── myjs
│ │     │     └── spec_validate.js
│ │     └── templates
│ │         ├── StudentData.html
│ │         ├── StudentEdit.html
│ │         └── StudentRegister.html
│ └── test
│     └── java
│         └── com
│             └── crudapp
│                 └── StudentCrudApplicationTests.java
└── target
    ├
    │ ├── static
    │ │ └── myjs
    │ │     └── spec_validate.js
    │ └── templates
    │     ├── StudentData.html
    │     ├── StudentEdit.html
    │     └── StudentRegister.html
````

* [Install any LINUX OS or Ubuntu for Development (Recommended) ](https://releases.ubuntu.com/jammy/)<img src="https://assets.ubuntu.com/v1/a7e3c509-Canonical%20Ubuntu.svg" style="height: 50px">

## Requirements
Make sure to have the followings installed:
<img src="https://www.freepnglogos.com/uploads/logo-mysql-png/logo-mysql-mysql-logo-png-images-are-download-crazypng-21.png" style="height: 40px">
<img src="https://www.svgrepo.com/show/331370/docker.svg" style="height: 40px">

* To run locally
    - MySQL Server

* To run with Docker
    - Docker (Ubuntu 22.04 [Installation guide](https://docs.docker.com/engine/install/ubuntu/))
    - Docker-compose (Ubuntu 22.04 [Installation guide](https://docs.docker.com/compose/install/)))
## Getting Started
To get started with this project, you will need to have the following installed on your local machine:

* JDK 17+
* Maven 3+

## Build and Run the project, follow these steps
* Locally
    - Clone the repository: git clone [SpringBoot-CRUD](https://github.com/vikrantgit97/StudentCrudApplication.git)
    - Navigate to the project directory
    - Create a database in MySql `student`
    - Build the project: `mvn clean install`
    - Run `mvn clean package spring-boot:run` to build the artifact and run the application

* Docker
    - Run `docker-compose up --build -d` to run the docker services

## Run Spring Boot application directly
```
mvn spring-boot:run
```
