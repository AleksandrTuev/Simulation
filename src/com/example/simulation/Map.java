package com.example.simulation;

import com.example.simulation.entities.*;

import java.util.HashMap;

public class Map {
    private final int rows;
    private final int columns;
    private final HashMap<Coordinates, Entity> entities = new HashMap<>();

    public Map(int rows, int columns) {
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

    public void setEntity(Coordinates to, Entity entity){
        entities.put(to, entity);
    }

    public Entity getEntity(Coordinates coordinates){
        return entities.get(coordinates);
    }

    public void removeEntity(Coordinates from){
        entities.remove(from);
    }

    public boolean canShift(Coordinates coordinates, CoordinatesShift coordinatesShift) {
        int i = coordinates.getRow() + coordinatesShift.getRowShift();
        int j = coordinates.getColumn() + coordinatesShift.getColumnShift();

        if ((i < 1) || (i > rows)) {
            return false;
        }
        return (j >= 1) && (j <= columns);
    }

    public boolean isAvailableCell(Coordinates coordinates) {
        return (!entities.containsKey(coordinates));
    }
}
