package com.example.simulation.Entitys;

import com.example.simulation.Map;

public abstract class Entity {
//    public void act(Map map) {
//        if (map.canMove(this)) {
//            this.makeMove(map);
//        }
//    }
    public abstract void act(Map map);
    protected abstract boolean canMove();
}
