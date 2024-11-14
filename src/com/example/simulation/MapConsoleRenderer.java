package com.example.simulation;

public class MapConsoleRenderer {

    public void render(Map map){
        for (int i = 0; i < map.getColumns(); i++) {
            for (int j = 0; j < map.getRows(); j++) {
                System.out.print("☐");
            }
            System.out.print("\n");
        }
    }
}
