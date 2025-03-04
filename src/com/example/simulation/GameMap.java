package com.example.simulation;

import com.example.simulation.entities.*;
import com.example.simulation.exceptions.OutOfMapBoundsException;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class GameMap {
    private final int rows;
    private final int columns;
    private final Map<Coordinates, Entity> entities = new HashMap<>();

    public GameMap(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public HashMap<Coordinates, Entity> getEntities() {
        return new HashMap<>(entities);
    }

    public void removeEntities() {
        entities.clear();
    }

    public void setEntity(Coordinates coordinates, Entity entity) {
        validateCoordinates(coordinates);
        entities.put(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates) {
        validateCoordinates(coordinates);

        if (entities.get(coordinates) == null) {
            throw new NoSuchElementException("Element not found to coordinates");
        }
        return entities.get(coordinates);
    }

    public void removeEntity(Coordinates coordinates) {
        validateCoordinates(coordinates);
        entities.remove(coordinates);
    }

    public boolean isCoordinatesValid(Coordinates coordinates) {
        if ((coordinates.getRow() < 1) || (coordinates.getRow() > rows)) {
            return false;
        }
        return (coordinates.getColumn() >= 1) && (coordinates.getColumn() <= columns);
    }

    private void validateCoordinates(Coordinates coordinates) {
        if (!(isCoordinatesValid(coordinates))) {
            throw new OutOfMapBoundsException(String.format(
                    "Сoordinate is outside the map: %d: %d",
                    coordinates.getRow(),
                    coordinates.getColumn()));
        }
    }
}
