package com.example.tindermockroomdatabase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.tindermockroomdatabase.ui.ProfileApplication;
import com.example.tindermockroomdatabase.ui.data.ProfileRepository;
import com.example.tindermockroomdatabase.ui.data.entities.ProfileEntity;

import java.util.List;

public class ProfileViewModel extends AndroidViewModel {
    private Profile curProfile = new Profile();
    private ProfileRepository mProfileRepository;
    private LiveData<List<ProfileEntity>> mAllProfiles;

    public ProfileViewModel(@NonNull Application application) {
        super(application);
        mProfileRepository = new ProfileRepository(application, ((ProfileApplication) application).getExecutorService());
        mAllProfiles = mProfileRepository.getAllProfiles();
    }

    public void setProfileEmail(String email) {
        curProfile.setEmail(email);
    }

    public String getProfileEmail() {
        return curProfile.getEmail();
    }

    public void setProfileName(String name) {
        curProfile.setName(name);
    }

    public String getProfileName() {
        return curProfile.getName();
    }

    public void setProfileBirthDay(String birthDay) {
        curProfile.setBirthDay(birthDay);
    }

    public String getProfileBirthDay() {
        return curProfile.getBirthDay();
    }

    public void setProfileBirthMonth(String birthMonth) {
        curProfile.setBirthMonth(birthMonth);
    }

    public String getProfileBirthMonth() {
        return curProfile.getBirthMonth();
    }

    public void setProfileBirthYear(String birthYear) {
        curProfile.setBirthYear(birthYear);
    }

    public String getProfileBirthYear() {
        return curProfile.getBirthYear();
    }

    public void setProfileGender(String gender) {
        curProfile.setGender(gender);
    }

    public String getProfileGender() {
        return curProfile.getGender();
    }

    public void setProfileSchool(String school) {
        curProfile.setSchool(school);
    }

    public String getProfileSchool() {
        return curProfile.getSchool();
    }

    public void setProfileGenderConsent(boolean consent) {
        curProfile.setGenderConsent(consent);
    }

    public boolean getProfileGenderConsent() {
        return curProfile.isGenderConsent();
    }

    public void createPerson() {
        ProfileEntity newProfileEntity = new ProfileEntity();
        newProfileEntity.setEmail(curProfile.getEmail());
        newProfileEntity.setName(curProfile.getName());
        newProfileEntity.setBirthday(curProfile.getBirthMonth()+"/"+curProfile.getBirthDay()+"/"+curProfile.getBirthYear());
        newProfileEntity.setGender(curProfile.getGender());
        newProfileEntity.setGenderConsent(curProfile.isGenderConsent());
        newProfileEntity.setSchool(curProfile.getSchool());

        mProfileRepository.addProfile(newProfileEntity);
    }

    public void clearProfile(){
        curProfile.setEmail("");
        curProfile.setName("");
        curProfile.setBirthDay("");
        curProfile.setBirthMonth("");
        curProfile.setBirthYear("");
        curProfile.setGenderConsent(false);
        curProfile.setGender("");
        curProfile.setSchool("");
    }

    public LiveData<List<ProfileEntity>> getListOfProfiles() {
        return mAllProfiles;
    }
}
