package com.battle.medievalbattle;

public class Platoon {
    private int cap;
    private String clazz;

    public Platoon(int cap, String clazz) {
        this.cap = cap;
        this.clazz = clazz;
    }

    public int getCap() {
        return cap;
    }

    public String getClazz() {
        return clazz;
    }
}
