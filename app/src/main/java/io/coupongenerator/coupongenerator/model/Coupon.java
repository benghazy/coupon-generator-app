package io.coupongenerator.coupongenerator.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * {@link Coupon} for each  {@link User}
 */
public class Coupon  implements Parcelable{
    public  int userid;
    public String uid;
    public String redeemCode;
    public Date timestamp;

    public Coupon() {

    }


    public Coupon(int userid, String uid, String redeemCode) {
        this.userid = userid;
        this.uid = uid;
        this.redeemCode = redeemCode;
        this.timestamp = new Date(System.currentTimeMillis());

    }

    protected Coupon(Parcel in) {
        userid = in.readInt();
        uid = in.readString();
        redeemCode = in.readString();

        long time = in.readLong();

        timestamp =  time == -1L ? null : new Date(time);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(userid);
        dest.writeString(uid);
        dest.writeString(redeemCode);
        dest.writeLong(timestamp == null? -1L : timestamp.getTime());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Coupon> CREATOR = new Creator<Coupon>() {
        @Override
        public Coupon createFromParcel(Parcel in) {
            return new Coupon(in);
        }

        @Override
        public Coupon[] newArray(int size) {
            return new Coupon[size];
        }
    };
}
