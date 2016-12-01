package com.epicodus.movieapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.epicodus.movieapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ActorActivity extends AppCompatActivity {
    public static final String TAG = ActorActivity.class.getSimpleName();
    @Bind(R.id.actorNameTextView) TextView mActorNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String actor = intent.getStringExtra("actor");
        mActorNameTextView.setText("Actor's name is: " + actor);
    }
}
