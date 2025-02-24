package com.example.simulation.actions;

import com.example.simulation.GameMap;

public class ExitAction implements Action {
    @Override
    public void execute(GameMap gameMap) {
        System.exit(0);
    }
}
