package com.example.day08ver01;

import android.os.Parcel;
import android.os.Parcelable;

public class Account implements Parcelable {
    private String username;
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    protected Account(Parcel in) {
        username = in.readString();
        password = in.readString();
    }

    public static final Creator<Account> CREATOR = new Creator<Account>() {
        @Override
        public Account createFromParcel(Parcel in) {
            return new Account(in);
        }

        @Override
        public Account[] newArray(int size) {
            return new Account[size];
        }
    };

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(password);
    }
}
