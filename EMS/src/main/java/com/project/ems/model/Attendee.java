package com.project.ems.model;

import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
@Entity
public class Attendee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String firstName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isWhatsapp() {
        return isWhatsapp;
    }

    public void setWhatsapp(boolean whatsapp) {
        isWhatsapp = whatsapp;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    @Column(nullable = false)
    private String lastName;

    private String email;

    @Column(nullable = false)
    private String fullName; // Persisted in the database

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private boolean isWhatsapp;
    @Column(nullable = false)
    private String attendance = "N"; // Default to "N" (not marked)


    // Default constructor required by JPA
    public Attendee() {
    }

    // Parameterized constructor
    public Attendee(String firstName, String lastName, String email, String phone, boolean isWhatsapp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.isWhatsapp = isWhatsapp;
        this.fullName = firstName + " " + lastName; // Automatically setting fullName
    }

    @PrePersist
    @PreUpdate
    private void updateFullName() {
        this.fullName = this.firstName + " " + this.lastName;
    }
}
