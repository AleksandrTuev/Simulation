package com.example.simulation.Entitys;

import com.example.simulation.Coordinates;
import com.example.simulation.Map;

import java.util.HashSet;
import java.util.Set;

abstract class Creature extends Entity { //существо
    //скорость (сколько клеток проходит за раз)
    protected int healthPoints; //очков здоровья
    protected final int searchRadius; //радиус поиска
    protected Class <? extends Entity> food;
    public Creature(Coordinates coordinates, int healthPoints, int searchRadius, Class <? extends Entity> food) {
        super(coordinates);
        this.healthPoints = healthPoints;
        this.searchRadius = searchRadius;
        this.food = food;
    }

    protected Set<CoordinatesShift> getCreatureMoves (){
        Set<CoordinatesShift> result = new HashSet<>();

        for (int i = -(searchRadius); i <= searchRadius; i++){
            for (int j = -(searchRadius); j <= searchRadius; j++){
                if ((i == 0) && (j == 0)) continue;

                result.add(new CoordinatesShift(i, j));
            }
        }
        return result;
    }

    protected Set<Coordinates> getAvailableMovesSquares (Map map){
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
}
