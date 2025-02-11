package com.example.simulation;

import com.example.simulation.Entitys.Grass;
import com.example.simulation.Entitys.Herbivore;
import com.example.simulation.Entitys.Predator;
import com.example.simulation.Entitys.Tree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation(10, 20); //10 20
        simulation.gameLoop();
        int a = 123;

//        Map map = new Map(10, 10);
//
//        Coordinates coordinates = new Coordinates(10, 10);
//        Predator predator = new Predator(coordinates);
//        map.getEntities().put(coordinates, predator);
////        map.setCreatures(predator);
////
//        Coordinates coordinates1 = new Coordinates(1, 1);
//        Herbivore herbivore = new Herbivore(coordinates1);
//        map.getEntities().put(coordinates1, herbivore);
////        map.setCreatures(herbivore);
//
//        Coordinates coordinates2 = new Coordinates(4, 9);
//        Grass grass = new Grass(coordinates2);
//        map.getEntities().put(coordinates2, grass);
////
////        Coordinates coordinates3 = new Coordinates(6, 2);
////        Tree tree1 = new Tree(coordinates3);
////        map.getEntities().put(coordinates3, tree1);
////
//        MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();
//        mapConsoleRenderer.render(map);
//
//        LinkedHashSet<Coordinates> path = PathSearchAlgorithm.getPath(coordinates, predator.getFood(), map);
//        List<Coordinates> pathList = new ArrayList<>(path);
//        Collections.reverse(pathList);
//        System.out.println("Хищник" + pathList);
//
//        LinkedHashSet<Coordinates> pathHerbivore = PathSearchAlgorithm.getPath(coordinates1, herbivore.getFood(), map);
//        List<Coordinates> pathListHerbivore = new ArrayList<>(pathHerbivore);
//        Collections.reverse(pathListHerbivore);
//        System.out.println("Кролик" + pathListHerbivore);
//
//        int count = 1;
//        Actions actions = new Actions(map);
//
//        while (count < 10) {
//            if (count == 6) {
//                int a = 123;
//            }
//            actions.turnActions();
//            mapConsoleRenderer.render(map);
//
//            path = PathSearchAlgorithm.getPath(predator.getCoordinates(), predator.getFood(), map);
//            pathList = new ArrayList<>(path);
//            Collections.reverse(pathList);
//            System.out.println("Хищник" + pathList);
//
//            pathHerbivore = PathSearchAlgorithm.getPath(herbivore.getCoordinates(), herbivore.getFood(), map);
//            pathListHerbivore = new ArrayList<>(pathHerbivore);
//            Collections.reverse(pathListHerbivore);
//            System.out.println("Кролик" + pathListHerbivore);
//
//            count++;
//        }
//
////        Coordinates[] xxx = path.toArray(new Coordinates[0]);
////        List<Coordinates> fff = Arrays.stream(xxx).toList().reversed();
//        int a = 123;
    }
}