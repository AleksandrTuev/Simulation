package com.example.simulation;

import com.example.simulation.Entitys.Herbivore;
import com.example.simulation.Entitys.Predator;

import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) {
//        Simulation simulation = new Simulation();
//        simulation.gameLoop();
//        int a = 123;

        Map map = new Map(10, 20);

        Coordinates coordinates = new Coordinates(1, 1);
        Predator predator = new Predator(coordinates);
        map.getEntities().put(coordinates, predator);
        map.setCreatures(predator);

        Coordinates coordinates1 = new Coordinates(9, 3);
        Herbivore herbivore = new Herbivore(coordinates1);
        map.getEntities().put(coordinates1, herbivore);
        map.setCreatures(herbivore);

        MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();
        mapConsoleRenderer.render(map);

        LinkedHashSet<Coordinates> path = PathSearchAlgorithm.getPath(coordinates, predator.getFood(), map);

        int a = 123;
    }
}