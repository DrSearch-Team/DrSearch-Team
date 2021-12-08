package com.example.doctorsearchapp.models;

import android.os.Parcelable;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.text.SimpleDateFormat;

@ParseClassName("User")
public class Users extends ParseObject implements Parcelable{

    ParseUser user;
    public static final String KEY_IMAGE = "profilePicture";
    public static final String KEY_USER = "username";


    public Users(){
        // empty
    }

    public Users(ParseUser user)
    {

        this.user = user;
    }

    public String getUsername()
    {
        return user.getUsername();
    }

    public ParseFile getProfilePic()
    {

        return user.getParseFile(KEY_IMAGE);
    }

    public String getObjectId(){
        return user.getObjectId();
    }

    public String getProfileCreation()
    {
        return new SimpleDateFormat("MMMM dd, yyyy").format(user.getCreatedAt());
    }
}