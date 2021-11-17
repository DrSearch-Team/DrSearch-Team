package com.example.doctorsearchapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.doctorsearchapp.MainActivity;
import com.example.doctorsearchapp.R;

public class SearchFragment extends Fragment {

    private static final String TAG = "SearchFragment";
    private SearchView svDoctors;
    private RecyclerView rvSearchResults;
    private Button detailBtn;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        svDoctors = view.findViewById(R.id.svSearchDoctors);
        rvSearchResults = view.findViewById(R.id.rvSearchResults);
        detailBtn = view.findViewById(R.id.detailBtn);

        detailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.flContainer, new DetailFragment()).commit();
            }
        });
    }
}