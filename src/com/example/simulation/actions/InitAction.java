package com.example.simulation.actions;

import com.example.simulation.Coordinates;
import com.example.simulation.Map;
import com.example.simulation.entities.*;

public class InitAction implements Action{
    private static final int AMOUNT_GRASS = 20;
    private static final int AMOUNT_ROCK = 1;
    private static final int AMOUNT_TREE = 1;
    private static final int AMOUNT_HERBIVORE = 15;
    private static final int AMOUNT_PREDATOR = 5;
    private Map map;
    //initActions - действия, совершаемые перед стартом симуляции. Пример - расставить объекты и существ на карте
    //turnActions - действия, совершаемые каждый ход. Примеры - передвижение существ, добавить травы или травоядных, если их осталось слишком мало

    @Override
    public void execute (Map map) {
        this.map = map;
        setupEntitiesPositions();
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

        for (int i = 0; i < count; i++) {
            if (entity instanceof Rock){
                coordinates = RandomAvailableCoordinateGenerator.generate(map);
                Rock rock = new Rock();
                map.setEntity(coordinates, rock);
            } else if (entity instanceof Tree) {
                coordinates = RandomAvailableCoordinateGenerator.generate(map);
                Tree tree = new Tree();
                map.setEntity(coordinates, tree);
            } else if (entity instanceof Grass) {
                coordinates = RandomAvailableCoordinateGenerator.generate(map);
                Grass grass = new Grass();
                map.setEntity(coordinates, grass);
            } else if (entity instanceof Herbivore) {
                coordinates = RandomAvailableCoordinateGenerator.generate(map);
                Herbivore herbivore = new Herbivore(coordinates);
                map.setEntity(coordinates, herbivore);
            } else if (entity instanceof Predator) {
                coordinates = RandomAvailableCoordinateGenerator.generate(map);
                Predator predator = new Predator(coordinates);
                map.setEntity(coordinates, predator);
            }
        }
    }
}
