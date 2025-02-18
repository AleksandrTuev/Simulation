package com.example.simulation;

import com.example.simulation.actions.*;
import com.example.simulation.actions.spawn_action.RespawnGrassAction;
import com.example.simulation.actions.spawn_action.RespawnHerbivoreAction;
import com.example.simulation.actions.spawn_action.RespawnPredatorAction;
import com.example.simulation.actions.spawn_action.SpawnAction;

public class Simulation {
    private final Map map;
    private static final int TIME_POINT = 150;
    private int count = 0;

    public Simulation(int rows, int columns) {
        this.map = new Map(rows,columns);
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

        while (count < TIME_POINT) {
            menu.show();
            menu.select();
            count++;
        }
    }
}
