package com.example.simulation;

public class Simulation { //general class
    //com.example.simulation.Map
    //Count
    //Рендерер поля (отрисовка)
    //com.example.simulation.Actions - список действий, исполняемых перед стартом симуляции или на каждом ходу

    public void gameLoop() {
        Map map = new Map(10,20);
        Actions actions = new Actions(map);
        MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();
        int count = 1;

        actions.initActions();
        mapConsoleRenderer.render(map);

        while (count <= 3) {
            actions.turnActions();
            System.out.println();
            mapConsoleRenderer.render(map);

            count++;
        }

    }
}
