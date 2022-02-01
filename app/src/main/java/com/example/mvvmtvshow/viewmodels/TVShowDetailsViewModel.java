package com.example.mvvmtvshow.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmtvshow.database.TVShowsDatabase;
import com.example.mvvmtvshow.models.TVShow;
import com.example.mvvmtvshow.repositories.TVShowDetailsRepository;
import com.example.mvvmtvshow.responses.TVShowsDetailsResponse;

import io.reactivex.Completable;

public class TVShowDetailsViewModel extends AndroidViewModel {
    private final TVShowDetailsRepository tvShowDetailsRepository;
    private final TVShowsDatabase tvShowsDatabase;

    public TVShowDetailsViewModel(@NonNull Application application) {
        super(application);
        tvShowDetailsRepository =new TVShowDetailsRepository();
        tvShowsDatabase = TVShowsDatabase.getTvShowsDatabase(application);
    }

    public LiveData<TVShowsDetailsResponse> getTVShowDetails(String tvShowId){
        return tvShowDetailsRepository.getTVShowsDetails(tvShowId);
    }

    public Completable addToWatchList(TVShow tvShow){
        return tvShowsDatabase.tvShowDao().addToWatchlist(tvShow);
    }


}
