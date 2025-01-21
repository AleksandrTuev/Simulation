package com.example.simulation.Entitys;

import com.example.simulation.Coordinates;
import com.example.simulation.PathSearchAlgorithm;

public class Herbivore extends Creature { //травоядное животное
//    private final int searchRadius = 2;

    public Herbivore(Coordinates coordinates) {
        super(coordinates, 10, 2);
    }

    //тратят свой ход на движение к траве или на её поглощение
}
