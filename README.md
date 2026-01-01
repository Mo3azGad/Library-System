# Library Management System (OOP – Java)

##  Project Overview
This project is a **console-based Library Management System** developed using **Java** to demonstrate core **Object-Oriented Programming (OOP)** concepts.  
The system allows managing books, members, borrowing and returning operations, and tracking borrowed books with late fee calculation.

This project is developed as part of the **Object Oriented Programming (OOP) course final project**.

---

##  Features
- Add and remove books
- Search books by title or author
- Borrow and return books
- Track book availability
- Display currently borrowed books
- Calculate late fees based on borrow duration
- Console-based user interaction

---

##  OOP Concepts Used
- **Encapsulation** (private attributes with getters/setters)
- **Inheritance** (`StudentMember` extends `Member`)
- **Polymorphism** (overridden `calculateFee()` method)
- **Interfaces** (`Searchable`)
- **Composition** (Loan contains Book and Member)

---

## 📂 Project Structure

library_system_
│
├── Book.java
├── Member.java
├── StudentMember.java
├── Loan.java
├── LibraryManager.java
├── Searchable.java
├── Main.java
│
├── BookTest.java
├── MemberTest.java
├── LoanTest.java
├── LibraryManagerTest.java


---

## 📐 UML Diagrams
The project includes the following UML diagrams:
- **Class Diagram**
- **Use Case Diagram**

These diagrams are included in the documentation folder and the project report.

---

## 🧪 Unit Testing
JUnit tests are written to verify:
- Book creation and availability
- Member and StudentMember fee calculation
- Loan creation, return logic, and borrow date handling
- Borrowing and returning books
- Late fee calculation logic

JUnit 5 is used for testing.

---

## 🛠️ Technologies Used
- Java
- NetBeans IDE
- JUnit 5
- Git & GitHub
- GitHub Projects (Kanban Board)

---

## ▶️ How to Run the Project
1. Open the project in **NetBeans**
2. Run the `Main` class
3. Use the console menu to interact with the system

---

## 📋 Project Management
A **Kanban Board** is created using **GitHub Projects** to manage tasks and track progress throughout the development process.

---

