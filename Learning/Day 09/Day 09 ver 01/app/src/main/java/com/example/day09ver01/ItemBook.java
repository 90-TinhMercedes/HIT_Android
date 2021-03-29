package com.example.day09ver01;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemBook implements Parcelable {
    private String title;
    private String imgLink;
    private String authorStatic;
    private String author;
    private long price;
    private float rateStar;
    private String descriptionStatic;
    private String description;
    private long numOfReview;
    private String luotDanhGia;
    private String categoty;
    private long numOfPage;
    private String page;
    private String rankAndRate;

    public ItemBook(String title, String imgLink, String authorStatic, String author, long price, float rateStar, String descriptionStatic, String description, long numOfReview, String luotDanhGia, String categoty, long numOfPage, String page, String rankAndRate) {
        this.title = title;
        this.imgLink = imgLink;
        this.authorStatic = authorStatic;
        this.author = author;
        this.price = price;
        this.rateStar = rateStar;
        this.descriptionStatic = descriptionStatic;
        this.description = description;
        this.numOfReview = numOfReview;
        this.luotDanhGia = luotDanhGia;
        this.categoty = categoty;
        this.numOfPage = numOfPage;
        this.page = page;
        this.rankAndRate = rankAndRate;
    }


    protected ItemBook(Parcel in) {
        title = in.readString();
        imgLink = in.readString();
        authorStatic = in.readString();
        author = in.readString();
        price = in.readLong();
        rateStar = in.readFloat();
        descriptionStatic = in.readString();
        description = in.readString();
        numOfReview = in.readLong();
        luotDanhGia = in.readString();
        categoty = in.readString();
        numOfPage = in.readLong();
        page = in.readString();
        rankAndRate = in.readString();
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

    @Override
    public String toString() {
        return "ItemBook{" +
                "title='" + title + '\'' +
                ", imgLink='" + imgLink + '\'' +
                ", authorStatic='" + authorStatic + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", rateStar=" + rateStar +
                ", descriptionStatic='" + descriptionStatic + '\'' +
                ", description='" + description + '\'' +
                ", numOfReview=" + numOfReview +
                ", luotDanhGia='" + luotDanhGia + '\'' +
                ", categoty='" + categoty + '\'' +
                ", numOfPage=" + numOfPage +
                ", page='" + page + '\'' +
                ", rankAndRate='" + rankAndRate + '\'' +
                '}';
    }

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

    public String getAuthorStatic() {
        return authorStatic;
    }

    public void setAuthorStatic(String authorStatic) {
        this.authorStatic = authorStatic;
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

    public String getDescriptionStatic() {
        return descriptionStatic;
    }

    public void setDescriptionStatic(String descriptionStatic) {
        this.descriptionStatic = descriptionStatic;
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

    public String getLuotDanhGia() {
        return luotDanhGia;
    }

    public void setLuotDanhGia(String luotDanhGia) {
        this.luotDanhGia = luotDanhGia;
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

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getRankAndRate() {
        return rankAndRate;
    }

    public void setRankAndRate(String rankAndRate) {
        this.rankAndRate = rankAndRate;
    }

    public static Creator<ItemBook> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(imgLink);
        dest.writeString(authorStatic);
        dest.writeString(author);
        dest.writeFloat(price);
        dest.writeFloat(rateStar);
        dest.writeString(descriptionStatic);
        dest.writeString(description);
        dest.writeLong(numOfReview);
        dest.writeString(luotDanhGia);
        dest.writeString(categoty);
        dest.writeLong(numOfPage);
        dest.writeString(page);
        dest.writeString(rankAndRate);
    }
}
