package com.example.simulation;

import com.example.simulation.Entitys.Herbivore;
import com.example.simulation.Entitys.Predator;
import com.example.simulation.Entitys.Tree;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation(10, 20);
        simulation.gameLoop();
        int a = 123;

//        Map map = new Map(10, 20);
//
//        Coordinates coordinates = new Coordinates(1, 1);
//        Predator predator = new Predator(coordinates);
//        map.getEntities().put(coordinates, predator);
//        map.setCreatures(predator);
//
//        Coordinates coordinates1 = new Coordinates(10, 20);
//        Herbivore herbivore = new Herbivore(coordinates1);
//        map.getEntities().put(coordinates1, herbivore);
//        map.setCreatures(herbivore);
//
//        Coordinates coordinates2 = new Coordinates(2, 1);
//        Tree tree = new Tree(coordinates2);
//        map.getEntities().put(coordinates2, tree);
//
//        Coordinates coordinates3 = new Coordinates(6, 2);
//        Tree tree1 = new Tree(coordinates3);
//        map.getEntities().put(coordinates3, tree1);

//        MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();
//        mapConsoleRenderer.render(map);
//
//        LinkedHashSet<Coordinates> path = PathSearchAlgorithm.getPath(coordinates, predator.getFood(), map);
//        Coordinates[] xxx = path.toArray(new Coordinates[0]);
//        List<Coordinates> fff = Arrays.stream(xxx).toList().reversed();
//        int a = 123;
    }
}