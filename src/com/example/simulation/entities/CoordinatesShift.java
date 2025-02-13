package com.example.simulation.entities;

public class CoordinatesShift {
    private final int rowShift;
    private final int columnShift;

    public CoordinatesShift(int rowShift, int columnShift) {
        this.rowShift = rowShift;
        this.columnShift = columnShift;
    }

    public int getRowShift() {
        return rowShift;
    }

    public int getColumnShift() {
        return columnShift;
    }
}
