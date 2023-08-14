package com.example.smart.Activity.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smart.Activity.Domain.Video;
import com.example.smart.Activity.VideoPlayer;
import com.example.smart.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> implements Filterable {
    ArrayList<Video> allvideos;
    ArrayList<Video> getVideos = new ArrayList<>();
    Context context;

    public VideoAdapter(Context ctx, ArrayList<Video> videos){
        this.allvideos = videos;
        this.context = ctx;
        this.getVideos = allvideos;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_view,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        String link = allvideos.get(position).getImageUrl();
        link = link.substring(0, 4) + "s" + link.substring(4, link.length());
        Picasso.get().load(link).into(holder.videoImage);
        holder.title.setText(allvideos.get(position).getTitle());


        holder.vv.setOnClickListener(v -> {
            Bundle b = new Bundle();
            b.putSerializable("videoData", allvideos.get(position));
            Intent intent = new Intent(context, VideoPlayer.class);
            intent.putExtras(b);
            v.getContext().startActivity(intent);

        });
    }
    @Override
    public int getItemCount() {
        return allvideos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView videoImage;
        TextView title;
        View vv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            videoImage = itemView.findViewById(R.id.videoThumbnail);
            title = itemView.findViewById(R.id.videoTitle);
            vv = itemView;

        }
    }
    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if ((constraint==null)|| (constraint.length() == 0)) {
                    filterResults.values = getVideos;
                    filterResults.count = getVideos.size();
                }else{
                    String searchStr = constraint.toString().toLowerCase();
                    List<Video> videos = new ArrayList<>();
                    for (Video videoModel: getVideos){
                        if (videoModel.getTitle().toLowerCase().contains(searchStr))
                        {
                            videos.add(videoModel);
                        }

                    }
                    filterResults.values = videos;
                    filterResults.count = videos.size();
                }
                return filterResults;
            }
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                allvideos = (ArrayList<Video>) filterResults.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }
}
