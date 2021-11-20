package com.example.doctorsearchapp;

import com.parse.Parse;
import com.parse.ParseObject;

import android.app.Application;

public class ParseAuth extends Application {

    @Override
    public void onCreate(){
        super.onCreate();

        // ParseObject.registerSubclass(Post.class);

        // Authentication for Database
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("GdG8ICdTxWldUJmvjvk5wus6DwbTLTuqhVouz4Go")
                .clientKey("0cfiRHSq3PUnGEN3MUBPuW3OA7OF8HuOGbo7fWm5")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
