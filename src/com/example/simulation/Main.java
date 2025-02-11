package com.example.simulation;

import com.example.simulation.Entitys.Grass;
import com.example.simulation.Entitys.Herbivore;
import com.example.simulation.Entitys.Predator;
import com.example.simulation.Entitys.Tree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation(10, 20); //10 20
        simulation.gameLoop();
    }
}