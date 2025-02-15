package com.example.simulation.entities;

import com.example.simulation.Coordinates;
import com.example.simulation.Manager;
import com.example.simulation.Map;
import com.example.simulation.search_algorithm.BreadthFirstSearch;
import com.example.simulation.search_algorithm.PathSearchAlgorithm;

import java.util.*;

public abstract class Creature extends Entity {
    protected Coordinates coordinates;
    protected int health;
    protected final int speed;
    protected final Class <? extends Entity> food;

    public Creature(Coordinates coordinates, int health, int speed, Class <? extends Entity> food) {
        this.coordinates = coordinates;
        this.health = health;
        this.speed = speed;
        this.food = food;
    }

    public Creature(int health, int speed, Class <? extends Entity> food) {
        this.health = health;
        this.speed = speed;
        this.food = food;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public Class<? extends Entity> getFood() {
        return food;
    }

    public void makeMove(Map map) {
//        PathSearchAlgorithm algorithm = new BreadthFirstSearch();
//        LinkedHashSet<Coordinates> path = PathSearchAlgorithm.getPath(coordinates, food, map);
        LinkedHashSet<Coordinates> path = Manager.getDefaultPathSearchAlgorithm().getPath(coordinates, food, map);
        List<Coordinates> pathList = new ArrayList<>(path);
        Collections.reverse(pathList);

        if (pathList.isEmpty()) {
            health--;
            return;
        }

        if (isFoodReachable(pathList)) {
            Coordinates target = pathList.getLast();
            makeAttack(target, map);
            return;
        }

        moveAlongPath(pathList, map);
    }

    private boolean isFoodReachable(List<Coordinates> pathList) {
        return pathList.size() == 2;
    }

    private void moveAlongPath(List<Coordinates> pathList, Map map) {
        int steps = Math.min(pathList.size() - 2, speed);

        if (steps > 0) {
            Coordinates newCoordinates = pathList.get(steps);
            updatePosition(newCoordinates, map);
        }
    }

    protected void updatePosition(Coordinates newCoordinates, Map map) {
        map.removeEntity(this.coordinates);
        setCoordinates(newCoordinates);
        map.setEntity(newCoordinates, this);
    }

    protected abstract void makeAttack(Coordinates target, Map map);

    protected boolean isALive() {
        return health > 0;
    }

    @Override
    protected boolean canMove() {
        return isALive();
    }

    @Override
    public void act(Map map) {
        if (canMove()) {
            makeMove(map);
        } else {
            if (this.equals(map.getEntity(coordinates))) {
                map.removeEntity(coordinates);
            }
        }
    }

    @Override
    public String toString() {
        return "Creature{" +
                "coordinates=" + coordinates +
                ", health=" + health +
                ", speed=" + speed +
                ", food=" + food +
                '}';
    }
}
