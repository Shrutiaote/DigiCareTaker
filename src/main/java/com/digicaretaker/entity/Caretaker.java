package com.digicaretaker.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "caretakers")
public class Caretaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int caretakerId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(nullable = false)
    private int experience;

    private String qualification;

    private String skills;

    private String availability;

    @Column(name = "hourly_rate")
    private double hourlyRate;

    @Column(length = 1000)
    private String about;

    @Column(name = "verification_status")
    private String verificationStatus;

    public Caretaker() {
    }

    public Caretaker(User user, int experience, String qualification,
                     String skills, String availability,
                     double hourlyRate, String about,
                     String verificationStatus) {

        this.user = user;
        this.experience = experience;
        this.qualification = qualification;
        this.skills = skills;
        this.availability = availability;
        this.hourlyRate = hourlyRate;
        this.about = about;
        this.verificationStatus = verificationStatus;
    }

    public int getCaretakerId() {
        return caretakerId;
    }

    public void setCaretakerId(int caretakerId) {
        this.caretakerId = caretakerId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }
}