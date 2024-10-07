package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="employer")
public class E_RegVO {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="RegId")
    private int id;

    @Column(name="e_FirstName")
    private String firstName;

    @Column(name="e_LastName")
    private String lastName;

    @Column(name="e_Email")
    private String Email;

    @Column(name="e_UserName")
    private String userName;

    @Column(name="e_Password")
    private String password;

    @Column(name="e_Best")
    private String Best;

    @Column(name="e_Industry")
    private String industry;

    @Column(name="e_CompanyName")
    private String companyName;

    @Column(name="e_CurrentCity")
    private String currentCity;

    @Column(name="e_CurrentState")
    private String currentState;

    // Add the profile picture column
    @Lob // Large Object annotation to store large binary data
    @Column(name="e_ProfilePic")
    private byte[] profilePic;

    // Getters and setters for the profile picture field
    public byte[] getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(byte[] profilePic) {
        this.profilePic = profilePic;
    }

    // Existing getters and setters

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
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
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

    public String getBest() {
        return Best;
    }

    public void setBest(String best) {
        Best = best;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }
}
