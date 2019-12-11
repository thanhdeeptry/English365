package com.example.firstproject.model;

public class LessonFlIdWord {
    public int id,idword;
    public String name;
    public String des;

    public LessonFlIdWord(int idword, String name, String des) {
        this.idword = idword;
        this.name = name;
        this.des = des;
    }

    public LessonFlIdWord() {
    }

    public LessonFlIdWord(int id, int idword, String name, String des) {
        this.id = id;
        this.idword = idword;
        this.name = name;
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdword() {
        return idword;
    }

    public void setIdword(int idword) {
        this.idword = idword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
