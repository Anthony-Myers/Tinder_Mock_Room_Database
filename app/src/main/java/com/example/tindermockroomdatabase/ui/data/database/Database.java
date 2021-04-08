package com.example.tindermockroomdatabase.ui.data.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tindermockroomdatabase.ui.data.dao.ProfileDao;
import com.example.tindermockroomdatabase.ui.data.entities.ProfileEntity;

@androidx.room.Database(entities = {ProfileEntity.class}, version = 1)
public abstract class Database extends RoomDatabase {
    public static final String NAME = "DataBase";
    private static Database INSTANCE;

    public static Database getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Database.class, Database.NAME).fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract ProfileDao profileDao();
}
