package com.example.simulation.Entitys;

import com.example.simulation.Coordinates;
import com.example.simulation.PathSearchAlgorithm;

import java.util.HashSet;
import java.util.Set;

public class Herbivore extends Creature { //травоядное животное
//    private final int numberOfSteps = 2;

    public Herbivore(Coordinates coordinates) {
        super(coordinates, 10, 2, Tree.class);
    }

    //тратят свой ход на движение к траве или на её поглощение
}
