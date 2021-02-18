package com.example.day04ver02;

public class ChampLoL {
    int avatar;
    String champ;
    String info;

    public ChampLoL() {
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getChamp() {
        return champ;
    }

    public void setChamp(String champ) {
        this.champ = champ;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ChampLoL(int avatar, String champ, String info) {
        this.avatar = avatar;
        this.champ = champ;
        this.info = info;
    }
}
