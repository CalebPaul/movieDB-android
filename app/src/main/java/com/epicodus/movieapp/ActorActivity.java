package com.epicodus.movieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActorActivity extends AppCompatActivity {
    public static final String TAG = ActorActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor);
    }
}
