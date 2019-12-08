package com.example.firstproject.Model;

public class LessionFlIdTense {
    public int id,idtense;
    public String name,des;

    public LessionFlIdTense(int idtense, String name, String des) {
        this.idtense = idtense;
        this.name = name;
        this.des = des;
    }

    public LessionFlIdTense() {
    }

    public LessionFlIdTense(int id, int idtense, String name, String des) {
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
