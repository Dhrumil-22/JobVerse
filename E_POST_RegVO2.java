package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Post2")
public class E_POST_RegVO2 {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name="RegId")
    private int id;
    
    @Column(name="e_userName")
    private String username;
    
    @Column(name="e_Technology")
    private String technology;
    
    @Column(name="e_CompanyName")
    private String companyName;
    
    @Column(name="e_Experience")
    private String experience;
    
    @Column(name="e_Location")
    private String location;
    
    @Column(name="e_JobRole")
    private String jobRole;
    
    @Column(name="e_Department")
    private String department;
    
    @Column(name="e_EmploymentType")
    private String employmentType;
    
    @Column(name="e_CompanyWebsite")
    private String companyWebsite;
    
    @Column(name="e_CompanyAddress")
    private String companyAddress;
    
    @Column(name="e_ContactPerson")
    private String contactPerson;
    
    @Column(name="e_ContactEmail")
    private String contactEmail;
    
    @Column(name="e_ContactPhone")
    private String contactPhone;
    
    @Column(name="e_JobDescription")
    private String jobDescription;
    
    @Column(name="e_EssentialSkills")
    private String essentialSkills;
    
    @Column(name="e_AdditionalRequirements")
    private String additionalRequirements;
    
    @Column(name="e_MinEducation")
    private String minEducation;
    
    @Column(name="e_PreferredQualification")
    private String preferredQualification;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getEssentialSkills() {
		return essentialSkills;
	}

	public void setEssentialSkills(String essentialSkills) {
		this.essentialSkills = essentialSkills;
	}

	public String getAdditionalRequirements() {
		return additionalRequirements;
	}

	public void setAdditionalRequirements(String additionalRequirements) {
		this.additionalRequirements = additionalRequirements;
	}

	public String getMinEducation() {
		return minEducation;
	}

	public void setMinEducation(String minEducation) {
		this.minEducation = minEducation;
	}

	public String getPreferredQualification() {
		return preferredQualification;
	}

	public void setPreferredQualification(String preferredQualification) {
		this.preferredQualification = preferredQualification;
	}
    
    
		
}
