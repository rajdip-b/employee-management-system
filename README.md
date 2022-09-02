# Employee Management System

## Description
Employee management system is an application based system, having two applications developed, one for employers to manage employee details and another for employees to mark their attendance. Every organisation whether government or private uses an information system

## Features
Currently, the application supports the following features:
- Add new employee
- Delete employee
- Update employee details
- Add new department
- Delete department
- Update department details

More features such as attendance marking, attendance report, salary calculation, etc. will be added in the future.

## Tech Stack
The application is developed using the following technologies:
- ReactJS in frontend
- SpringBoot in backend
Efforts of re-creating the application backend using ExpressJS and the frontend in a CLI are ongoing

## Installation

### Frontend
- Clone the repository
- Install dependencies using `npm install`
- Run `npm start` to start the application
- Open http://localhost:3000 to see the application

### Backend
- Clone the repository
- Install dependencies using `./mvnw clean install`
- Run `mvnw spring-boot:run` to start the application
- Open http://localhost:8080/swagger-ui/index.html to see the API documentation

### Database
This project currently uses an in-memory(H2) database so no need of setting up external database configuration.
