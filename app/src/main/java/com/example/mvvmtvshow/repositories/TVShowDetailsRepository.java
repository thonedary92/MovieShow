package com.example.mvvmtvshow.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmtvshow.network.ApiClient;
import com.example.mvvmtvshow.network.ApiService;
import com.example.mvvmtvshow.responses.TVShowsDetailsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TVShowDetailsRepository {
    private final ApiService apiService;

    public TVShowDetailsRepository() {
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<TVShowsDetailsResponse> getTVShowsDetails(String tvShowId){
        MutableLiveData<TVShowsDetailsResponse> data = new MutableLiveData<>();
        apiService.getTVShowDetails(tvShowId).enqueue(new Callback<TVShowsDetailsResponse>() {
            @Override
            public void onResponse(Call<TVShowsDetailsResponse> call,@NonNull Response<TVShowsDetailsResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<TVShowsDetailsResponse> call,@NonNull Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
