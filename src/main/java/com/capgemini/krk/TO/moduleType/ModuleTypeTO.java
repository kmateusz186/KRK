package com.capgemini.krk.TO.moduleType;

public class ModuleTypeTO {

    private int id;
    private String name;

    public ModuleTypeTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ModuleTypeTO() {
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
