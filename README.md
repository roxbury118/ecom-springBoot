# E-Commerce Application

This project is a simple e-commerce application built using Spring Boot (Java) and a cluster-based backend architecture. The application showcases a product listing with options to add items to a cart. The project is designed for learning and demonstrates how to create a scalable e-commerce backend with a product catalog.

## Features
**Home Page**: Displays a list of product categories.

**Product Page**: Shows a product with their details (e.g., name, price, brand) and an "Add to Cart" option.

**Cart Page**: Shows items added to the shopping cart, with options to remove items or proceed to checkout.

**Categories Page**: Allows users to filter products by categories (e.g., Sedan, SUV, Hatchback, etc.).
## Screenshots
### HOME PAGE
![Screenshot 2024-10-20 231044](https://github.com/user-attachments/assets/d23c10a7-6890-4ea3-a847-c7e8c90330ab)

### PRODUCT PAGE
![Screenshot 2024-10-20 231749](https://github.com/user-attachments/assets/db690bce-d709-45db-821b-69fac7a9e9a4)


## Tech Stacks
**Backend**: Spring Boot (Java)

**Frontend**: HTML, CSS, JavaScript

**Database**: Hibernate

**Dependencies**: Maven for dependency management

## Installation

Use the package manager [pip](https://pip.pypa.io/en/stable/) to install foobar.

```bash
pip install foobar
```

## Steps to Run the Project
1.Clone the repository:
```bash
git clone https://github.com/yourusername/ecommerce-app.git
```
2.Navigate to the project directory:

```bash
cd ecommerce-app
```
3.Update the application.properties file with your database configuration:

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```
4.Build and run the application using Maven or Gradle:

```bash
mvn spring-boot:run
```
5.Access the application by navigating to (*http://localhost:5173*) in your browser.
