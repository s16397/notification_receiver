package com.example.mariusz.notificationreceiver;

import android.os.Parcel;
import android.os.Parcelable;

public class Notification implements Parcelable {

    public static final Parcelable.Creator<Notification> CREATOR = new
            Parcelable.Creator<Notification>() {
                @Override
                public Notification createFromParcel(Parcel parcel) {
                    return new Notification(parcel);
                }

                @Override
                public Notification[] newArray(int i) {
                    return new Notification[0];
                }
            };

    private final String title;
    private final String message;

    public Notification(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public Notification(Parcel parcel) {
        this.title = parcel.readString();
        this.message = parcel.readString();
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.message);
    }
}
