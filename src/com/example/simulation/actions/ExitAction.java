package com.example.simulation.actions;

import com.example.simulation.Map;

public class ExitAction implements Action {
    @Override
    public void execute(Map map) {
        System.exit(0);
    }
}
