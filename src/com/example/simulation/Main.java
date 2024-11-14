package com.example.simulation;

public class Main {
    public static void main(String[] args) {
        Map map = new Map(5,10);
        map.setupEntitiesPositions();
        MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();
        mapConsoleRenderer.render(map);
        int a = 123;
    }
}