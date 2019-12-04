package com.example.firstproject.Model;

public class LessonThroughWord {
    public int id;
    public String title;
    public String des;

    public LessonThroughWord() {
    }

    public LessonThroughWord(String title, String des) {
        this.title = title;
        this.des = des;
    }

    public LessonThroughWord(int id, String title, String es) {
        this.id = id;
        this.title = title;
        this.des = es;
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

    public void setDes(String es) {
        this.des = des;
    }
}
