package com.example.simulation.Entitys;

import com.example.simulation.Coordinates;

public class Tree extends Entity { //дерево

    public Tree(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String toString() {
        return "Tree{" +
                "coordinates=" + coordinates +
                '}';
    }
}
