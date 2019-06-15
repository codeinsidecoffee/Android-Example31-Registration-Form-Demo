package com.mrlonewolfer.example65;

import android.os.Parcel;
import android.os.Parcelable;

public class UserBean implements Parcelable {
    String uname,password,email;
    Long mobile;

    protected UserBean(Parcel in) {
        uname = in.readString();
        password = in.readString();
        email = in.readString();
        if (in.readByte() == 0) {
            mobile = null;
        } else {
            mobile = in.readLong();
        }
    }

    public static final Creator<UserBean> CREATOR = new Creator<UserBean>() {
        @Override
        public UserBean createFromParcel(Parcel in) {
            return new UserBean(in);
        }

        @Override
        public UserBean[] newArray(int size) {
            return new UserBean[size];
        }
    };

    public UserBean() {

    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(uname);
        dest.writeString(password);
        dest.writeString(email);
        if (mobile == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mobile);
        }
    }
}
