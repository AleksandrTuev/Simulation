package com.example.simulation;

import com.example.simulation.Entitys.*;

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
        return entities;
    }

    public Entity getEntity(Coordinates coordinates){
        return entities.get(coordinates);
    }

    public void move(Coordinates from, Coordinates to) {
        Entity entity = getEntity(from);
        removeEntity(from);
        setEntity(to, entity);
    }

    public void removeEntity(Coordinates from){
        entities.remove(from);
    }

    public void setEntity(Coordinates to, Entity entity){
        entities.put(to, entity);
    }
}
