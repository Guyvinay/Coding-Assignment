# Tambola Ticket Generator API

## Overview

The Tambola Ticket Generator API is a Spring Boot application that allows users to generate and manage Tambola (Bingo) tickets. It provides endpoints for generating sets of tickets, retrieving individual tickets, and fetching tickets with pagination.

## Getting Started

### Prerequisites

- Java JDK 8 or later
- Maven
- MySQL database

### Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/tambola-ticket-generator.git
   
   //Configure the MySQL database connection in: src/main/resources/application.properties:
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect


# Access the API at http://localhost:8080/api/tickets.

## API Endpoints

1. **Generate Set of Tickets**
   - **Endpoint:** `POST /api/tickets/{numberOfSets}`
   - **Description:** Generate and save a specified number of Tambola ticket sets.
   - **Request:**
     - Path Variable:
       - `numberOfSets` (int): The number of sets to generate.
   - **Response:**
     - Status: 200 OK
     - Body: List of generated ticket sets.

2. **Generate Single Set of Ticket**
   - **Endpoint:** `POST /api/tickets`
   - **Description:** Generate and save a single set of Tambola ticket.
3. **Get All Tickets**
   - **Endpoint:** `GET /api/tickets`
   - **Description:** Retrieve all Tambola tickets.
   - **Response:**
     - Status: 200 OK
     - Body: List of all tickets.

4. **Get Ticket by ID**
   - **Endpoint:** `GET /api/tickets/{ticket_id}`
   - **Description:** Retrieve a Tambola ticket by its ID.
   - **Request:**
     - Path Variable:
       - `ticket_id` (String): The unique identifier of the ticket.
   - **Response:**
     - Status: 200 OK
     - Body: Details of the specified ticket.

5. **Get Tickets with Pagination**
   - **Endpoint:** `GET /api/tickets?page=1&limit=15&dir=ASC`
   - **Description:** Retrieve Tambola tickets with pagination.
   - **Request:**
     - Query Parameters:
       - `page` (int, optional, default: 0): Page number.
       - `limit` (int, optional, default: 10): Number of tickets per page.
       - `dir` (String, optional, default: "DESC"): Sorting direction ("ASC" or "DESC").
   - **Response:**
     - Status: 202 ACCEPTED
     - Body: List of paginated tickets.

## Contributing

If you'd like to contribute to the development of the Tambola Ticket Generator API, please follow these steps:

1. Fork the repository on GitHub.
2. Create a new branch with a descriptive name: `git checkout -b feature/new-feature`.
3. Make your changes and commit them: `git commit -am 'Add new feature'`.
4. Push the changes to your fork: `git push origin feature/new-feature`.
5. Create a pull request on the original repository.

