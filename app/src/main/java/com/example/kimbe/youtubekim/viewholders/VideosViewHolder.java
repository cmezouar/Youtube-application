package com.example.kimbe.youtubekim.viewholders;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kimbe.youtubekim.R;
import com.example.kimbe.youtubekim.activities.MainActivity;
import com.example.kimbe.youtubekim.activities.SecondActivity;
import com.example.kimbe.youtubekim.adapters.search;
import com.example.kimbe.youtubekim.models.Item;
import com.squareup.picasso.Picasso;

import static android.content.ContentValues.TAG;

/**
 * Created by kimbe on 10/03/2018.
 */

public class VideosViewHolder extends RecyclerView.ViewHolder{
    private TextView title;
    //private TextView videoID;
    private ImageView imageyoutube;
    private String url;


    public VideosViewHolder(View itemView){
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        //videoID = (TextView) itemView.findViewById(R.id.videoID);
        imageyoutube = (ImageView) itemView.findViewById(R.id.imageyoutube);
    }

    public void bind(final Item video, final search clicklistener) {
        title.setText(video.getSnippet().getTitle());
        //videoID.setText(video.getId().getVideoId());
        url = video.getSnippet().getThumbnails().getHigh().getUrl();
        Picasso.get().load(url).into(imageyoutube);
        imageyoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicklistener.onVideoClickListener(video);
            }
        });
        //System.out.println(videoID.getText().toString());
    }
}
