package com.example.tindermockroomdatabase.ui.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "profiles")
public class ProfileEntity {

    @ColumnInfo
    @PrimaryKey
    @NonNull
    private String email;

    @ColumnInfo
    private String name;

    @ColumnInfo
    private String birthday;

    @ColumnInfo
    private String gender;

    @ColumnInfo
    private String school;

    @ColumnInfo
    private boolean genderConsent;

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileEntity that = (ProfileEntity) o;
        return genderConsent == that.genderConsent &&
                email.equals(that.email) &&
                name.equals(that.name) &&
                birthday.equals(that.birthday) &&
                gender.equals(that.gender) &&
                school.equals(that.school);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, birthday, gender, school, genderConsent);
    }

    @Override
    public String toString() {
        return "ProfileEntity{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", school='" + school + '\'' +
                ", genderConsent=" + genderConsent +
                '}';
    }
}
