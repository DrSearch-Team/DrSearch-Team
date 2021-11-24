package com.example.doctorsearchapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctorsearchapp.R;
import com.example.doctorsearchapp.models.Doctor;

import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder> {

    Context context;
    List<Doctor> doctors;

    public DoctorAdapter(Context context, List<Doctor> doctors) {
        this.context = context;
        this.doctors = doctors;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View doctorView = LayoutInflater.from(context).inflate(R.layout.item_doctor, parent, false);
        return new ViewHolder(doctorView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Doctor doctor = doctors.get(position);
        holder.bind(doctor);
    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvDoctorName;
        TextView tvLocation;
        RatingBar rbOverallRating;

        public ViewHolder(View doctorView) {
            super(doctorView);
            tvDoctorName = doctorView.findViewById(R.id.tvDoctorName);
            tvLocation = doctorView.findViewById(R.id.tvLocation);
            rbOverallRating = doctorView.findViewById(R.id.rbDoctorRating);
        }

        public void bind(Doctor doctor) {
            tvDoctorName.setText(doctor.getDoctorName());
            tvLocation.setText(doctor.getLocation());
            //rbOverallRating.setRating(doctor.getOverallRating());
        }
    }
}
