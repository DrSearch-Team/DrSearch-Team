package com.example.doctorsearchapp;

import static com.example.doctorsearchapp.LoginActivity.TAG;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.doctorsearchapp.models.Reviews;
import com.example.doctorsearchapp.models.Users;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import org.w3c.dom.Text;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>{

    private List<Reviews> reviews;
    private Context context;

    public ReviewAdapter(List<Reviews> reviews, Context context)
    {
        this.reviews = reviews;
        this.context = context;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.review_layout,parent,false);

        return new ReviewViewHolder(view);
    }

    public void clear()
    {
        reviews.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Reviews> newReviews)
    {
        reviews.addAll(newReviews);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        Reviews review = reviews.get(position);
        holder.bind(review);
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    class ReviewViewHolder extends RecyclerView.ViewHolder
    {
        private TextView usernameTv;
        private TextView reviewTv;
        private TextView usernameProfile;
        private TextView passwordProfile;
        private ImageView profilePic;
        private ImageView profileFragPic;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            usernameTv = itemView.findViewById(R.id.usernameTV);
            reviewTv = itemView.findViewById(R.id.reviewTV);

            // Username and something
            usernameProfile = itemView.findViewById(R.id.tvUsername);
            passwordProfile = itemView.findViewById(R.id.tvUserId);

            // exp
            profileFragPic = itemView.findViewById(R.id.ivProfileImage);
            profilePic = itemView.findViewById(R.id.profilePictureIV);
        }

        public void bind(Reviews review)
        {
            Users user = new Users(review.getUser());
            usernameTv.setText(user.getUsername());
            reviewTv.setText(review.getReview());
            Log.i("ReviewAdapter", "Post: " + review.getReview() + ", ProfilePic:" + user.getProfilePic());

            // exp
            Glide.with(context).load(user.getProfilePic().getUrl()).into(profileFragPic);
            Glide.with(context).load(user.getProfilePic().getUrl()).into(profilePic);
        }
    }
}
