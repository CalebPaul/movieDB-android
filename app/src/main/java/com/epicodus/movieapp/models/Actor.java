package com.epicodus.movieapp.models;

/**
 * Created by Guest on 12/1/16.
 */
public class Actor {
    private String mCharacter;
    private String mTitle;
    private String mPosterPath;
    private String mReleaseDate;

    public Actor(String mCharacter, String mTitle, String mPosterPath, String mReleaseDate) {
        this.mCharacter = mCharacter;
        this.mTitle = mTitle;
        this.mPosterPath = mPosterPath;
        this.mReleaseDate = mReleaseDate;
    }

    public String getmCharacter() {
        return mCharacter;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmPosterPath() {
        return mPosterPath;
    }

    public String getmReleaseDate() {
        return mReleaseDate;
    }
}

