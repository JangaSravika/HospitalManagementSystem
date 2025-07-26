# 🏥 Hospital Management System

A console-based application built with **JAVA**, **JDBC**, and **MySQL** to manage hospital operations such as managing doctors, patients, and appointments. This project is menu-driven and allows users to interact with the system using simple text-based options.

## 🚀 Why This Project?

In a world where hospital data must be fast, reliable, and structured, this project showcases how we can manage healthcare operations using **pure Java and relational databases** — **no frameworks**, just **clean code and solid logic**.

## 🚀 Project Highlights

- 🎯 Console-based interactive menu system
- 👨‍⚕️ Add & view doctor records
- 🧑‍🦰 Register & view patient records
- 📅 Book & list doctor-patient appointments
- 🔌 MySQL database integration via JDBC

## 🛠 Technologies Used

| Tool/Technology | Purpose                |
|-----------------|------------------------|
| Java (JDK 11+)   | Application logic      |
| JDBC             | MySQL database access  |
| MySQL 8.0+       | Database backend       |
| Eclipse IDE      | Java development       |
| MySQL Connector  | JDBC driver (.jar)     |

## ✨ Features

🔹 **Add Doctor** – Save new doctor profiles  
🔹 **Add Patient** – Register patient details  
🔹 **Book Appointment** – Link doctors and patients  
🔹 **View Doctors** – Display all registered doctors  
🔹 **View Patients** – Display all patient records  
🔹 **View Appointments** – Show doctor–patient appointments  
🔹 **Menu-Driven UI** – Simple terminal-based interaction  

## 🗂 Project Structure

HospitalManagementSystem/
├── com/project/hospital/
│ ├── HospitalManagementSystem.java
│ ├── Doctor.java
│ ├── Patient.java
│ ├── Appointment.java
└── mysql-connector-java-8.x.xx.jar

## 🧩 Database Structure

### 📁 Database: `hospital`

CREATE DATABASE hospital;
USE hospital;

CREATE TABLE doctor (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    specialization VARCHAR(100)
);


CREATE TABLE patient (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    disease VARCHAR(100)
);

CREATE TABLE appointment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    doctor_id INT,
    patient_id INT,
    FOREIGN KEY (doctor_id) REFERENCES doctor(id),
    FOREIGN KEY (patient_id) REFERENCES patient(id)
);

**💻 How to Run the Project
✅ Prerequisites**

Java JDK installed (11 or above)
MySQL Server installed and running
MySQL Connector JAR file
Eclipse or any Java IDE

**🔧 Setup Steps**

1.Clone or download this project.

2.Create a MySQL database named hospital.

3.Run the hospital.sql script to create required tables.

4.Open the project in Eclipse.

5.Add the MySQL JDBC driver (.jar) to your project's build path.

6.Update database credentials in the Java file if needed:
    String URL = "jdbc:mysql://localhost:3306/hospital";
    String USER = "root";
    String PASSWORD = "your_mysql_password";
    
7.Run **HospitalManagementSystem.java**.

