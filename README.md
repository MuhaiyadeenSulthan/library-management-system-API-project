📚 Library Management System

📖 Overview

The Library Management System is a REST API built using Spring Boot and MS SQL Server. It allows users to manage books, members, and borrowing records efficiently.

✨ Features

📌 Book Management: Add, update, delete, and search books by title, category, and ISBN.

👤 Member Management: Register, update, and remove library members.

📖 Borrow & Return Books: Issue and return books with due dates.

📊 Borrowing Records: View currently borrowed and overdue books.

🔍 Search Functionality: Search books and members dynamically.

🛠️ Technologies Used

Java 17

Spring Boot (Spring MVC, Spring Data JPA)

MS SQL Server (Database)

Maven (Dependency Management)

Postman (API Testing)

🚀 Installation & Setup

1️⃣ Clone the Repository

git clone https://github.com/yourusername/library-management-system.git
cd library-management-system

2️⃣ Configure Database

Update application.properties with your MS SQL Server credentials:

spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=LibraryDB
spring.datasource.username=your_username
spring.datasource.password=your_password

3️⃣ Build and Run the Project

mvn clean install
mvn spring-boot:run

📌 API Endpoints

📚 Book Management

Description

   GET
*********

 1) Get all books ->  /api/books
  
    

 2) Get book by ID ->  /api/books/{id}

  
   POST
 *********

 1) Add a new book ->  /api/books
  

  DELETE
**********

  1) Delete a book ->  /api/books/{id}

============================================================================================

👤 Member Management

Description

   GET
*********
   1) Get all members ->  /api/members


  POST
*********

  1) Add a new member ->  /api/members

  DELETE
**********

  1) Remove a member ->  /api/members/{id}

============================================================================================

🔄 Borrowing & Returning Books

Description

  POST
********

  1) Borrow a book ->  /api/borrowings/borrow/{bookId}/member/{memberId}

  2) Return a book ->  /api/borrowings/return/{bookId}/member/{memberId}

  GET
********

  1) Get overdue books ->  /api/borrowings/overdue

============================================================================================

🎯 Future Enhancements

🛡️ Implement Spring Security for authentication.

📊 Add Admin Dashboard for analytics.

📌 Introduce Email Notifications for overdue books.

📝 License

This project is open-source and free to use.
