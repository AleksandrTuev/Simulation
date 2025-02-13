package com.example.simulation.actions;

import com.example.simulation.Map;
import com.example.simulation.entities.Entity;

public class TurnAction implements Action{
    @Override
    public void execute(Map map) {
        for (Entity entity : map.getEntities().values()) {
            entity.act(map);
        }
    }
}
