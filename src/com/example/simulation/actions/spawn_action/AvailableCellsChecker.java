package com.example.simulation.actions.spawn_action;

import com.example.simulation.GameMap;

public interface AvailableCellsChecker {
    static boolean hasAvailableCells(GameMap gameMap) {
        int countCells = gameMap.getRows() * gameMap.getColumns();
        int countEntity = gameMap.getEntities().size();
        return countCells > countEntity;
    }
}
