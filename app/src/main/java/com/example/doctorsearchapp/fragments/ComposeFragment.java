package com.example.doctorsearchapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doctorsearchapp.MainActivity;
import com.example.doctorsearchapp.R;
import com.example.doctorsearchapp.models.Reviews;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;


public class ComposeFragment extends Fragment {

    Button postBtn;
    TextView reviewDescription;

    public ComposeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_compose, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        postBtn = view.findViewById(R.id.postBT);
        reviewDescription = view.findViewById(R.id.tvReviewDescription);

        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (reviewDescription.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(),"Couldn't save the review", Toast.LENGTH_SHORT).show();
                } else {
                    saveReview(reviewDescription.getText().toString(), ParseUser.getCurrentUser());
                }
            }
        });
    }

    private void saveReview(String newReview, ParseUser currUser)
    {
        Reviews review = new Reviews();
        review.setReview(newReview);
        review.setUser(currUser);

        review.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                reviewDescription.setText("");
                MainActivity activity = (MainActivity) getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.flContainer,new DetailFragment()).commit();
            }
        });
    }
}