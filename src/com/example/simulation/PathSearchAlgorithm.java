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

                    if ((i == 0) && (j == 0)) {
                        continue;
                    }

                    CoordinatesShift coordinatesShift = new CoordinatesShift(i, j);

                    if (coordinates.canShift(coordinatesShift, map)) {
                        if (map.getEntities().containsKey(coordinates.add(coordinatesShift))) {
                            if (food.equals(map.getEntity(coordinates.add(coordinatesShift)).getClass())) {
                                path.put(coordinates.add(coordinatesShift), coordinates);
                                Coordinates targetCoordinates = coordinates.add(coordinatesShift);
                                result.add(targetCoordinates);

                                while (true) {
                                    targetCoordinates = path.get(targetCoordinates);
                                    result.add(targetCoordinates);

                                    if (targetCoordinates == from) {
                                        return result;
                                    }
                                }
                            }
                        } else {
                            if (!(queue.contains(coordinates.add(coordinatesShift)))) {
                                if (!(visitedCells.contains(coordinates.add(coordinatesShift)))) {
                                    queue.addLast(coordinates.add(coordinatesShift));
                                    path.put(coordinates.add(coordinatesShift), coordinates);
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

