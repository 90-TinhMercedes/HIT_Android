package com.example.leagueoflegendsshopver2;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class LeagueOfLegendsItem implements Parcelable, Serializable {
    int imageItem;
    String nameItem;
    String MFG;
    int price;
    int amountOrder;
    int imageMoney;
    int imagePlusItem;
    int imageMinusItem;

    public LeagueOfLegendsItem(int imageItem, String nameItem, String MFG, int price, int amountOrder, int imageMoney, int imagePlusItem, int imageMinusItem) {
        this.imageItem = imageItem;
        this.nameItem = nameItem;
        this.MFG = MFG;
        this.price = price;
        this.amountOrder = amountOrder;
        this.imageMoney = imageMoney;
        this.imagePlusItem = imagePlusItem;
        this.imageMinusItem = imageMinusItem;
    }

    protected LeagueOfLegendsItem(Parcel in) {
        imageItem = in.readInt();
        nameItem = in.readString();
        MFG = in.readString();
        price = in.readInt();
        amountOrder = in.readInt();
        imageMoney = in.readInt();
        imagePlusItem = in.readInt();
        imageMinusItem = in.readInt();
    }


    public static final Creator<LeagueOfLegendsItem> CREATOR = new Creator<LeagueOfLegendsItem>() {
        @Override
        public LeagueOfLegendsItem createFromParcel(Parcel in) {
            return new LeagueOfLegendsItem(in);
        }

        @Override
        public LeagueOfLegendsItem[] newArray(int size) {
            return new LeagueOfLegendsItem[size];
        }
    };

    @Override
    public String toString() {
        return "LeagueOfLegendsItem{" +
                "imageItem=" + imageItem +
                ", nameItem='" + nameItem + '\'' +
                ", MFG='" + MFG + '\'' +
                ", price=" + price +
                ", amountOrder=" + amountOrder +
                ", money=" + imageMoney +
                ", plusItem=" + imagePlusItem +
                ", minusItem=" + imageMinusItem +
                '}';
    }

    public LeagueOfLegendsItem() {
    }

    public int getImageItem() {
        return imageItem;
    }

    public void setImageItem(int imageItem) {
        this.imageItem = imageItem;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public String getMFG() {
        return MFG;
    }

    public void setMFG(String MFG) {
        this.MFG = MFG;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmountOrder() {
        return amountOrder;
    }

    public void setAmountOrder(int amountOrder) {
        this.amountOrder = amountOrder;
    }

    public int getImageMoney() {
        return imageMoney;
    }

    public void setImageMoney(int imageMoney) {
        this.imageMoney = imageMoney;
    }

    public int getImagePlusItem() {
        return imagePlusItem;
    }

    public void setImagePlusItem(int imagePlusItem) {
        this.imagePlusItem = imagePlusItem;
    }

    public int getImageMinusItem() {
        return imageMinusItem;
    }

    public void setImageMinusItem(int imageMinusItem) {
        this.imageMinusItem = imageMinusItem;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageItem);
        dest.writeString(nameItem);
        dest.writeString(MFG);
        dest.writeInt(price);
        dest.writeInt(amountOrder);
        dest.writeInt(imageMoney);
        dest.writeInt(imagePlusItem);
        dest.writeInt(imageMinusItem);
    }
}
