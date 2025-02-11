package com.example.simulation.Entitys;

import com.example.simulation.Coordinates;
import com.example.simulation.Map;

public class Herbivore extends Creature {
    private static final int INIT_HEALTH = 10;
    private static final int INIT_SPEED = 2;
    private static final Class<? extends Entity> INIT_FOOD = Grass.class;

    public Herbivore() {
        super(INIT_HEALTH, INIT_SPEED, INIT_FOOD);
    }

    public Herbivore(Coordinates coordinates) {
        super(coordinates,INIT_HEALTH, INIT_SPEED, INIT_FOOD);
    }

    @Override
    protected void makeAttack(Coordinates target, Map map) {
        map.removeEntity(target);
        map.move(getCoordinates(), target);
        setCoordinates(target);
    }
}
