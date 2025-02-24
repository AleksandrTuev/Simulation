package com.example.simulation.entities;

import com.example.simulation.GameMap;

public class Tree extends Entity {
    @Override
    public void act(GameMap gameMap) {}

    @Override
    protected boolean canMove() {
        return false;
    }
}
