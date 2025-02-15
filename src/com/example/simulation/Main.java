package com.example.simulation;

import com.example.simulation.actions.Action;
import com.example.simulation.actions.spawn_action.SpawnAction;

public class Main {
    public static void main(String[] args) {
        //todo сделать проверку что приходят числа иначе исключение NumberFormatException
        Simulation simulation = new Simulation(10, 20); //10 20
        simulation.gameLoop();
        int a = 123;
        Map map = new Map(10, 20);

        Menu menu = new Menu(
                "Стартовый экран:", "Выберите пункт меню:", "Неверный ввод!");
//        menu.add("Выберите карту", SpawnAction::execute);




        // - сделать проверку координат - вставить, взять, удалить - в случае некорректных данных кидать исключение
        // - реализовать архитектуру для Actions
    }
}