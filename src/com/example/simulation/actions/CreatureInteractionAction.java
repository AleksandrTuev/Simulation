package com.example.simulation.actions;

import com.example.simulation.Map;
import com.example.simulation.MapConsoleRenderer;
import com.example.simulation.entities.Creature;
import com.example.simulation.entities.Entity;

public class CreatureInteractionAction implements Action{
    @Override
    public void execute(Map map) {
        if (isEmptyMap(map)) {
            System.out.println("Карта не заполнена сущностями");
            return;
        }

        while (isLivingCreatures(map)) {
            for (Entity entity : map.getEntities().values()) {
                entity.act(map);
            }
            System.out.println();
            MapConsoleRenderer.render(map);
        }
    }

    private boolean isEmptyMap(Map map) {
        return map.getEntities().isEmpty();
    }

    private boolean isLivingCreatures(Map map) {
        for (Entity entity : map.getEntities().values()) {
            if (entity instanceof Creature) {
                return true;
            }
        }
        return false;
    }
}
