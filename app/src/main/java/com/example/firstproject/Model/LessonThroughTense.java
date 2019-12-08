package com.example.firstproject.Model;

public class LessonThroughTense {
    public int Id;
    public String title;
    public String Des;

    public LessonThroughTense() {
    }

    public LessonThroughTense(String title, String des) {
        this.title = title;
        Des = des;
    }

    public LessonThroughTense(int id, String title, String des) {
        Id = id;
        this.title = title;
        Des = des;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return Des;
    }

    public void setDes(String des) {
        Des = des;
    }
}
