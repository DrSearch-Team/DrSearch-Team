package com.example.doctorsearchapp.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.doctorsearchapp.R;
import com.example.doctorsearchapp.ReviewAdapter;
import com.example.doctorsearchapp.models.Doctor;
import com.example.doctorsearchapp.models.Users;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    private static final String TAG = "ProfileFragment";
    private ImageView ivProfileImage;
    private TextView tvUsername;
    private TextView tvUserId;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivProfileImage = view.findViewById(R.id.ivProfileImage);
        tvUserId = view.findViewById(R.id.tvUserId);
        tvUsername = view.findViewById(R.id.tvUsername);

        //tvUsername.setText(ParseUser.getCurrentUser().getUsername());
        // tvUserId.setText(ParseUser.getCurrentUser().get);
        //Glide.with(view).load(ParseUser.getCurrentUser().getProfilePic())

        // Using Glide change the picture in the Profile Fragment
        // Specify which class to query
        ParseQuery<Users> query = ParseQuery.getQuery(Users.class);
        query.whereEqualTo("objectId", ParseUser.getCurrentUser().getObjectId());

        query.findInBackground(new FindCallback<Users>() {
            public void done(List<Users> objects, ParseException e) {

                if (e == null) {
                    int count = 0;

                    Users[] myArray = new Users[objects.size()];
                    objects.toArray(myArray);

                    System.out.println(objects.size());
                    while (count < objects.size()){
                        System.out.println(ParseUser.getCurrentUser().getUsername());
                        if (myArray[count].getUsername().equals(ParseUser.getCurrentUser().getUsername())){
                            System.out.println(ParseUser.getCurrentUser().getUsername());
                            Glide.with(view).load(myArray[count].getProfilePic().getUrl()).into(ivProfileImage);
                        }
                        count++;
                    }


                } else {
                    System.out.println("Mun doesn't suck");
                }
            }
        });
        // Specify the object id
    }
}
/*
query.getInBackground("iFSrGZx5dU", new GetCallback<Users>() {
public void done(Users item, ParseException e) {
        // System.out.println(ParseUser.getCurrentUser().getObjectId());
        System.out.println(item.getUsername());
        if (e == null) {
        System.out.println(item.getUsername());
        } else {
        System.out.println(e);
        System.out.println("Muny error");
        }
        }
        });*/

/*
for (Users user : users) {
                    Log.i(TAG, "Doctor: " + user.getUsername());
                }
 */

    /*ParseQuery<Users> query = ParseQuery.getQuery(Users.class);
        *//*query.include(Users.KEY_IMAGE);
        query.include(Users.KEY_USER);*//*
        System.out.println("Muny get it together 1");
        query.findInBackground(new FindCallback<Users>() {
        @Override
        public void done(List<Users> user, ParseException e) {
            System.out.println(user.size());
            if (e != null) {
                Log.e(TAG, "Issue with getting doctors", e);
            } else {
                for (Users users : user) {
                    Log.i(TAG, "Doctor: " + users.getProfilePic().getUrl() + ", " + users.getUsername());
                }
            }
        }
    });
}*/