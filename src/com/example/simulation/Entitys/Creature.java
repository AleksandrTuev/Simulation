package com.example.simulation.Entitys;

import com.example.simulation.Coordinates;
import com.example.simulation.Map;
import com.example.simulation.PathSearchAlgorithm;

import java.util.*;

public abstract class Creature extends Entity {
    protected Coordinates coordinates;
    protected int health;
    protected final int speed;
//    protected final int attackDamage; //урон при атаке цели
//    protected int hungerCounter; //счётчик голода
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
        LinkedHashSet<Coordinates> path = PathSearchAlgorithm.getPath(coordinates, food, map);
        List<Coordinates> pathList = new ArrayList<>(path);
        Collections.reverse(pathList);

        if (pathList.isEmpty()) {
            health--;
            return;
        }

        if (pathList.size() == 2) {
            Coordinates target = pathList.getLast();
            makeAttack(target, map);
            return;
        }

        int countCells = pathList.size() - 2;

        if (countCells >= speed) {
            countCells = speed;
            Coordinates coordinates = pathList.get(countCells);
            map.move(getCoordinates(), coordinates);
            setCoordinates(coordinates); //todo
        } else if (countCells > 0) {
            Coordinates coordinates = pathList.get(countCells);
            map.move(getCoordinates(), coordinates);
            setCoordinates(coordinates); //todo
        }
    }

    protected abstract void makeAttack(Coordinates target, Map map);

    protected boolean isNotZeroHealth() {
        return health > 0;
    }

    @Override
    protected boolean canMove() {
        return isNotZeroHealth();
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
