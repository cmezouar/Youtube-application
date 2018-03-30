package com.example.kimbe.youtube.client;

import com.example.kimbe.youtube.models.Results;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by kimbe on 10/03/2018.
 */

public interface YoutubeClient {

    @GET("search?part=snippet&&type=videos&key=AIzaSyBGPyg9-tN9skjfRYfduADiZhpUPdMolb4&maxResults=45")
    Call<Results>  getVideos(@Query("q") String wordsearch);
}
