package com.example.simulation.actions.spawn_action;

import com.example.simulation.Coordinates;
import com.example.simulation.Map;

import java.util.Random;

public class RandomAvailableCoordinateGenerator {
    public static Coordinates generate(Map map){
        Random random = new Random();
        Coordinates coordinates;

        while (true) {
            int row = random.nextInt(map.getRows() + 1);
            int column = random.nextInt(map.getColumns() + 1);

            if ((row == 0) || (column == 0)) continue;

            coordinates = new Coordinates(row, column);

            if (isAvailableCell(coordinates, map)) {
                return coordinates;
            }
            //todo написать метод по просмотру общего количества ячеек и количество занятых
        }
    }

    private static boolean isAvailableCell(Coordinates coordinates, Map map) {
        map.isCoordinatesValid(coordinates);
        return (!map.getEntities().containsKey(coordinates));
    }
}
