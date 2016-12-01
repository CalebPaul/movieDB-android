package com.epicodus.movieapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.titleTextView) TextView mTitleTextView;
    @Bind(R.id.searchActorEditTextView) EditText mSearchActorEditTextView;
    @Bind(R.id.searchActorButton) Button mSearchActorButton;
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSearchActorButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mSearchActorButton) {
            String actor = mSearchActorEditTextView.getText().toString();
            Log.d(TAG, actor);
        }
    }

}
