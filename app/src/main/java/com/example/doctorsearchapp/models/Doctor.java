package com.example.doctorsearchapp.models;

import java.util.ArrayList;

public class Doctor {

    public int doctorId;
    public String doctorName;
    public int overallRating;
    public String location;
    public ArrayList<Integer> reviewList;

    public Doctor() {};

    public Doctor(int doctorId, String doctorName, int overallRating, String location, ArrayList<Integer> reviewList) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.overallRating = overallRating;
        this.location = location;
        this.reviewList = reviewList;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(int overallRating) {
        this.overallRating = overallRating;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Integer> getReviewList() {
        return reviewList;
    }

    public void setReviewList(ArrayList<Integer> reviewList) {
        this.reviewList = reviewList;
    }
}
