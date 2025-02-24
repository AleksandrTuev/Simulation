package com.example.simulation.actions.spawn_action;

import com.example.simulation.Coordinates;
import com.example.simulation.GameMap;

import java.util.Random;

public class RandomAvailableCoordinateGenerator {
    public static Coordinates generate(GameMap gameMap){
        Random random = new Random();
        Coordinates coordinates;

        while (true) {
            int row = random.nextInt(gameMap.getRows() + 1);
            int column = random.nextInt(gameMap.getColumns() + 1);

            if ((row == 0) || (column == 0)) continue;

            coordinates = new Coordinates(row, column);

            if (isAvailableCell(coordinates, gameMap)) {
                return coordinates;
            }
        }
    }

    private static boolean isAvailableCell(Coordinates coordinates, GameMap gameMap) {
        gameMap.isCoordinatesValid(coordinates);
        return (!gameMap.getEntities().containsKey(coordinates));
    }
}
