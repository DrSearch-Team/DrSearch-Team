package com.example.doctorsearchapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>{

    private String[] usernames;
    private String[] reviews;
    private Context context;

    public ReviewAdapter(String[] usernames, String[] reviews, Context context)
    {
        this.usernames = usernames;
        this.reviews = reviews;
        this.context = context;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.review_layout,parent,false);

        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        holder.bind(usernames[position], reviews[position]);
    }

    @Override
    public int getItemCount() {
        return reviews.length;
    }

    class ReviewViewHolder extends RecyclerView.ViewHolder
    {
        private TextView usernameTv;
        private TextView reviewTv;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            usernameTv = itemView.findViewById(R.id.usernameTV);
            reviewTv = itemView.findViewById(R.id.reviewTV);
        }

        public void bind(String username, String review)
        {
            if (username.isEmpty() && review.isEmpty()){
                return;
            }
            usernameTv.setText(username);
            reviewTv.setText(review);
        }

    }
}
