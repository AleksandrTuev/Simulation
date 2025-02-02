package com.example.simulation;

import com.example.simulation.Entitys.*;

import java.util.*;

public class Actions { //действия
    private final Map map;
    //initActions - действия, совершаемые перед стартом симуляции. Пример - расставить объекты и существ на карте
    //turnActions - действия, совершаемые каждый ход. Примеры - передвижение существ, добавить травы или травоядных, если их осталось слишком мало

    public Actions(Map map) {
        this.map = map;
    }

    public void initActions() {
        setupEntitiesPositions();
    }

    public void turnActions() { //TODO
        List<Creature> list = new ArrayList<>();
        for (Creature creature : map.getCreatures()) {
            if (creature.getHealthPoints() <= 0) {
                list.add(creature);
                continue;
            }
            creature.makeMove(map);
        }

        for (Creature creature : list) {
            map.getCreatures().remove(creature);
            if (map.getEntities().containsValue(creature)) {
                map.removeEntity(creature.getCoordinates()); //удаляет последнее существо
            }
        }
    }

    private void setupEntitiesPositions() { //настройка позиций сущностей
        createEntity(new Rock(generateRandomCoordinates(map.getRows(), map.getColumns())), 7); //7
        createEntity(new Tree(generateRandomCoordinates(map.getRows(), map.getColumns())), 12); //12
        createEntity(new Grass(generateRandomCoordinates(map.getRows(), map.getColumns())), 17); //17
        createEntity(new Herbivore(generateRandomCoordinates(map.getRows(), map.getColumns())), 12); //7
        createEntity(new Predator(generateRandomCoordinates(map.getRows(), map.getColumns())), 1); //3
    }

    private void createEntity(Entity entity, int count){
        Coordinates coordinates;

        for (int i = 0; i < count; i++) {
            if (entity instanceof Rock){
                coordinates = generateRandomCoordinates(map.getRows(), map.getColumns());
                Rock rock = new Rock(coordinates);
                map.getEntities().put(coordinates, rock);
            } else if (entity instanceof Tree) {
                coordinates = generateRandomCoordinates(map.getRows(), map.getColumns());
                Tree tree = new Tree(coordinates);
                map.getEntities().put(coordinates, tree);
            } else if (entity instanceof Grass) {
                coordinates = generateRandomCoordinates(map.getRows(), map.getColumns());
                Grass grass = new Grass(coordinates);
                map.getEntities().put(coordinates, grass);
            } else if (entity instanceof Herbivore) {
                coordinates = generateRandomCoordinates(map.getRows(), map.getColumns());
                Herbivore herbivore = new Herbivore(coordinates);
                map.getEntities().put(coordinates, herbivore);
                map.setCreatures(herbivore);
            } else if (entity instanceof Predator) {
                coordinates = generateRandomCoordinates(map.getRows(), map.getColumns());
                Predator predator = new Predator(coordinates);
                map.getEntities().put(coordinates, predator);
                map.setCreatures(predator);
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
