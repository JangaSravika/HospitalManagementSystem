package com.project.hospital;

import java.sql.*;
import java.util.Scanner;

public class HospitalManagementSystem {
    private static final String URL = "jdbc:mysql://localhost:3306/hospital";
    private static final String USER = "root";
    private static final String PASSWORD = "2731"; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            while (true) {
                System.out.println("\n--- Hospital Management Menu ---");
                System.out.println("1. Add Doctor");
                System.out.println("2. Add Patient");
                System.out.println("3. Book Appointment");
                System.out.println("4. View Doctors");
                System.out.println("5. View Patients");
                System.out.println("6. View Appointments");
                System.out.println("7. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine(); 

                switch (choice) {
                    case 1:
                        System.out.print("Doctor ID: ");
                        int did = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Name: ");
                        String dname = sc.nextLine();
                        System.out.print("Specialization: ");
                        String spec = sc.nextLine();

                        String sql1 = "INSERT INTO doctor VALUES (?, ?, ?)";
                        try (PreparedStatement ps = con.prepareStatement(sql1)) {
                            ps.setInt(1, did);
                            ps.setString(2, dname);
                            ps.setString(3, spec);
                            ps.executeUpdate();
                            System.out.println("Doctor added successfully.");
                        }
                        break;

                    case 2:
                        System.out.print("Patient ID: ");
                        int pid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Name: ");
                        String pname = sc.nextLine();
                        System.out.print("Disease: ");
                        String dis = sc.nextLine();

                        String sql2 = "INSERT INTO patient VALUES (?, ?, ?)";
                        try (PreparedStatement ps = con.prepareStatement(sql2)) {
                            ps.setInt(1, pid);
                            ps.setString(2, pname);
                            ps.setString(3, dis);
                            ps.executeUpdate();
                            System.out.println("Patient added successfully.");
                        }
                        break;

                    case 3:
                        System.out.print("Doctor ID: ");
                        int apptDocId = sc.nextInt();
                        System.out.print("Patient ID: ");
                        int apptPatId = sc.nextInt();

                        String sql3 = "INSERT INTO appointment (doctor_id, patient_id) VALUES (?, ?)";
                        try (PreparedStatement ps = con.prepareStatement(sql3)) {
                            ps.setInt(1, apptDocId);
                            ps.setInt(2, apptPatId);
                            ps.executeUpdate();
                            System.out.println("Appointment booked.");
                        }
                        break;

                    case 4:
                        System.out.println("Doctors List:");
                        try (Statement st = con.createStatement();
                             ResultSet rs = st.executeQuery("SELECT * FROM doctor")) {
                            while (rs.next()) {
                                System.out.println(rs.getInt("id") + " - " + rs.getString("name") +
                                        " (" + rs.getString("specialization") + ")");
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Patients List:");
                        try (Statement st = con.createStatement();
                             ResultSet rs = st.executeQuery("SELECT * FROM patient")) {
                            while (rs.next()) {
                                System.out.println(rs.getInt("id") + " - " + rs.getString("name") +
                                        " [" + rs.getString("disease") + "]");
                            }
                        }
                        break;

                    case 6:
                        System.out.println("Appointments List:");
                        String sql6 = "SELECT a.id, d.name AS doctor, p.name AS patient " +
                                      "FROM appointment a " +
                                      "JOIN doctor d ON a.doctor_id = d.id " +
                                      "JOIN patient p ON a.patient_id = p.id";
                        try (Statement st = con.createStatement();
                             ResultSet rs = st.executeQuery(sql6)) {
                            while (rs.next()) {
                                System.out.println("Appointment ID: " + rs.getInt("id") +
                                        " | Doctor: " + rs.getString("doctor") +
                                        " | Patient: " + rs.getString("patient"));
                            }
                        }
                        break;

                    case 7:
                        System.out.println("THANKYOU!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

