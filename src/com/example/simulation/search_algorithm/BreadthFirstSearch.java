package com.example.simulation.search_algorithm;

import com.example.simulation.Coordinates;
import com.example.simulation.GameMap;
import com.example.simulation.entities.Entity;

import java.util.*;

public class BreadthFirstSearch implements PathSearchAlgorithm {
    private static final Coordinates[] SHIFT_COORDINATES = {
            new Coordinates(-1, 1),
            new Coordinates(0, 1),
            new Coordinates(1, 1),
            new Coordinates(1, 0),
            new Coordinates(1, -1),
            new Coordinates(0, -1),
            new Coordinates(-1, -1),
            new Coordinates(-1, 0)
    };
//    private static final Coordinates[] SHIFT_COORDINATES = { //случай когда ходят только вверх-вниз/ влево-вправо
//            new Coordinates(0, 1),
//            new Coordinates(1, 0),
//            new Coordinates(0, -1),
//            new Coordinates(-1, 0)
//    };

    @Override
    public LinkedHashSet<Coordinates> getPath(Coordinates from, Class<? extends Entity> food, GameMap gameMap) {
        Deque<Coordinates> queue = new ArrayDeque<>();
        Set<Coordinates> visitedCells = new HashSet<>();
        Map<Coordinates, Coordinates> path = new HashMap<>();
        LinkedHashSet<Coordinates> result = new LinkedHashSet<>();
        Coordinates coordinates;

        queue.addLast(from);

        while (!queue.isEmpty()) {
            coordinates = queue.pollFirst();
            visitedCells.add(coordinates);

            for (Coordinates shiftCoordinate : SHIFT_COORDINATES) {
                Coordinates newCoordinates = coordinates.add(shiftCoordinate);

                if (canShift(coordinates, shiftCoordinate, gameMap)) {
                    if (gameMap.getEntities().containsKey(newCoordinates)) {
                        if (food.equals(gameMap.getEntity(newCoordinates).getClass())) {
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
                        if (!queue.contains(newCoordinates)) {
                            if (!visitedCells.contains(newCoordinates)) {
                                queue.addLast(newCoordinates);
                                path.put(newCoordinates, coordinates);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean canShift(Coordinates coordinates, Coordinates shiftCoordinate, GameMap gameMap) {
        int row = coordinates.getRow() + shiftCoordinate.getRow();
        int column = coordinates.getColumn() + shiftCoordinate.getColumn();

        return gameMap.isCoordinatesValid(new Coordinates(row, column));
    }
}

