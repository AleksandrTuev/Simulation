package com.example.simulation.Entitys;

import com.example.simulation.Coordinates;

abstract class Creature extends Entity { //существо
    private int healthPoints; //очков здоровья

    public Creature(Coordinates coordinates) {
        super(coordinates);
    }
}
