package com.project.hospital;

public class Patient {
    private int id;
    private String name;
    private String disease;

    // Constructor
    public Patient(int id, String name, String disease) {
        this.id = id;
        this.name = name;
        this.disease = disease;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDisease() {
        return disease;
    }

    // Display Method
    public void displayPatientDetails() {
        System.out.println("Patient ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Disease: " + disease);
        System.out.println("---------------------------");
    }
}

