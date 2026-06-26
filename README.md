Employee Management System

This project is developed using Java, Spring Core, Spring JDBC, Maven, and MySQL.

Operations:
- Add Employee
- Search Employee
- Update Employee
- Delete Employee

Technologies Used:
- Java
- Spring Core
- Spring JDBC
- Maven
- MySQL

Architecture:
Controller -> Service -> Repository -> Database

Project Structure:

```text
employeeManagementSystem
|
|-- src
|   |-- main
|       |-- java
|       |   |-- com.example.employeeManagementSystem
|       |       |-- App.java
|       |       |
|       |       |-- Beans
|       |       |   |-- Employee.java
|       |       |
|       |       |-- Controller
|       |       |   |-- EmployeeController.java
|       |       |
|       |       |-- Repository
|       |       |   |-- EmployeeRepository.java
|       |       |   |-- EmployeeRepositoryImpl.java
|       |       |
|       |       |-- Services
|       |           |-- EmployeeService.java
|       |           |-- EmployeeServiceImpl.java
|       |
|       |-- resources
|           |-- Beans.xml
|
|-- pom.xml
|-- README.md
```

Author:
 Enjam Loshan Reddy
