package com.example.simulation.Entitys;

import com.example.simulation.Coordinates;

abstract class Creature extends Entity { //существо
    //скорость (сколько клеток проходит за раз)
    protected int healthPoints; //очков здоровья
    protected final int searchRadius; //радиус поиска
    public Creature(Coordinates coordinates, int healthPoints, int searchRadius) {
        super(coordinates);
        this.healthPoints = healthPoints;
        this.searchRadius = searchRadius;
    }
}
