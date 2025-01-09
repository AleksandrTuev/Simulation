package com.example.simulation;

import com.example.simulation.Entitys.*;

import java.util.HashMap;
import java.util.Random;

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

    public void setupEntitiesPositions() { //настройка позиций сущностей
        //⛰ 𝈵 🌵 🏛 ⛰️🪨 - гора/камень - 2
        //🌳 - дерево - 2
        //❀✿𓆸 𝈙 🏵 🍀 - трава - 7
        //𓃲 𝈔 🐇 🐐 - травоядные - 7
        //𓃬 𝈳 🐆 🐅 🐯 🦁- хищник - 3
        //🦅 - орёл

        createEntity(new Rock(generateRandomCoordinates(rows, columns)), 7);
        createEntity(new Tree(generateRandomCoordinates(rows, columns)), 12);
        createEntity(new Grass(generateRandomCoordinates(rows, columns)), 17);
        createEntity(new Herbivore(generateRandomCoordinates(rows, columns)), 7);
        createEntity(new Predator(generateRandomCoordinates(rows, columns)), 3);
        //createEntity(Entity entity, int count, HashMap<Coordinates,Entity> entities);
        //
        //setEntityOnMap();
    }

    private void createEntity(Entity entity, int count){
        Coordinates coordinates;

        for (int i = 0; i < count; i++) {
            if (entity instanceof Rock){
                coordinates = generateRandomCoordinates(rows, columns);
                Rock rock = new Rock(coordinates);
                entities.put(coordinates, rock);
            } else if (entity instanceof Tree) {
                coordinates = generateRandomCoordinates(rows, columns);
                Tree tree = new Tree(coordinates);
                entities.put(coordinates, tree);
            } else if (entity instanceof Grass) {
                coordinates = generateRandomCoordinates(rows, columns);
                Grass grass = new Grass(coordinates);
                entities.put(coordinates, grass);
            } else if (entity instanceof Herbivore) {
                coordinates = generateRandomCoordinates(rows, columns);
                Herbivore herbivore = new Herbivore(coordinates);
                entities.put(coordinates, herbivore);
            } else if (entity instanceof Predator) {
                coordinates = generateRandomCoordinates(rows, columns);
                Predator predator = new Predator(coordinates);
                entities.put(coordinates, predator);
            }
        }
    }

    private Coordinates generateRandomCoordinates(int rows, int columns){
        Random random = new Random();
        Coordinates coordinates;

        while (true) {
            int x = random.nextInt(rows + 1);
            int y = random.nextInt(columns + 1);

            if ((x == 0) || (y == 0)) continue;

            coordinates = new Coordinates(x, y);

            if (!(entities.containsKey(coordinates))) {
                return coordinates;
            }
        }
    }
}
