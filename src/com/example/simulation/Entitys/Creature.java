package com.example.simulation.Entitys;

import com.example.simulation.Coordinates;
import com.example.simulation.Map;
import com.example.simulation.PathSearchAlgorithm;

import java.util.*;

public abstract class Creature extends Entity { //существо
    //скорость (сколько клеток проходит за раз)
//    protected int healthPoints; //очков здоровья
    protected final int numberOfSteps; //количество шагов/клеток можно делать за ход
    protected final int attackDamage; //урон при атаке цели
    protected int distanceTraveled; //пройденное расстояние
    protected Class <? extends Entity> food;
    public Creature(Coordinates coordinates, int healthPoints, int numberOfSteps, int attackDamage, Class <? extends Entity> food) {
        super(coordinates, healthPoints);
//        this.healthPoints = healthPoints;
        this.numberOfSteps = numberOfSteps;
        this.attackDamage = attackDamage;
        this.food = food;
    }

    public Class<? extends Entity> getFood() {
        return food;
    }

    public void makeMove(Map map) {
        List<Coordinates> pathList = new ArrayList<>(PathSearchAlgorithm.getPath(getCoordinates(), food, map));
        Collections.reverse(pathList);

        if (pathList.isEmpty()) {
            //Если координат нет, то -1 hp
            setHealthPoints(getHealthPoints() - 1);
            return;
        }

        if (pathList.size() == 2) {
            makeAttack(pathList.get(0), pathList.get(1), numberOfSteps, map); //TODO
            return;
        }

        int count = pathList.size() - 2;
        int numberAttacks = 0;
        Coordinates coordinates;

        if (count >= numberOfSteps) {
            count = numberOfSteps;
            coordinates = pathList.get(count);
            map.makeMove(getCoordinates(), coordinates);
        } else {
            //count = кол-во шагов
//
            //numberOfSteps - кол-во шагов = кол-во атак
            coordinates = pathList.get(count);
            map.makeMove(pathList.get(0), coordinates);
            numberAttacks = numberOfSteps - count;
            makeAttack(getCoordinates(), pathList.get(pathList.size() - 1), numberAttacks, map); //TODO
            //кол-во атаки равно количеству оставшихся ходов
        }

        //если цели нет -1 жизнь каждый ход
    //если цель есть определить путь (сделать ход на возможное количество ходов)

    //у травоядных урон атаки 1 клетка - 1 hp
    //у хищника урон атаки 1 клетка - 2 hp
    //счётчик ходов, каждые 5 клеток уровень hp уменьшается, если происходит атака, то счётчик обнуляется
    }

    private void makeAttack(Coordinates start, Coordinates target, int numberAttacks, Map map) {
        Entity entity = map.getEntities().get(target);

        for (int i = 1; i <= numberAttacks; i++) {
            if (entity.getHealthPoints() > 0) {
                entity.setHealthPoints(entity.getHealthPoints() - attackDamage);
            } else {
                map.removeEntity(target);
                map.makeMove(start, target);
                return;
            }
        }
    }

    protected Set<CoordinatesShift> getCreatureMoves() {
        Set<CoordinatesShift> result = new HashSet<>();

        for (int i = -(numberOfSteps); i <= numberOfSteps; i++){
            for (int j = -(numberOfSteps); j <= numberOfSteps; j++){
                if ((i == 0) && (j == 0)) continue;

                result.add(new CoordinatesShift(i, j));
            }
        }
        return result;
    }

    protected Set<Coordinates> getAvailableMovesSquares(Map map) {
        Set<Coordinates> result = new HashSet<>();

        for (CoordinatesShift creatureMove : getCreatureMoves()) {
            if (coordinates.canShift(creatureMove, map)) {
                Coordinates newCoordinates = coordinates.shift(creatureMove);

                if (isAvailableSquareToMove(newCoordinates, map)) {
                    result.add(newCoordinates);
                }
            }
        }
        return result;
    }

    protected boolean isAvailableSquareToMove(Coordinates coordinates, Map map) {
        if (map.getEntities().containsKey(coordinates)) {
            Entity entity = map.getEntity(coordinates);

            return food.equals(entity.getClass());
        }
        return true;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "healthPoints=" + healthPoints +
                ", numberOfSteps=" + numberOfSteps +
                ", food=" + food +
                ", coordinates=" + coordinates +
                '}';
    }
}
