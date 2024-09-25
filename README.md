# Product Management System

## Overview
The Product Management System is a simple Java application that allows users to manage product information in a database. The application utilizes JDBC to interact with a PostgreSQL database, enabling users to perform CRUD (Create, Read, Update, Delete) operations on products.

## Features
- Add new products to the database.
- Retrieve all products from the database.
- Search for products by name.
- Update product details.
- Delete products from the database.

## Project Structure
productmanagement/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── model/            # Contains the Product class
│   │   │   ├── dbutil/           # Contains database utility classes
│   │   │   ├── service/          # Contains service classes for business logic
│   │   │   └── Main.java         # Main class to run the application
│   │   └── resources/            # Contains configuration files (e.g., application.properties)
│   └── test/                     # Contains test classes (if any)
│
└── lib/                          # Contains PostgreSQL JDBC driver JARs

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- PostgreSQL Database
- PostgreSQL JDBC Driver (included in the `lib/` directory)

## Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/AasifNazir786/productmanagement.git
   cd productmanagement

2.	Database Setup
	•	Ensure PostgreSQL is installed and running.
	•	Create a database for the application:
    •	Update the database connection details in the DBUtil class.

3.	Build and Run the Project
	•	Compile the project:
        javac -cp lib/postgresql-42.7.4.jar src/Main.java

    •	Run the application:
        java -cp "lib/postgresql-42.7.4.jar:src" Main

## Usage
	•	Adding a Product:
	•	The application prompts the user to enter product details like name, type, place, and expiry, which are then saved in the database.
	•	Fetching All Products:
	•	The application can display all products currently stored in the database.
	•	Searching for a Product:
	•	Users can search for a product by name and view its details.
	•	Updating a Product:
	•	Users can update the details of an existing product in the database.
	•	Deleting a Product:
	•	Users can remove a product from the database.

## Technologies Used
	•	Java
	•	JDBC
	•	PostgreSQL

## Contact
    For any inquiries or feedback, please reach out to aasif.n.s786@gmail.com.

## You can modify this template as needed to better suit your project. If you have any specific details or features you want to highlight, feel free to add them.
