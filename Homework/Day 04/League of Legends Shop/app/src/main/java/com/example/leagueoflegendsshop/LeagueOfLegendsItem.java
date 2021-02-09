package com.example.leagueoflegendsshop;

public class LeagueOfLegendsItem {
    int imageItem;
    String nameItem;
    String MFG;
    int price;
    int amountOrder;
    int money;
    int plusItem;
    int minusItem;

    public LeagueOfLegendsItem(int imageItem, String nameItem, String MFG, int price, int amountOrder, int money, int plusItem, int minusItem) {
        this.imageItem = imageItem;
        this.nameItem = nameItem;
        this.MFG = MFG;
        this.price = price;
        this.amountOrder = amountOrder;
        this.money = money;
        this.plusItem = plusItem;
        this.minusItem = minusItem;
    }

    @Override
    public String toString() {
        return "LeagueOfLegendsItem{" +
                "imageItem=" + imageItem +
                ", nameItem='" + nameItem + '\'' +
                ", MFG='" + MFG + '\'' +
                ", price=" + price +
                ", amountOrder=" + amountOrder +
                ", money=" + money +
                ", plusItem=" + plusItem +
                ", minusItem=" + minusItem +
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPlusItem() {
        return plusItem;
    }

    public void setPlusItem(int plusItem) {
        this.plusItem = plusItem;
    }

    public int getMinusItem() {
        return minusItem;
    }

    public void setMinusItem(int minusItem) {
        this.minusItem = minusItem;
    }
}
