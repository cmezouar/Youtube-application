package com.example.kimbe.youtubekim.client;

import com.example.kimbe.youtubekim.models.Results;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by kimbe on 10/03/2018.
 */

public interface YoutubeClient {

    @GET("search?part=snippet&&type=videos&key=AIzaSyBGPyg9-tN9skjfRYfduADiZhpUPdMolb4")
    Call<Results>  getVideos(@Query("q") String wordsearch);
}
