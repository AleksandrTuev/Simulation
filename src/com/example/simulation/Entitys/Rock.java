package com.example.simulation.Entitys;

import com.example.simulation.Coordinates;

public class Rock extends Entity { //камень

    public Rock(Coordinates coordinates) {
        super(coordinates, 100);
    }

    @Override
    public String toString() {
        return "Rock{" +
                "coordinates=" + coordinates +
                '}';
    }
}
