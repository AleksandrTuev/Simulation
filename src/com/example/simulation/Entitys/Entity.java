package com.example.simulation.Entitys;

import com.example.simulation.Map;

public abstract class Entity {

    public abstract void act(Map map);

    protected abstract boolean canMove();
}
