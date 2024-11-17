# **Airport Ticket Booking System**

## **Overview**
This is an Airport Ticket Booking System developed using **Spring Boot** for the backend, with **Docker** for containerization and **JWT** for secure authentication. The system allows passengers to search for flights, book tickets, and manage their bookings through a **REST API**.

---

## **Tech Stack**

- **Backend Framework**: Spring Boot
- **Database**: MySQL
- **ORM**: Hibernate
- **Authentication**: JWT (JSON Web Tokens)
- **Containerization**: Docker
- **API Documentation**: Swagger
- **Version Control**: Git (hosted on GitHub)

---

## **How to Use the Project**

### **1. Clone the Repository**
To get started with the project, clone it to your local machine:

```bash
git clone https://github.com/amrbadran/airport-ticket-booking.git
```

```bash 
cd airport-ticket-booking
```

### **2. Docker Setup**
To run the application with Docker, follow these steps:

#### **Build Docker Images**
Ensure Docker is installed on your machine. From the project directory, run the following command to build the images and bring up the containers:

```bash
docker-compose up --build
```

This will start the following services:
- **MySQL**: Running the database for storing flight and passenger information.
- **Spring Boot Application**: Running the backend application.

#### **Stopping Containers**
To stop the containers, use:

```bash
docker-compose down
```
---

### **3. Accessing the Application**

- **API Documentation (Swagger UI)**: You can access the API documentation by opening the following URL in your browser:
  `http://localhost:8081/swagger-ui.html`
- **Database**: The application uses MySQL running on Docker. You can connect to it using any MySQL client with the following credentials:
    - **Host**: localhost
    - **Port**: 3306
    - **Username**: root
    - **Password**: `yourpassword`

---

### **4. Authentication**
To interact with the system, you need to authenticate with JWT.

#### **Login to Get a Token**
Use the **POST** method on the following endpoint to log in and get a JWT token:


##### POST /auth/login

The request body should contain the passenger’s username and password. On successful login, the response will return a JWT token that you can use for authentication in other API requests.

---

### **5. Using the API**

Some key actions you can perform via the API:

- **Search for available flights** by various filters.
- **Book a flight** for a passenger.
- **Manage bookings** (view, cancel, update).

---

### **6. Database Schema**
The following entities are used in the database:

- **Airport**: Contains airport details.
- **Flight**: Contains flight details, including departure and arrival information, and pricing for each class.
- **Booking**: Connects a passenger to a flight with their chosen class.
- **Passenger**: Represents the passenger details.

The SQL commands for creating the database schema are available in the `sql` folder.

---


### **Contributions**
Feel free to fork the repository and submit pull requests for bug fixes, feature requests, or improvements.

---


### **Important Notes**
- **Swagger UI** is hosted at `http://localhost:8081/swagger-ui.html`.
- The **JWT authentication** is required for accessing the booking and search functionality.
- Ensure **Docker** is set up and running before executing the project.

---

This README serves as a comprehensive guide to set up and use the **Airport Ticket Booking System** project. Let me know if you need any further clarifications!
