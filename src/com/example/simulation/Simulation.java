package com.example.simulation;

import com.example.simulation.actions.Action;
import com.example.simulation.actions.CreatureInteractionAction;
import com.example.simulation.actions.RespawnAction;
import com.example.simulation.actions.spawn_action.SpawnAction;

import java.util.List;

public class Simulation {
    private final Map map;
    private final MapConsoleRenderer mapConsoleRenderer;
    private List<Action> initActions;
    private List<Action> turnActions;
    private int count = 0;
    //com.example.simulation.Map
    //Count
    //Рендерер поля (отрисовка)
    //com.example.simulation.actions.Actions - список действий, исполняемых перед стартом симуляции или на каждом ходу


    public Simulation(int rows, int columns) {
        this.map = new Map(rows,columns);
        this.mapConsoleRenderer = new MapConsoleRenderer();
        this.initActions = List.of(new SpawnAction());
        this.turnActions = List.of(new CreatureInteractionAction(), new RespawnAction());
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





//        List<Action> actions = List.of(new InitAction(), new MapRendererAction(), new TurnAction(), new MapRendererAction());
//        for (Action action : actions) {
//            action.execute(map);
//            System.out.println();
//        }



//        Action init = new SpawnAction();
//        Action render = new MapRendererAction();
//        Action turn = new TurnAction();
//        Action spawn = new RespawnAction();
//
//        init.execute(map);
//        render.execute(map);
//        count++;
//
//        //todo магические числа
//        while (count < 50) {
//            System.out.println("Ход: " + count);
//            turn.execute(map);
//            if (count % 20 == 0) {
//                spawn.execute(map);
////                map.setEntity(new Coordinates(-1, 60), new Herbivore(new Coordinates(-1, 60)));
////                map.getEntity(new Coordinates(-1, 60));
////                map.removeEntity(new Coordinates(-1, 60));
//            }
//            render.execute(map);
//            count++;
//        }
//
//        try {
//            while (count < 50) {
//                System.out.println("Ход: " + count);
//                turn.execute(map);
//                if (count % 20 == 0) {
//                    spawn.execute(map);
//                map.setEntity(new Coordinates(-1, 60), new Herbivore(new Coordinates(-1, 60)));
////                map.getEntity(new Coordinates(-1, 60));
////                map.removeEntity(new Coordinates(-1, 60));
//                }
//                render.execute(map);
//                count++;
//            }
//        } catch (OutOfMapBoundsException exception) {
//            System.out.println(exception.getMessage());
//        }
    }
}
