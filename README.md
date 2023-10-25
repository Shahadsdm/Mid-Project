# Mid-Project

**Movie Reservation**

The Movie Reservation System is a Java-based backend application that allows users to register, book movie tickets, and manage movie listings. 
The system comprises five main classes: User, Admin, RegisteredUser, Movie, and Reservation, each serving specific roles and functionalities.

## Table of Contents
1. [Project Structure](#project-structure)
2. [Class Descriptions](#class-descriptions)
3. [Repository](#repository)
4. [Controller](#controller)
5. [Service](#service)
6. [Usage](#usage)

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

## Usage
- Build and run the application.
- Access the API endpoints to manage users, movies, and reservations.

## UML Class Diagram
<img width="516" alt="image" src="https://github.com/Shahadsdm/Mid-Project/assets/128249461/a01a8ea8-1ce5-4acd-ad8b-754c5a9ffa31">
