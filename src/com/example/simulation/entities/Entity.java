package com.example.simulation.entities;

import com.example.simulation.GameMap;

public abstract class Entity {

    public abstract void act(GameMap gameMap);

    protected abstract boolean canMove();
}
