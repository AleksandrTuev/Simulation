package com.example.simulation;

import com.example.simulation.Entitys.*;

public class MapConsoleRenderer {

    public void render(Map map){
    Coordinates coordinates;

        for (int i = 1; i < map.getRows() + 1; i++) {
            String line = "";
            for (int j = 1; j < map.getColumns() + 1; j++) {
                coordinates = new Coordinates(i, j);

                if (!(map.getEntities().containsKey(coordinates))){
//                    line += "☐";
                    //line += "..";
                    line += "🏿";

                } else {
                    Entity entity = map.getEntities().get(coordinates);
                    //⛰ 𝈵 🌵 🏛 ⛰️🪨 - гора/камень - 2
                    //🌳 - дерево - 2
                    //❀✿𓆸 𝈙 🏵 🍀 - трава - 7
                    //𓃲 𝈔 🐇 🐐 - травоядные - 7
                    //𓃬 𝈳 🐆 🐅 🐯 🦁- хищник - 3

                    if (entity instanceof Rock){
                        line += "🪨";
                    } else if (entity instanceof Tree) {
                        line += "🌳";
                    } else if (entity instanceof Grass) {
                        line += "🍀";
                    } else if (entity instanceof Herbivore) {
                        line += "🐇";
                    } else if (entity instanceof Predator) {
                        line += "🦁";
                    }
                }
            }
            System.out.println(line);
        }
    }
}
