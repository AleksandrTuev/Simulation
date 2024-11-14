package com.example.simulation;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;

public class Map { //карта
    private final int rows;
    private final int columns;
    private final HashMap<Coordinates, Entity> entities = new HashMap<>();

    public Map(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public HashMap<Coordinates, Entity> getEntities() {
        return entities;
    }

    public void setupEntitiesPosition() {
        //⛰ 𝈵 🌵 🏛 ⛰️🪨 - гора/камень - 10
        //🌳 - дерево - 10
        //❀✿𓆸 𝈙 🏵 🍀 - трава - 15
        //𓃲 𝈔 🐇 🐐 - травоядные - 10
        //𓃬 𝈳 🐆 🐅 🐯 - хищник - 5

    }
}
