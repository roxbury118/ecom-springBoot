# E-Commerce Product Management System

## Overview
This is a full-stack **E-Commerce Product Management System** built using **Spring Boot** for the backend and **React** for the frontend. The system allows users to manage product listings with features such as image handling, CRUD operations, and a responsive user interface.

## Features
- Create, Read, Update, and Delete products
- Image upload and management for products
- Search functionality
- Responsive design
- Real-time data updates
- H2 in-memory database for development

## Technology Stack

### Backend
- **Java 21**
- **Spring Boot 3.3.4**
- **Spring Data JPA**
- **H2 Database**
- **Maven**
- **Lombok**

### Frontend
- **React**
- **Vite**
- **Axios** for API calls
- **React Router** for navigation
- **CSS** for styling

## Setup and Installation

### Backend Setup

1. Clone the repository:
    ```bash
    git clone <repository-url>
    cd ecom_proj
    ```

2. Configure `application.properties`:
    ```properties
    spring.application.name=ecom_proj
    spring.datasource.url=jdbc:h2:mem:db_name
    spring.datasource.driverClassName=org.h2.Driver
    spring.h2.console.enabled=true
    spring.jpa.hibernate.ddl-auto=create-drop
    spring.jpa.defer-datasource-initialization=true
    ```

3. Run the Spring Boot application:
    ```bash
    ./mvnw spring-boot:run
    ```

### Frontend Setup

1. Navigate to the frontend directory:
    ```bash
    cd frontend
    ```

2. Install dependencies:
    ```bash
    npm install
    ```

3. Start the development server:
    ```bash
    npm run dev
    ```

4. The frontend will run on `http://localhost:5173`.

## API Endpoints

### Products
- **GET** `/api/products` - Get all products
- **GET** `/api/products/{id}` - Get product by ID
- **POST** `/api/products` - Create new product
- **PUT** `/api/products/{id}` - Update product
- **DELETE** `/api/products/{id}` - Delete product
- **GET** `/api/products/search?keyword={keyword}` - Search products

## Database Schema

### Product Table
```sql
CREATE TABLE PRODUCT (
    id INT AUTO_INCREMENT PRIMARY KEY,
    p_name VARCHAR(255),
    p_desc TEXT,
    brand VARCHAR(255),
    price DECIMAL(10,2),
    catogary VARCHAR(255),
    release_Date DATE,
    available BOOLEAN,
    quant INT,
    image_name VARCHAR(255),
    image_type VARCHAR(255),
    image_date BLOB
);
