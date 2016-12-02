package com.epicodus.movieapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.epicodus.movieapp.R;
import com.epicodus.movieapp.adapters.ActorListAdapter;
import com.epicodus.movieapp.models.Actor;
import com.epicodus.movieapp.services.MovieService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ActorActivity extends AppCompatActivity {
    public ArrayList<Actor> mActors = new ArrayList<>();
    public static final String TAG = ActorActivity.class.getSimpleName();
    public String mActorId;
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private ActorListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String actor = intent.getStringExtra("actor");

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
                mActorId = movieService.processActorId(response);
                getActorMovies(mActorId);
            }
        });
    }

    private void getActorMovies(String actorId) {
        final MovieService movieService = new MovieService();

        movieService.findActorMovies(actorId, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.v(TAG, "Successful Response for Actors Movies yay!");
                mActors = movieService.processActorMovies(response);

                ActorActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new ActorListAdapter(getApplicationContext(), mActors);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                            new LinearLayoutManager(ActorActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}
