package com.example.simulation;

import com.example.simulation.entities.*;
import com.example.simulation.exceptions.OutOfMapBoundsException;

import java.util.HashMap;

public class Map {
    private final int rows;
    private final int columns;
    private final HashMap<Coordinates, Entity> entities = new HashMap<>();

    public Map(int rows, int columns) {
        //todo сделать проверку что значение row > 0 и column > 0 иначе исключение IllegalFormatException

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
        return entities.get(coordinates);
    }

    public void removeEntity(Coordinates coordinates) {
        validateCoordinates(coordinates);
        entities.remove(coordinates);
    }

    public boolean canShift(Coordinates coordinates, CoordinatesShift coordinatesShift) {
        int row = coordinates.getRow() + coordinatesShift.getRowShift();
        int column = coordinates.getColumn() + coordinatesShift.getColumnShift();

        return isCoordinatesValid(new Coordinates(row, column));
    }

//    public boolean isAvailableCell(Coordinates coordinates) {
//        return (!entities.containsKey(coordinates));
//    }

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
