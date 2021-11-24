package com.example.doctorsearchapp.fragments;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.doctorsearchapp.HeaderAdapter;
import com.example.doctorsearchapp.R;
import com.example.doctorsearchapp.ReviewAdapter;
import com.example.doctorsearchapp.models.Reviews;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class DetailFragment extends Fragment {

    public static final String TAG = "DetailFragment";
    private List<Reviews> reviews;
    private RecyclerView recyclerView;
    private ReviewAdapter adapter;
    private HeaderAdapter headerAdapter;
    private ConcatAdapter concatAdapter;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.reviewStream);
        reviews = new ArrayList<>();
        adapter = new ReviewAdapter(reviews,getContext());
        headerAdapter = new HeaderAdapter(getContext());
        concatAdapter = new ConcatAdapter(headerAdapter,adapter);

        recyclerView.setAdapter(concatAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        queryPost();

    }

    private void queryPost()
    {
        ParseQuery<Reviews> query = ParseQuery.getQuery(Reviews.class);
        query.include(Reviews.KEY_USER);
        query.setLimit(20);

        query.findInBackground(new FindCallback<Reviews>() {

            @Override
            public void done(List<Reviews> newReviews, ParseException e) {

                if (e != null){
                    Log.e(TAG,"Issue with getting posts", e);
                    return;
                }
                for(Reviews review : newReviews){
                    Log.i(TAG,"Post: " + review.getReview() + ", username:" + review.getUser().getUsername());
                }

                adapter.clear();
                adapter.addAll(newReviews);
            }
        });

    }
}