package com.proj.jobsopedia.Model;

public class ModelClass {

    private String CompanyName;
    private String Venue;
    private String JobQualification;
    private String Requirements;
    private String Skills;
    private String Description;
    private String JobEmail;
    private String Designation;
    private String Location;
    private String Experience;
    private String Contact;
    private String Date;
    private String Time;

    public ModelClass(){}

    public ModelClass(String companyName, String venue, String time, String jobQualification,
                      String requirements, String skills, String description, String contact,
                      String jobEmail, String date, String designation, String location, String experience) {
        CompanyName = companyName;
        Venue = venue;
        Time = time;
        JobQualification = jobQualification;
        Requirements = requirements;
        Skills = skills;
        Description = description;
        Contact = contact;
        JobEmail = jobEmail;
        Date = date;
        Designation = designation;
        Location = location;
        Experience = experience;
    }

    public String getExperience() {
        return Experience;
    }

    public void setExperience(String experience) {
        Experience = experience;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getVenue() {
        return Venue;
    }

    public void setVenue(String venue) {
        Venue = venue;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getJobQualification() {
        return JobQualification;
    }

    public void setJobQualification(String jobQualification) {
        JobQualification = jobQualification;
    }

    public String getRequirements() {
        return Requirements;
    }

    public void setRequirements(String requirements) {
        Requirements = requirements;
    }

    public String getSkills() {
        return Skills;
    }

    public void setSkills(String skills) {
        Skills = skills;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getJobEmail() {
        return JobEmail;
    }

    public void setJobEmail(String jobEmail) {
        JobEmail = jobEmail;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
