package com.example.simulation.entities;

import com.example.simulation.Coordinates;
import com.example.simulation.search_algorithm.PathSearchAlgorithmFactory;
import com.example.simulation.GameMap;

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

    public void makeMove(GameMap gameMap) {
        LinkedHashSet<Coordinates> path = PathSearchAlgorithmFactory.getDefaultPathSearchAlgorithm().getPath(coordinates, food, gameMap);
        List<Coordinates> pathList = new ArrayList<>(path);
        Collections.reverse(pathList);

        if (pathList.isEmpty()) {
            health--;
            return;
        }

        if (isFoodReachable(pathList)) {
            Coordinates target = pathList.getLast();
            makeAttack(target, gameMap);
            increaseLife();
            return;
        }

        moveAlongPath(pathList, gameMap);
    }

    private void increaseLife() {
        if (health < 10) {
            health++;
        }
    }

    private boolean isFoodReachable(List<Coordinates> pathList) {
        return pathList.size() == 2;
    }

    private void moveAlongPath(List<Coordinates> pathList, GameMap gameMap) {
        int steps = Math.min(pathList.size() - 2, speed);

        if (steps > 0) {
            Coordinates newCoordinates = pathList.get(steps);
            updatePosition(newCoordinates, gameMap);
        }
    }

    protected void updatePosition(Coordinates newCoordinates, GameMap gameMap) {
        gameMap.removeEntity(this.coordinates);
        setCoordinates(newCoordinates);
        gameMap.setEntity(newCoordinates, this);
    }

    protected abstract void makeAttack(Coordinates target, GameMap gameMap);

    protected boolean isALive() {
        return health > 0;
    }

    @Override
    protected boolean canMove() {
        return isALive();
    }

    @Override
    public void act(GameMap gameMap) {
        if (canMove()) {
            makeMove(gameMap);
        } else {
            if (this.equals(gameMap.getEntity(coordinates))) {
                gameMap.removeEntity(coordinates);
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
