package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "job_seeker")
public class JS_RegVO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RegId")
    private int id;

    @Column(name = "js_FirstName")
    private String firstName;

    @Column(name = "js_LastName")
    private String lastName;

    @Column(name = "js_Email")
    private String email;  // Changed to camelCase

    @Column(name = "js_UserName")
    private String userName;

    @Column(name = "js_Password")
    private String password;

    @Column(name = "js_Education")
    private String education;

    @Column(name = "js_Best")
    private String best;  // Changed to camelCase

    @Column(name = "js_CurrentCity")
    private String currentCity;

    @Column(name = "js_CurrentState")
    private String currentState;  // Changed to camelCase

    @Lob // Large Object annotation to store large binary data
    @Column(name = "js_ProfilePic")
    private byte[] profilePic;

    @Lob // Large Object annotation to store large binary data
    @Column(name = "js_Resume")
    private byte[] resume;  // Changed to camelCase

    // Getters and Setters
    public byte[] getResume() {
        return resume;  // Updated to camelCase
    }

    public void setResume(byte[] resume) {
        this.resume = resume;  // Updated to camelCase
    }

    public byte[] getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(byte[] profilePic) {
        this.profilePic = profilePic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return email;  // Updated to camelCase
    }

    public void setEmail(String email) {
        this.email = email;  // Updated to camelCase
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getBest() {
        return best;  // Updated to camelCase
    }

    public void setBest(String best) {
        this.best = best;  // Updated to camelCase
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getCurrentState() {
        return currentState;  // Updated to camelCase
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;  // Updated to camelCase
    }
}
