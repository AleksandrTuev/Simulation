package com.example.simulation;

import com.example.simulation.actions.*;
import com.example.simulation.actions.spawn_action.RespawnGrassAction;
import com.example.simulation.actions.spawn_action.RespawnHerbivoreAction;
import com.example.simulation.actions.spawn_action.RespawnPredatorAction;
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
        this.turnActions = List.of(new CreatureInteractionAction(), new RespawnHerbivoreAction());
    }

    public void gameLoop() {
        Menu menu = new Menu("Меню:", "Выберите пункт меню:", "Неверный ввод!", map);
        menu.add("Расставить сущности", new SpawnAction());
        menu.add("Запустить симуляцию", new CreatureInteractionAction());
        menu.add("Добавить травоядное животное", new RespawnHerbivoreAction());
        menu.add("Добавить траву", new RespawnGrassAction());
        menu.add("Добавить хищника", new RespawnPredatorAction());
        menu.add("Очистить карту", new ClearMapAction());
        menu.add("Выход", new ExitAction());

//        menu.show();
//        menu.select();
//
//        menu.show();
//        menu.select();
//
//        while (count < 50) {
////            menu.show();
////            menu.select();
//            mapConsoleRenderer.render(map);
//            System.out.println();
//            count++;
//        }

        while (true) {
            menu.show();
            menu.select();
        }

//
    }
}
