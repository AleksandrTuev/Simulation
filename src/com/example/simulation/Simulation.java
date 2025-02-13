package com.example.simulation;

import com.example.simulation.actions.Action;
import com.example.simulation.actions.InitAction;
import com.example.simulation.actions.MapRendererAction;
import com.example.simulation.actions.TurnAction;

import java.util.List;

public class Simulation {
    private final Map map;
    private int count = 0;
    //com.example.simulation.Map
    //Count
    //Рендерер поля (отрисовка)
    //com.example.simulation.actions.Actions - список действий, исполняемых перед стартом симуляции или на каждом ходу


    public Simulation(int rows, int columns) {
        map = new Map(rows,columns);
    }

    public void gameLoop() {
//        InitAction initAction = new InitAction(map);
//        MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();
//        int count = 1;
//
//        initAction.initActions();
//        mapConsoleRenderer.render(map);
//        System.out.println("Количество ходов с момента старта: " + count);
//
//        while (map.getEntities().size() > 2) {
//            count++;
//            initAction.turnActions();
//            System.out.println();
//            mapConsoleRenderer.render(map);
//            System.out.println("Количество ходов с момента старта: " + count);
//        }
        List<Action> actions = List.of(new InitAction(), new MapRendererAction(), new TurnAction(), new MapRendererAction());
        for (Action action : actions) {
            action.execute(map);
            System.out.println();
        }
    }
}
