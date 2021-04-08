package com.example.tindermockroomdatabase;

public class Profile {
    private String email = "", name = "", birthDay = "",
            birthMonth = "", birthYear = "", gender = "",
            school = "";

    private boolean genderConsent = false;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthday) {
        this.birthDay = birthday;
    }

    public String getBirthYear() { return birthYear; }

    public void setBirthYear(String birthYear) { this.birthYear = birthYear; }

    public String getBirthMonth() { return birthMonth; }

    public void setBirthMonth(String birthMonth) { this.birthMonth = birthMonth; }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public boolean isGenderConsent() { return genderConsent; }

    public void setGenderConsent(boolean genderConsent) { this.genderConsent = genderConsent; }
}
