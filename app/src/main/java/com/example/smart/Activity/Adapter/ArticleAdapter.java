package com.example.smart.Activity.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smart.Activity.Domain.ArticleModel;
import com.example.smart.Activity.RecycleViewInterface;
import com.example.smart.R;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.MyViewHolder> {
    private final RecycleViewInterface recycleViewInterface;
    Context context;
    ArrayList<ArticleModel> articleModels;
    public ArticleAdapter(Context context, ArrayList<ArticleModel> articleModels,RecycleViewInterface recycleViewInterface){
        this.context = context;
        this.articleModels = articleModels;
        this.recycleViewInterface=recycleViewInterface;

    }


    @NonNull
    @Override
    public ArticleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.viewholder_article,parent,false);
        return new ArticleAdapter.MyViewHolder(view,recycleViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleAdapter.MyViewHolder holder, int position) {
        holder.textView.setText(articleModels.get(position).getArticleName());
        holder.imageView.setImageResource(articleModels.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return articleModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        TextView description;


        public MyViewHolder(@NonNull View itemView,RecycleViewInterface recycleViewInterface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.vebinar_pic);
            textView = itemView.findViewById(R.id.vebinar_name);
            description = itemView.findViewById(R.id.description);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recycleViewInterface!=null)
                    {
                        int pos = getAdapterPosition();
                        if (pos!=RecyclerView.NO_POSITION){
                            recycleViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
