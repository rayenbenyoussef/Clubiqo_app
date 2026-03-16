package com.example.clubiqoapp;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {
    ArrayList<News> news;

    public NewsAdapter(ArrayList<News> news) {
        this.news = news;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NewsHolder holder= new NewsHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,null,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        News news=this.news.get(position);
        holder.title.setText(news.getTitle());
        holder.description.setText(news.getDescription());
        Glide.with(holder.itemView.getContext())
                .load(news.getImg()) // URL from API
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(holder.img);
        holder.infoButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(news.getLink()));
            v.getContext().startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return this.news.size();
    }

    class NewsHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView description;

        ImageView img;
        Button infoButton;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            this.title=itemView.findViewById(R.id.news_title);
            this.description=itemView.findViewById(R.id.news_description);
            this.img=itemView.findViewById(R.id.news_image);
            this.infoButton=itemView.findViewById(R.id.info_button);
        }
    }
}
