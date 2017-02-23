package com.codepath.android.booksearch.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by BuuPV on 2/23/2017.
 */

public class Publisher implements Parcelable {
    private String name;

    protected Publisher(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Publisher> CREATOR = new Creator<Publisher>() {
        @Override
        public Publisher createFromParcel(Parcel in) {
            return new Publisher(in);
        }

        @Override
        public Publisher[] newArray(int size) {
            return new Publisher[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
    }
}