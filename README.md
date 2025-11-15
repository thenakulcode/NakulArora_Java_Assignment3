Student Result Management System – Java

This project implements a simple Student Result Management System using core Java and exception-handling concepts. It collects student details, validates subject marks, computes averages, and displays final results. The system demonstrates the use of custom exceptions, try–catch handling, throw, throws, and the finally clause.

Features

    Add multiple students

    Validate marks using a custom InvalidMarksException

    Handle invalid inputs and runtime errors

    Calculate average marks and determine pass/fail status

    Search and display student details by roll number

    Demonstrates clean OOP structure with multiple classes

Concepts Used

    Java Classes & Objects

    Arrays of Objects

    Custom Exception Handling

    try–catch–finally blocks

    throw and throws keywords

Input handling using Scanner

Project Structure

    ├── InvalidMarksException.java
    ├── Student.java
    └── ResultManager.java


InvalidMarksException.java
Custom checked exception for validating marks.

Student.java
Stores student data, validates marks, calculates average, and displays results.

ResultManager.java
Menu-driven class for adding and viewing student information.

How to Run

Clone the repository

Compile all .java files:

    javac *.java


  Run the program:

    java ResultManager

Sample Menu 

    1. Add Student
    2. Show Student Details
    3. Exit

Requirements

    Java 8 or above

    Command-line environment

Author

    Nakul
    B.Tech CSE
