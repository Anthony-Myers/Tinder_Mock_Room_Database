package com.example.tindermockroomdatabase.ui.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.tindermockroomdatabase.ui.data.entities.ProfileEntity;

import java.util.List;

@Dao
public abstract class ProfileDao {
    @Query("SELECT * FROM profiles")
    public abstract LiveData<List<ProfileEntity>> getProfiles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertProfile(ProfileEntity profile);

    @Query("DELETE FROM profiles")
    public abstract void deleteProfiles();
}
