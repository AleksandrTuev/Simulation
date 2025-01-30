package com.example.simulation;

public class Simulation { //general class
    private Map map;
    private int count = 0;
    //com.example.simulation.Map
    //Count
    //Рендерер поля (отрисовка)
    //com.example.simulation.Actions - список действий, исполняемых перед стартом симуляции или на каждом ходу


    public Simulation(int rows, int columns) {
        map = new Map(rows,columns);
    }

    public void gameLoop() {
        Actions actions = new Actions(map);
        MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();
        int count = 1;

        actions.initActions();
        mapConsoleRenderer.render(map);
        System.out.println("Количество ходов с момента старта: " + count);

        while (count <= 10) {
            count++;
            actions.turnActions();
            System.out.println();
            mapConsoleRenderer.render(map);
            System.out.println("Количество ходов с момента старта: " + count);

//            count++;
        }

    }
}
