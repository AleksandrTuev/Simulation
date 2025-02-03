package com.example.simulation;

import com.example.simulation.Entitys.CoordinatesShift;
import com.example.simulation.Entitys.Entity;

import java.util.*;

public class PathSearchAlgorithm {
    public static LinkedHashSet<Coordinates> getPath(Coordinates from, Class<? extends Entity> food, Map map) {
        Deque<Coordinates> queue = new ArrayDeque<>();
        Set<Coordinates> visitedCells = new HashSet<>();
        HashMap<Coordinates, Coordinates> path = new HashMap<>();
        LinkedHashSet<Coordinates> result = new LinkedHashSet<>();
        Coordinates coordinates;

        queue.addLast(from);

        while (!(queue.isEmpty())) {
            coordinates = queue.pollFirst();
            visitedCells.add(coordinates);

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if ((i == 0) && (j == 0)) continue;

                    CoordinatesShift coordinatesShift = new CoordinatesShift(i, j);

                    if (coordinates.canShift(coordinatesShift, map)) {
                        if (map.getEntities().containsKey(coordinates.shift(coordinatesShift))) {
                            if (food.equals(map.getEntity(coordinates.shift(coordinatesShift)).getClass())) {
                                path.put(coordinates.shift(coordinatesShift), coordinates);
                                Coordinates targetCoordinates = coordinates.shift(coordinatesShift);
                                result.add(targetCoordinates);

                                while (true) {
                                    Coordinates newCoordinates = path.get(targetCoordinates);
                                    targetCoordinates = newCoordinates;
                                    result.add(targetCoordinates);

                                    if (targetCoordinates == from) {
                                        return result;
                                    }
                                }
                            }
                        } else {
                            if (!(queue.contains(coordinates.shift(coordinatesShift)))) {
                                if (!(visitedCells.contains(coordinates.shift(coordinatesShift)))) {
                                    queue.addLast(coordinates.shift(coordinatesShift));
                                    path.put(coordinates.shift(coordinatesShift), coordinates);
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}

