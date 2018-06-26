package com.capgemini.krk.TO.kind;

public class KindTO {
    private int id;
    private String name;

    public KindTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public KindTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
