package com.example.simulation;

import com.example.simulation.Entitys.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Map {
    private final int rows;
    private final int columns;
    private final HashMap<Coordinates, Entity> entities = new HashMap<>();
//    private List<Creature> creatures = new ArrayList<>();

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

//        Creature creature = (Creature) entity;

        removeEntity(from);
//        creature.setCoordinates(to);
        setEntity(to, entity);
    }

    public boolean canMove(Entity entity) {
        return entity instanceof Creature;
    /*
    * if (entity instanceof Creature) {
        Creature creature = (Creature) entity;
        return creature.isAlive() && !creature.isStunned(); // Пример дополнительных проверок
    }
    return false;
    * Этот код проверяет не только тип объекта, но и его состояние (например, жив ли он и не оглушен ли).
    * */
    }

    public void removeEntity(Coordinates from){
        entities.remove(from);
    }

    public void setEntity(Coordinates to, Entity entity){
        entities.put(to, entity);
    }

//    public List<Creature> getCreatures() {
//        return creatures;
//    }
//
//    public void setCreatures(Creature creature) {
//        creatures.add(creature);
//    }
}
