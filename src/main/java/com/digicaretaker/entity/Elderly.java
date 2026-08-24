package com.digicaretaker.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "elderly")
public class Elderly {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int elderlyId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    private String gender;

    @Column(name = "medical_conditions", length = 1000)
    private String medicalConditions;

    @Column(name = "emergency_contact")
    private String emergencyContact;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(length = 1000)
    private String additionalInformation;

    public Elderly() {
    }

    public Elderly(User user, LocalDate dateOfBirth, String gender,
                   String medicalConditions, String emergencyContact,
                   String bloodGroup, String additionalInformation) {

        this.user = user;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.medicalConditions = medicalConditions;
        this.emergencyContact = emergencyContact;
        this.bloodGroup = bloodGroup;
        this.additionalInformation = additionalInformation;
    }

    public int getElderlyId() {
        return elderlyId;
    }

    public void setElderlyId(int elderlyId) {
        this.elderlyId = elderlyId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMedicalConditions() {
        return medicalConditions;
    }

    public void setMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}