package com.example.simulation.Entitys;

import com.example.simulation.Coordinates;

public class Predator extends Creature { //хищник
//    private final int searchRadius = 3;

    public Predator(Coordinates coordinates) {
        super(coordinates, 10, 3);
    }

    //на что тратить ход
    // на перемещение (перемещение к травоядному)
    // на атаку травоядного (при этом хищник имеет силу атаки) при каждой атаки ХП у травоядного уменьшается
}
