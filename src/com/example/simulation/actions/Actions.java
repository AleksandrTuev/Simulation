package com.example.simulation.actions;

import com.example.simulation.Coordinates;
import com.example.simulation.Map;
import com.example.simulation.entities.*;

import java.util.*;

public class Actions {
    private static final int AMOUNT_GRASS = 20;
    private static final int AMOUNT_ROCK = 1;
    private static final int AMOUNT_TREE = 1;
    private static final int AMOUNT_HERBIVORE = 5;
    private static final int AMOUNT_PREDATOR = 1;
    private final com.example.simulation.Map map;
    //initActions - действия, совершаемые перед стартом симуляции. Пример - расставить объекты и существ на карте
    //turnActions - действия, совершаемые каждый ход. Примеры - передвижение существ, добавить травы или травоядных, если их осталось слишком мало

    public Actions(Map map) {
        this.map = map;
    }

    public void initActions() {
        setupEntitiesPositions();
    }

    public void turnActions() {
        for (Entity entity : map.getEntities().values()) {
            entity.act(map);
        }
    }

    private void setupEntitiesPositions() {
        createEntity(new Rock(), AMOUNT_ROCK);
        createEntity(new Tree(), AMOUNT_TREE);
        createEntity(new Grass(), AMOUNT_GRASS);
        createEntity(new Herbivore(), AMOUNT_HERBIVORE);
        createEntity(new Predator(), AMOUNT_PREDATOR);
    }

    private void createEntity(Entity entity, int count){
        Coordinates coordinates;
        int rows = map.getRows();
        int columns = map.getColumns();

        for (int i = 0; i < count; i++) {
            if (entity instanceof Rock){
                coordinates = generateRandomCoordinates(rows, columns);
                Rock rock = new Rock();
                map.setEntity(coordinates, rock);
            } else if (entity instanceof Tree) {
                coordinates = generateRandomCoordinates(rows, columns);
                Tree tree = new Tree();
                map.setEntity(coordinates, tree);
            } else if (entity instanceof Grass) {
                coordinates = generateRandomCoordinates(rows, columns);
                Grass grass = new Grass();
                map.setEntity(coordinates, grass);
            } else if (entity instanceof Herbivore) {
                coordinates = generateRandomCoordinates(rows, columns);
                Herbivore herbivore = new Herbivore(coordinates);
                map.setEntity(coordinates, herbivore);
            } else if (entity instanceof Predator) {
                coordinates = generateRandomCoordinates(rows, columns);
                Predator predator = new Predator(coordinates);
                map.setEntity(coordinates, predator);
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

            if (!(map.getEntities().containsKey(coordinates))) {
                return coordinates;
            }
        }
    }
}
