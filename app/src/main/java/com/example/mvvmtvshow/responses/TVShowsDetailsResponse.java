package com.example.mvvmtvshow.responses;

import com.example.mvvmtvshow.models.TVShowDetails;
import com.google.gson.annotations.SerializedName;

public class TVShowsDetailsResponse {
    @SerializedName("tvShow")
    private TVShowDetails tvShowDetails;

    public TVShowDetails getTvShowDetails() {
        return tvShowDetails;
    }


}
