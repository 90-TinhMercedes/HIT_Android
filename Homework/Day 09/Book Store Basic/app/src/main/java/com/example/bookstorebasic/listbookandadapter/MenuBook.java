package com.example.bookstorebasic.listbookandadapter;

import android.os.Parcel;
import android.os.Parcelable;

public class MenuBook implements Parcelable {
    private String imgLink;
    private String menuTitleBook;
    private String author;
    private long price;
    private float rateStar;
    private String description;
    private long numOfReview;
    private String categoty;
    private long numOfPage;

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getMenuTitleBook() {
        return menuTitleBook;
    }

    public void setMenuTitleBook(String menuTitleBook) {
        this.menuTitleBook = menuTitleBook;
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

    public static Creator<MenuBook> getCREATOR() {
        return CREATOR;
    }

    public MenuBook(String imgLink, String menuTitleBook, String author, long price, float rateStar, String description, long numOfReview, String categoty, long numOfPage) {
        this.imgLink = imgLink;
        this.menuTitleBook = menuTitleBook;
        this.author = author;
        this.price = price;
        this.rateStar = rateStar;
        this.description = description;
        this.numOfReview = numOfReview;
        this.categoty = categoty;
        this.numOfPage = numOfPage;
    }

    protected MenuBook(Parcel in) {
        imgLink = in.readString();
        menuTitleBook = in.readString();
        author = in.readString();
        price = in.readLong();
        rateStar = in.readFloat();
        description = in.readString();
        numOfReview = in.readLong();
        categoty = in.readString();
        numOfPage = in.readLong();
    }

    public static final Creator<MenuBook> CREATOR = new Creator<MenuBook>() {
        @Override
        public MenuBook createFromParcel(Parcel in) {
            return new MenuBook(in);
        }

        @Override
        public MenuBook[] newArray(int size) {
            return new MenuBook[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imgLink);
        dest.writeString(menuTitleBook);
        dest.writeString(author);
        dest.writeLong(price);
        dest.writeFloat(rateStar);
        dest.writeString(description);
        dest.writeLong(numOfReview);
        dest.writeString(categoty);
        dest.writeLong(numOfPage);
    }
}
