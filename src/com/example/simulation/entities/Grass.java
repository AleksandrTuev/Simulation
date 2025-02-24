package com.example.simulation.entities;

import com.example.simulation.GameMap;

public class Grass extends Entity {
    @Override
    public void act(GameMap gameMap) {}

    @Override
    protected boolean canMove() {
        return false;
    }
}
