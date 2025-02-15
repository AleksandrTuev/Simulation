package com.example.simulation.search_algorithm;

import com.example.simulation.Coordinates;
import com.example.simulation.Map;
import com.example.simulation.entities.CoordinatesShift;
import com.example.simulation.entities.Entity;

import java.util.*;

public class BreadthFirstSearch implements PathSearchAlgorithm{

    @Override
    public LinkedHashSet<Coordinates> getPath(Coordinates from, Class<? extends Entity> food, Map map) {
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
                    Coordinates newCoordinates = coordinates.add(coordinatesShift);

                    if (map.canShift(coordinates, coordinatesShift)) {
                        if (map.getEntities().containsKey(newCoordinates)) {
                            if (food.equals(map.getEntity(newCoordinates).getClass())) {
                                path.put(newCoordinates, coordinates);
                                result.add(newCoordinates);

                                while (true) {
                                    newCoordinates = path.get(newCoordinates);
                                    result.add(newCoordinates);

                                    if (newCoordinates == from) {
                                        return result;
                                    }
                                }
                            }
                        } else {
                            if (!(queue.contains(newCoordinates))) {
                                if (!(visitedCells.contains(newCoordinates))) {
                                    queue.addLast(newCoordinates);
                                    path.put(newCoordinates, coordinates);
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

