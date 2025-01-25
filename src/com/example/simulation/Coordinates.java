package com.example.simulation;

import com.example.simulation.Entitys.CoordinatesShift;

public class Coordinates {
    private int row;
    private int column;

    public Coordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Coordinates shift(CoordinatesShift coordinatesShift) {
        return new Coordinates(row + coordinatesShift.rowShift, column + coordinatesShift.columnShift);
    }

    public boolean canShift(CoordinatesShift coordinatesShift, Map map) {
        int i = row + coordinatesShift.rowShift;
        int j = column + coordinatesShift.columnShift;

        if ((i < 1) || (i > map.getRows())) return false;
        if ((j < 1) || (j > map.getColumns())) return false;

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (row != that.row) return false;
        return column == that.column;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + column;
        return result;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
