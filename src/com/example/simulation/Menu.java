package com.example.simulation;

import com.example.simulation.actions.Action;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static final int START_ID = 1;
    private static final String UNICODE_IMAGE = "\uD83C\uDF41\uD83C\uDF41\uD83C\uDF41\uD83C\uDF41";

    private final String title;
    private final String selectMessage;
    private final String failMessage;

    private int id = START_ID;
    private final List<Item> items = new ArrayList<>();
    private final GameMap gameMap;

    public Menu(String title, String selectMessage, String failMessage, GameMap gameMap) {
        this.title = UNICODE_IMAGE + title + UNICODE_IMAGE;
        this.selectMessage = selectMessage;
        this.failMessage = failMessage;
        this.gameMap = gameMap;
    }

    public void add(String text, Action action) {
        Item item = new Item(id++, text, action);
        items.add(item);
    }

    public void show() {
        final String border = "---";
        System.out.println(title);
        System.out.println(border);
        for (Item item : items) {
            System.out.printf("%d. %s \n", item.id, item.text);
        }
        System.out.println(border);
    }

    public void select() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(selectMessage);
            String key = scanner.next();
            if (isInteger(key)) {
                int num = Integer.parseInt(key);
                if (num >= START_ID && num < id) {
                    Item item = items.get(num - START_ID);
                    item.action.execute(gameMap);
                    break;
                }
            }
            System.out.println(failMessage);
        }
    }

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    private static class Item{
        public final int id;
        public final String text;
        public final Action action;

        public Item(int id, String text, Action action) {
            this.id = id;
            this.text = text;
            this.action = action;
        }
    }
}
