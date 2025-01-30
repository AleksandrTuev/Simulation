package com.example.simulation.Entitys;

import com.example.simulation.Coordinates;
import com.example.simulation.Map;
import com.example.simulation.PathSearchAlgorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Creature extends Entity { //существо
    //скорость (сколько клеток проходит за раз)
    protected int healthPoints; //очков здоровья
    protected final int numberOfSteps; //количество шагов/клеток можно делать за ход
    protected final int attackDamage; //урон при атаке цели
    protected int distanceTraveled; //пройденное расстояние
    protected Class <? extends Entity> food;
    public Creature(Coordinates coordinates, int healthPoints, int numberOfSteps, int attackDamage, Class <? extends Entity> food) {
        super(coordinates);
        this.healthPoints = healthPoints;
        this.numberOfSteps = numberOfSteps;
        this.attackDamage = attackDamage;
        this.food = food;
    }

    public Class<? extends Entity> getFood() {
        return food;
    }

    public void makeMove(Map map) {
//        //TODO
    //найти цель
        List<Coordinates> pathList = new ArrayList<>(PathSearchAlgorithm.getPath(getCoordinates(), food, map));

        if ((pathList.isEmpty()) || (pathList.size() - 2 == 0)) {
            //Если координат нет - сделать рандомный ход TODO
            //если ходов больше 5, то -1 hp , и добавить ход
            return;
        }

        int count = pathList.size() - 2;
        int numberAttacks = 0;

        if (count >= numberOfSteps) {
            count = numberOfSteps;
        } else {
            //numberOfSteps - count = кол-во шагов
            count = numberOfSteps - count;
            //numberOfSteps - кол-во шагов = кол-во атак
            numberAttacks = numberOfSteps - count;
            //кол-во атаки равно количеству оставшихся ходов
        }

        Coordinates coordinates = pathList.get(count);

        map.makeMove(getCoordinates(), coordinates);


        //если цели нет -1 жизнь каждый ход
    //если цель есть определить путь (сделать ход на возможное количество ходов)

    //у травоядных урон атаки 1 клетка - 1 hp
    //у хищника урон атаки 1 клетка - 2 hp
    //счётчик ходов, каждые 5 клеток уровень hp уменьшается, если происходит атака, то счётчик обнуляется
    }

//    private int getStepCount(int numberOfSteps, int number) {
//        int count = number - 2;
//        if (count == numberOfSteps) {
//            return count = numberOfSteps;
//        } else if (count < numberOfSteps) {
//            if ()
//        }
//    }
//
//    public void targetSearch() {
//        //TODO
//    }

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
