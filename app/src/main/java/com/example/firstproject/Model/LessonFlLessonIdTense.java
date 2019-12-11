package com.example.firstproject.Model;

public class LessonFlLessonIdTense {
    public int id,thisid;
    public String title,subtitle1;

    public LessonFlLessonIdTense(int thisid, String title, String subtitle1) {
        this.thisid = thisid;
        this.title = title;
        this.subtitle1 = subtitle1;
    }

    public LessonFlLessonIdTense() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getThisid() {
        return thisid;
    }

    public void setThisid(int thisid) {
        this.thisid = thisid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle1() {
        return subtitle1;
    }

    public void setSubtitle1(String subtitle1) {
        this.subtitle1 = subtitle1;
    }
}
