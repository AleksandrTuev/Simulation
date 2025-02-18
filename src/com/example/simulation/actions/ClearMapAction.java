package com.example.simulation.actions;

import com.example.simulation.Map;
import com.example.simulation.MapConsoleRenderer;

public class ClearMapAction implements Action{
    @Override
    public void execute(Map map) {
        map.removeEntities();
        MapConsoleRenderer.render(map);
    }
}
