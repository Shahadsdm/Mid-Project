# Mid-Project

**Movie Reservation**

The Movie Reservation System is a Java-based backend application that allows users to register, book movie tickets, and manage movie listings. 
The system comprises five main classes: User, Admin, RegisteredUser, Movie, and Reservation, each serving specific roles and functionalities.

## Table of Contents
1. [UML Class Diagram](#uml-class-diagram)
2. [Setup](#setup)
3. [Technologies Used](technologies-used)
4. [Project Structure](#project-structure)
5. [Class Descriptions](#class-descriptions)
6. [Repository](#repository)
7. [Controller](#controller)
8. [Service](#service)
9. [Extra Links](extra-links)
10. [Future Work](future-work)
11. [Resources](#resources)

## UML Class Diagram
<img width="516" alt="image" src="https://github.com/Shahadsdm/Mid-Project/assets/128249461/a01a8ea8-1ce5-4acd-ad8b-754c5a9ffa31">


## Setup
- Clone the repository to your local environment.
- Ensure you have Java and Spring Boot setup.
- Configure your database connection properties in `src/main/resources/application.properties`.

## Technologies Used
- Java
- Spring Boot

## Project Structure
The project is structured into the following main components:
- `src/main/java/com.sda.MidProject` : The package containing the main application.
- `src/main/java/com.sda.MidProject.entity` : Contains the class definitions.
- `src/main/java/com.sda.MidProject.repository` : Provides data access and storage.
- `src/main/java/com.sda.MidProject.controller` : Defines API endpoints.
- `src/main/java/com.sda.MidProject.service` : Manages business logic.

## Class Descriptions
1. **User Class**: The base class for all users, storing common attributes such as username, password, and email.

2. **Admin Class (Child of User)**: Inherits from the User class and allows administrators to manage other administrators and movie listings.

3. **RegisteredUser Class (Child of User)**: Inherits from the User class and enables registered users to book reservations, update their information, and access the system.

4. **Movie Class**: Represents movie listings with details like title, category, duration and rating. Admins can add, find, categorize, and manage movies.

5. **Reservation Class**: Represents a movie ticket reservation made by registered users. It links to a Movie and a RegisteredUser object.

## Repository
- The `repository` package contains interfaces to interact with the database for each class. Methods for data retrieval and modification are defined here.

## Controller
- The `controller` package defines API endpoints that handle incoming HTTP requests, communicate with services, and return HTTP responses.

## Service
- The `service` package contains the business logic for managing users, movies, and reservations. It interacts with repositories to process data.

## Extra Links
- [Trello](https://trello.com/invite/b/Rr0Ew7LK/ATTI69f994d172f868819ee44b3a60fbba0fE7967589/mid-project)

## Future Work
- Implementing user authentication and authorization.
- Integrating payment processing.
- Expanding the movie categorization system.

## Resources
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Ironhack Student Portal](http://my.ironhack.com)
