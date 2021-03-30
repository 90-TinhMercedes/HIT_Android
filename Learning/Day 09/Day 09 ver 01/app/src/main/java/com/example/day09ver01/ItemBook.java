package com.example.day09ver01;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemBook implements Parcelable {
    private String title;
    private String imgLink;
    private String author;
    private long price;
    private float rateStar;
    private String description;
    private long numOfReview;
    private String categoty;
    private long numOfPage;

    protected ItemBook(Parcel in) {
        title = in.readString();
        imgLink = in.readString();
        author = in.readString();
        price = in.readLong();
        rateStar = in.readFloat();
        description = in.readString();
        numOfReview = in.readLong();
        categoty = in.readString();
        numOfPage = in.readLong();
    }

    public static final Creator<ItemBook> CREATOR = new Creator<ItemBook>() {
        @Override
        public ItemBook createFromParcel(Parcel in) {
            return new ItemBook(in);
        }

        @Override
        public ItemBook[] newArray(int size) {
            return new ItemBook[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public float getRateStar() {
        return rateStar;
    }

    public void setRateStar(float rateStar) {
        this.rateStar = rateStar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getNumOfReview() {
        return numOfReview;
    }

    public void setNumOfReview(long numOfReview) {
        this.numOfReview = numOfReview;
    }

    public String getCategoty() {
        return categoty;
    }

    public void setCategoty(String categoty) {
        this.categoty = categoty;
    }

    public long getNumOfPage() {
        return numOfPage;
    }

    public void setNumOfPage(long numOfPage) {
        this.numOfPage = numOfPage;
    }

    public ItemBook(String title, String imgLink, String author, long price, float rateStar, String description, long numOfReview, String categoty, long numOfPage) {
        this.title = title;
        this.imgLink = imgLink;
        this.author = author;
        this.price = price;
        this.rateStar = rateStar;
        this.description = description;
        this.numOfReview = numOfReview;
        this.categoty = categoty;
        this.numOfPage = numOfPage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(imgLink);
        dest.writeString(author);
        dest.writeLong(price);
        dest.writeFloat(rateStar);
        dest.writeString(description);
        dest.writeLong(numOfReview);
        dest.writeString(categoty);
        dest.writeLong(numOfPage);
    }
}
