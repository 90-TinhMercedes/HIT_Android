package com.example.day04ver02;

public class Student {

    int avatar;
    String code;
    String name;

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(int avatar, String code, String name) {
        this.avatar = avatar;
        this.code = code;
        this.name = name;
    }
}
