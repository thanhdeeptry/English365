package com.example.firstproject.Model;

public class LessonThroughWord {
    int Id;
    String title;
    String Des;

    public LessonThroughWord() {
    }

    public LessonThroughWord(String title, String des) {
        this.title = title;
        Des = des;
    }

    public LessonThroughWord(int id, String title, String des) {
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
