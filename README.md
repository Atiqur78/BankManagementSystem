# Bank Management System

## Introduction

The Bank Management System is a Java-based application designed to facilitate banking operations such as account creation, deposit, withdrawal, and more. This system provides a convenient way for bank customers to manage their accounts and transactions.

## Features

- **Account Creation:** Users can create different types of accounts, including Savings, Current, Recurring, and Fixed Deposit accounts.

- **Transaction History:** The system keeps track of all transactions, allowing users to view their transaction history.

- **Balance Management:** Users can deposit and withdraw money, and the system ensures that account balances are updated accurately.

- **Card and PIN Management:** The system generates and manages card numbers and PINs for account holders.

- **Service Enrollment:** Users can enroll in additional services like ATM cards, internet banking, mobile banking, alerts, cheque books, and e-statements.

## Technologies Used

- Java
- MySQL (or your chosen database system)
- AWS RDS(Cloud database)
- Swing (for the graphical user interface)

## Setup Instructions

1. **Database Configuration:** Configure the database connection in the `Conn` class with your database credentials and connection details.

   - Open the `Conn.java` file located in the project's source code.

   - Replace the following placeholders with your actual database connection details in the `Conn` constructor:

     ```java
     String dbUrl = "jdbc:mysql://<RDS_Endpoint>:<Port>/<Database_Name>";
     String dbUser = "<Your_DB_Username>";
     String dbPassword = "<Your_DB_Password>";
     ```

   - Save the file.

3. **Compile and Run:** Compile and run the Java application.

4. Download Jar file  jcalender and my sql connector
   [Downlaod Jar File](https://drive.google.com/drive/folders/15yul-CCe1OSJPuH2Qh9LebSNdsI6PvEp?usp=sharing)

```shell
javac *.java
java Main
