package com.example.simulation.entities;

import com.example.simulation.GameMap;

public class Rock extends Entity {
    @Override
    public void act(GameMap gameMap) {}

    @Override
    protected boolean canMove() {
        return false;
    }
}
