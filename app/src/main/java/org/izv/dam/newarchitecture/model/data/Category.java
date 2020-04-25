package org.izv.dam.newarchitecture.model.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Category implements Parcelable {

    private long id;

    private String category;

    public Category(long id, String category) {
        this.id = id;
        this.category = category;
    }

    public Category() {
        this(0, "");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", category='" + category + '\'' +
                '}';
    }

    //parcelable (interface)

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(category);
    }

    //parcelable Android implementation: constructor, CREATOR

    protected Category(Parcel in) {
        id = in.readLong();
        category = in.readString();
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };
}