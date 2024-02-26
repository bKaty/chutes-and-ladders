package com.priceline.chutes.model;

public class Player {

    public String name;
    public int position = 0;

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
