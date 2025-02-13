package com.example.simulation.Entitys;

import com.example.simulation.Coordinates;
import com.example.simulation.Map;

public class Predator extends Creature {
    private static final int INIT_HEALTH = 10;
    private static final int INIT_SPEED = 3;
    private static final Class<? extends Entity> INIT_FOOD = Herbivore.class;
    private static final int ATTACK_DAMAGE = 3;

    public Predator() {
        super(INIT_HEALTH, INIT_SPEED, INIT_FOOD);
    }

    public Predator(Coordinates coordinates) {
        super(coordinates,INIT_HEALTH, INIT_SPEED, INIT_FOOD);
    }

    @Override
    protected void makeAttack(Coordinates target, Map map) {
        Herbivore herbivore = (Herbivore) map.getEntity(target);

        for (int i = 1; i <= ATTACK_DAMAGE; i++) {
            if (herbivore.getHealth() > 0) {
                herbivore.setHealth(herbivore.getHealth() - 1);
            } else {
                map.removeEntity(target);
                updatePosition(target, map);
                return;
            }
        }
    }
}
