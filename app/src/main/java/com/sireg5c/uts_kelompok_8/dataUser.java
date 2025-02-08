package com.sireg5c.uts_kelompok_8;

import android.os.Parcel;
import android.os.Parcelable;

public class dataUser implements Parcelable {
    private String username;
    private String name;
    private Integer profilePhoto;
    private String role;
    private String descc;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(int profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescc() {
        return descc;
    }

    public void setDescc(String desc) {
        this.descc = desc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.username);
        dest.writeString(this.role);
        dest.writeString(this.descc);
        dest.writeInt(this.profilePhoto);
    }
    dataUser() {
    }
    private dataUser(Parcel in) {
        this.name = in.readString();
        this.username = in.readString();
        this.role = in.readString();
        this.descc = in.readString();
        this.profilePhoto = in.readInt();
    }
    public static final Parcelable.Creator<dataUser> CREATOR = new Parcelable.Creator<dataUser>() {
        @Override
        public dataUser createFromParcel(Parcel source) {
            return new dataUser(source);
        }
        @Override
        public dataUser[] newArray(int size) {
            return new dataUser[size];
        }
    };
}
