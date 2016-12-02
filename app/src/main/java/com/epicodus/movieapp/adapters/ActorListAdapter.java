package com.epicodus.movieapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.movieapp.R;
import com.epicodus.movieapp.models.Actor;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 12/1/16.
 */
public class ActorListAdapter extends RecyclerView.Adapter<ActorListAdapter.ActorViewHolder> {
    private ArrayList<Actor> mActors = new ArrayList<>();
    private Context mContext;

    public ActorListAdapter(Context context, ArrayList<Actor> actors) {
        mContext = context;
        mActors = actors;
    }

    @Override
    public ActorListAdapter.ActorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.actor_list_item, parent, false);
        ActorViewHolder viewHolder = new ActorViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ActorListAdapter.ActorViewHolder holder, int position) {
        holder.bindActor(mActors.get(position));
    }

    @Override
    public int getItemCount() {
        return mActors.size();
    }


    public class ActorViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.movieTitleTextView) TextView mMovieTitleTextView;
        @Bind(R.id.characterNameTextView) TextView mCharacterNameTextView;
        @Bind(R.id.releaseDateTextView) TextView mReleaseDateTextView;
        @Bind(R.id.moviePosterImageView) ImageView mMoviePosterImageView;

        private Context mContext;

        public ActorViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindActor(Actor actor) {
            mMovieTitleTextView.setText(actor.getmCharacter());
            mCharacterNameTextView.setText(actor.getmTitle());
            mReleaseDateTextView.setText(actor.getmReleaseDate());
        }
    }
}
