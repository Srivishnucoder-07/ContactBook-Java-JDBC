# Contact Book Application (Java + JDBC)

A Command-Line Contact Book Application developed using Core Java and JDBC.  
This application allows users to add, view, and search contact details with persistent storage using a MySQL database.

---

## Features
- Add new contacts
- View all stored contacts
- Search contacts by name
- Menu-driven command line interface
- Data stored permanently in MySQL database

---

## Technologies Used
- Java (Core Java)
- JDBC (Java Database Connectivity)
- MySQL
- Eclipse IDE
- Git and GitHub

---

## Database Details

### Database Name
contactbook

### Table Structure
```sql
CREATE TABLE contacts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    phone VARCHAR(15),
    email VARCHAR(100)
);
