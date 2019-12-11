package com.example.firstproject.model;

public class LessonFlIdTense {
    public int id,idtense;
    public String name,des;

    public LessonFlIdTense(int idtense, String name, String des) {
        this.idtense = idtense;
        this.name = name;
        this.des = des;
    }

    public LessonFlIdTense() {
    }

    public LessonFlIdTense(int id, int idtense, String name, String des) {
        this.id = id;
        this.idtense = idtense;
        this.name = name;
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdtense() {
        return idtense;
    }

    public void setIdtense(int idtense) {
        this.idtense = idtense;
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
