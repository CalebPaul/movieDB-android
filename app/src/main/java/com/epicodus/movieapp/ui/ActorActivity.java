package com.epicodus.movieapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.epicodus.movieapp.R;
import com.epicodus.movieapp.services.MovieService;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ActorActivity extends AppCompatActivity {
    public static final String TAG = ActorActivity.class.getSimpleName();
    public String mActorId;

    @Bind(R.id.actorNameTextView) TextView mActorNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String actor = intent.getStringExtra("actor");
        mActorNameTextView.setText("Actor's name is: " + actor);

        getActorId(actor);
    }

    private void getActorId(String actor) {
        final MovieService movieService = new MovieService();
        movieService.findActorId(actor, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.v(TAG, "Successful Response");
                mActorId = movieService.processActorId(response);
            }
        });
    }
}
