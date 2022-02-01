package com.example.mvvmtvshow.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mvvmtvshow.dao.TVShowDao;
import com.example.mvvmtvshow.models.TVShow;

@Database(entities = TVShow.class,version = 1,exportSchema = false)
public abstract class TVShowsDatabase extends RoomDatabase {
    private static TVShowsDatabase tvShowsDatabase;

    public static synchronized TVShowsDatabase getTvShowsDatabase(Context context){
        if (tvShowsDatabase == null){
            tvShowsDatabase = Room.databaseBuilder(
                    context,TVShowsDatabase.class,"tv_show_db").build();

        }
        return tvShowsDatabase;
    }

    public abstract TVShowDao tvShowDao();
}
