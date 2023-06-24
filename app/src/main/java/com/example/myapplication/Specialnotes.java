package com.example.myapplication;

public class Specialnotes {
    private String name,message,roomno;

    public Specialnotes(){

    }
    public Specialnotes(String name,String message,String roomno){
        this.name=  name;
        this.message =  message;
        this.roomno = roomno;

    }
    public String getName(){
        return name;
    }
    public String getMessage(){
        return message;
    }
    public String getRoom_no(){
        return roomno;
}}
