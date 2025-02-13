package com.example.simulation;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation(10, 20); //10 20
        simulation.gameLoop();
        int a = 123;

        // - сделать проверку координат - вставить, взять, удалить - в случае некорректных данных кидать исключение
        // - реализовать архитектуру для Actions
    }
}