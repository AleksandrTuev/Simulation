package com.example.simulation.actions.spawn_action;

import com.example.simulation.Map;

public interface AvailableCellsChecker {
    static boolean hasAvailableCells(Map map) {
        int countCells = map.getRows() * map.getColumns();
        int countEntity = map.getEntities().size();
        return countCells > countEntity;
    }
}
