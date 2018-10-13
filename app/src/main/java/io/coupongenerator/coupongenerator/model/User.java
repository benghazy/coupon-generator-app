package io.coupongenerator.coupongenerator.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * {@link User } data model
 */
public class User implements Parcelable{

    public int userid; // unique code for users
    public String uid;
    public String username;
    public String profile;
    public Date timestamp;

    // default constructor
    public User() {
    }

    public User(int userid, String uid, String username, String profile) {
        this.userid = userid;
        this.uid = uid;
        this.username = username;
        this.profile = profile;

        this.timestamp = new Date(System.currentTimeMillis());

    }

    protected User(Parcel in) {
        userid = in.readInt();
        uid = in.readString();
        username = in.readString();
        profile = in.readString();
        long time = in.readLong();

        timestamp =  time == -1L ? null : new Date(time);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(userid);
        dest.writeString(uid);
        dest.writeString(username);
        dest.writeString(profile);
        dest.writeLong(timestamp == null? -1L : timestamp.getTime());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
