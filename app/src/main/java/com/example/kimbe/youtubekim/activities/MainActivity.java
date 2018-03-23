package com.example.kimbe.youtubekim.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kimbe.youtubekim.R;
import com.example.kimbe.youtubekim.adapters.VideosRecyclerAdapter;
import com.example.kimbe.youtubekim.adapters.search;
import com.example.kimbe.youtubekim.client.YoutubeClient;
import com.example.kimbe.youtubekim.models.Item;
import com.example.kimbe.youtubekim.models.Results;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    Results repos;
    private EditText search;
    private String wordsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeRecyclerView();

        Button send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                search= findViewById(R.id.search);
                wordsearch = search.getText().toString();
                System.out.println("SEARCH WORD  "+ wordsearch);

                Retrofit.Builder builder = new Retrofit.Builder()
                        .baseUrl("https://www.googleapis.com/youtube/v3/")
                        .addConverterFactory(GsonConverterFactory.create());

                Retrofit retrofit = builder.build();
                YoutubeClient client = retrofit.create(YoutubeClient.class);
                Call<Results> callresult = client.getVideos(wordsearch);

                callresult.enqueue(new Callback<Results>() {
                    @Override
                    public void onResponse(Call<Results> call, Response<Results> response) {
                        repos = response.body();
                        recyclerView.setAdapter(new VideosRecyclerAdapter(repos.getItems(), new search(){

                            @Override
                            public void onVideoClickListener(Item video) {
                                String videoIDtext= video.getId().getVideoId();
                                String description = video.getSnippet().getDescription();
                                String title = video.getSnippet().getTitle();
                                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                                intent.putExtra("ID_VIDEO", videoIDtext);
                                intent.putExtra("DESC", description);
                                intent.putExtra("TITLE", title);
                                System.out.println("DNA SMAIN ACTIVITY VIDEOID "+videoIDtext);
                                System.out.print("dessc "+description);
                                startActivity(intent);
                            }

                        }));
                    }
                    @Override
                    public void onFailure(Call<Results> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "error : (", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/youtube/v3/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        YoutubeClient client = retrofit.create(YoutubeClient.class);
        Call<Results> callresult = client.getVideos(wordsearch);

        callresult.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                repos = response.body();
                recyclerView.setAdapter(new VideosRecyclerAdapter(repos.getItems(), new search(){

                    @Override
                    public void onVideoClickListener(Item video) {
                        String videoIDtext= video.getId().getVideoId();
                        String description = video.getSnippet().getDescription();
                        String title = video.getSnippet().getTitle();
                        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                        intent.putExtra("ID_VIDEO", videoIDtext);
                        intent.putExtra("DESC", description);
                        intent.putExtra("TITLE", title);
                        startActivity(intent);
                    }

                }));
            }
            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error : (", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initializeRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
