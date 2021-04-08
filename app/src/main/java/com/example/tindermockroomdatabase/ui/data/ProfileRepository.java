package com.example.tindermockroomdatabase.ui.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.tindermockroomdatabase.Profile;
import com.example.tindermockroomdatabase.ui.data.dao.ProfileDao;
import com.example.tindermockroomdatabase.ui.data.database.Database;
import com.example.tindermockroomdatabase.ui.data.entities.ProfileEntity;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class ProfileRepository {

    private ProfileDao mProfileDao;
    private LiveData<List<ProfileEntity>> mProfilesList;

    private final Executor mExecutor;

    public ProfileRepository(Application application, ExecutorService executor){
        Database database = Database.getDatabase(application);
        mExecutor = executor;
        mProfileDao = database.profileDao();
        mProfilesList = mProfileDao.getProfiles();
    }

    public LiveData<List<ProfileEntity>> getAllProfiles(){ return mProfilesList;}

    public void addProfile(ProfileEntity profileEntity){
        mExecutor.execute(()->mProfileDao.insertProfile(profileEntity));
    }
}
