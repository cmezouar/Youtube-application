package com.example.kimbe.youtube.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.kimbe.youtube.models.Item;
import com.example.kimbe.youtube.viewholders.VideosViewHolder;
import com.example.kimbe.youtube.R;
import java.util.List;

/**
 * Created by kimbe on 10/03/2018.
 */

public class VideosRecyclerAdapter extends RecyclerView.Adapter<VideosViewHolder>  {

    private List<Item> videos;
    private search clicklistener;

    public VideosRecyclerAdapter(List<Item> videos, search clicklistener){
        this.videos = videos;
        this.clicklistener = clicklistener;
    }


    public VideosViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return new VideosViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_videos, parent, false));
    }


    public void onBindViewHolder(VideosViewHolder holder, int position){
        holder.bind(videos.get(position),clicklistener);
    }


    public int getItemCount(){
        return videos != null ? videos.size():0;
    }
}

