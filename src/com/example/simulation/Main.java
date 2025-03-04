package com.example.simulation;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation(10, 20);
        simulation.gameLoop();
        //TODO Нужно ввести потоки и распечатывать кадры карты через равные промежутки времени, чтобы был эффект движущихся картинок
        //TODO Убрать MapConsoleRenderer.render(gameMap) из каждого экшиона (нарушение SRP)
    }
}