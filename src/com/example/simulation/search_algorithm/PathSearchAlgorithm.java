package com.example.simulation.search_algorithm;

import com.example.simulation.Coordinates;
import com.example.simulation.GameMap;
import com.example.simulation.entities.Entity;

import java.util.LinkedHashSet;

public interface PathSearchAlgorithm {
    LinkedHashSet<Coordinates> getPath(Coordinates from, Class<? extends Entity> food, GameMap gameMap);
}