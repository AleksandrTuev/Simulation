package com.example.simulation.actions;

import com.example.simulation.Map;
import com.example.simulation.MapConsoleRenderer;

public class MapRendererAction implements Action{
    @Override
    public void execute(Map map) {
        MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();
        mapConsoleRenderer.render(map);
    }
}
