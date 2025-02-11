package com.example.simulation.Entitys;

import com.example.simulation.Map;

public class Grass extends Entity {
    @Override
    public void act(Map map) {}

    @Override
    protected boolean canMove() {
        return false;
    }
}
