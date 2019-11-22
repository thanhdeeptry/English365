package com.example.firstproject.Model;

public class LessonFollowID {
    int id;
    String title;
    String des;
    public LessonFollowID() {
    }

    public LessonFollowID(String title, String des) {
        this.title = title;
        this.des = des;
    }

    public LessonFollowID(int id, String title, String des) {
        this.id = id;
        this.title = title;
        this.des = des;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }


}