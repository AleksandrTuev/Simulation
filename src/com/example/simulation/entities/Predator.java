package com.example.simulation.entities;

import com.example.simulation.Coordinates;
import com.example.simulation.GameMap;

public class Predator extends Creature {
    private static final int INIT_HEALTH = 10;
    private static final int INIT_SPEED = 3;
    private static final Class<? extends Entity> INIT_FOOD = Herbivore.class;
    private static final int ATTACK_DAMAGE = 3;

    public Predator() {
        super(INIT_HEALTH, INIT_SPEED, INIT_FOOD);
    }

    @Override
    protected void makeAttack(Coordinates target, GameMap gameMap) {
        Herbivore herbivore = (Herbivore) gameMap.getEntity(target);

        for (int i = 1; i <= ATTACK_DAMAGE; i++) {
            if (herbivore.getHealth() > 0) {
                herbivore.setHealth(herbivore.getHealth() - 1);
            } else {
                gameMap.removeEntity(target);
                updatePosition(target, gameMap);
                return;
            }
        }
    }
}
