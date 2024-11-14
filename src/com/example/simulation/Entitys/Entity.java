package com.example.simulation.Entitys;

import com.example.simulation.Coordinates;

abstract class Entity { //сущность (все существа и объекты существующие в симуляции)
    Coordinates coordinates;

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
