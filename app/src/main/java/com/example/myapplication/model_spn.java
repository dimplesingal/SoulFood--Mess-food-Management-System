package com.example.myapplication;

public class model_spn {
    String name,message,room_no;


    public model_spn() {
    }

    public model_spn(String name, String message, String room_no) {
        this.name = name;
        this.message = message;
        this.room_no = room_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRoom_no() {
        return room_no;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }
}
