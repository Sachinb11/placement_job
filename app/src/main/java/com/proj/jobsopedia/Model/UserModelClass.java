package com.proj.jobsopedia.Model;

public class UserModelClass {
    public String FullName, Email, PhoneNumber, Qualification, Age;

    public UserModelClass(){};

    public UserModelClass(String fullName, String email, String phoneNumber, String qualification, String age) {
        FullName = fullName;
        Email = email;
        PhoneNumber = phoneNumber;
        Qualification = qualification;
        Age = age;
    }
}
