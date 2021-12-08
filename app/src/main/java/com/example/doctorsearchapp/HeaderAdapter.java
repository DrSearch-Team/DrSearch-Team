package com.example.doctorsearchapp;

import static com.example.doctorsearchapp.MainActivity.TAG;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctorsearchapp.fragments.ComposeFragment;
import com.example.doctorsearchapp.fragments.DetailFragment;
import com.example.doctorsearchapp.models.Doctor;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.List;
import java.util.concurrent.Callable;

public class HeaderAdapter extends RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder> {

    private Context context;
    Doctor doctor;
    String address;

    // Bundle test
    public HeaderAdapter(Context context, Doctor currentDoctor)
    {
        this.context = context;
        doctor = currentDoctor;
    }

    // Inflate the view and return the HeaderViewHolder
    @NonNull
    @Override
    public HeaderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.header_layout,parent,false);
        return new HeaderViewHolder(view);
    }

    // Bind information to the Header
    @Override
    public void onBindViewHolder(@NonNull HeaderViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }



    class HeaderViewHolder extends  RecyclerView.ViewHolder
    {
        private Button reviewBtn;
        private Button searchBtn;
        private TextView addressTV;
        private String address;
        private List<Doctor> allDoctors;

        // Bundle test
        private TextView nameTV;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            reviewBtn = itemView.findViewById(R.id.reviewBtn);
            searchBtn = itemView.findViewById(R.id.btnSearch);

            // Bundle test
            nameTV = itemView.findViewById(R.id.nameTV);
            nameTV.setText(doctor.getDoctorName());
            addressTV = itemView.findViewById(R.id.addressTV);
            addressTV.setText(doctor.getLocation());

            reviewBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity activity = (MainActivity) context;
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.flContainer,new ComposeFragment()).commit();
                }
            });

            searchBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    ParseQuery<Doctor> query = ParseQuery.getQuery(Doctor.class);

                    query.getInBackground("DFs3HAdJay", new GetCallback<Doctor>() {
                        @Override
                        public void done(Doctor doctor, ParseException e) {
                            if (e != null) {
                                Log.e("SearchFragment", "Issue with getting doctors", e);
                                return;
                            }
                            address = doctor.getLocation();
                            Log.i("SearchFragment", "Location: " + address);

                            Uri gmIntentUri =  Uri.parse("geo:0,0?q=" + address);

                            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmIntentUri);
                            mapIntent.setPackage("com.google.android.apps.maps");

                            context.startActivity(mapIntent);
                        }
                    });
                }
            });
        }
    }

}
