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
