package com.example.simulation.Entitys;

import com.example.simulation.Coordinates;
import com.example.simulation.PathSearchAlgorithm;

import java.util.HashSet;
import java.util.Set;

public class Herbivore extends Creature { //травоядное животное
//    private final int numberOfSteps = 2;

    public Herbivore(Coordinates coordinates) {
        super(coordinates, 10, 2, Tree.class);
    }

//    @Override
//    protected Set<CoordinatesShift> getCreatureMoves() {
//        Set<CoordinatesShift> result = new HashSet<>();
//
////        result.add(new CoordinatesShift(-1,1)); //-1,1
////        result.add(new CoordinatesShift(0,1));//0,1
////        result.add(new CoordinatesShift(1,1));//1,1
////        result.add(new CoordinatesShift(1,0));//1,0
////        result.add(new CoordinatesShift(1,-1));//1,-1
////        result.add(new CoordinatesShift(0,-1));//0,-1
////        result.add(new CoordinatesShift(-1,0));//-1,0
////        result.add(new CoordinatesShift(-1,-1));//-1,-1
//
//        for (int i = -(numberOfSteps); i <= numberOfSteps; i++){
//            for (int j = -(numberOfSteps); j <= numberOfSteps; j++){
//                if ((i == 0) && (j == 0)) continue;
//
//                result.add(new CoordinatesShift(i, j));
//            }
//        }
//        return result;
//    }

    //тратят свой ход на движение к траве или на её поглощение
}
