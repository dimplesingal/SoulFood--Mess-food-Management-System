package com.example.myapplication;

public class milkModel {
    String name;
    String room_no;

    public milkModel() {
    }

    public milkModel(String name, String room_no) {
        this.name = name;
        this.room_no = room_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom_no() {
        return room_no;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }
}
