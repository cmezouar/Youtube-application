package com.example.kimbe.youtube.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kimbe.youtube.R;
import com.example.kimbe.youtube.adapters.search;
import com.example.kimbe.youtube.models.Item;
import com.squareup.picasso.Picasso;

/**
 * Created by kimbe on 10/03/2018.
 */

public class VideosViewHolder extends RecyclerView.ViewHolder{
    private TextView title;
    private ImageView imageyoutube;
    private String url;


    public VideosViewHolder(View itemView){
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        imageyoutube = (ImageView) itemView.findViewById(R.id.imageyoutube);
    }

    public void bind(final Item video, final search clicklistener) {
        title.setText(video.getSnippet().getTitle());
        url = video.getSnippet().getThumbnails().getHigh().getUrl();
        Picasso.get().load(url).into(imageyoutube);
        imageyoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicklistener.onVideoClickListener(video);
            }
        });
    }
}
