package com.example.simulation.Entitys;

import com.example.simulation.Coordinates;

public abstract class Entity {
    protected Coordinates coordinates;
    protected int healthPoints;

    public Entity(Coordinates coordinates, int healthPoints) {
        this.coordinates = coordinates;
        this.healthPoints = healthPoints;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
}
