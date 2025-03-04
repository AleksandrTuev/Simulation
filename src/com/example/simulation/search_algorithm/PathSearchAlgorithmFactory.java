package com.example.simulation.search_algorithm;

public class PathSearchAlgorithmFactory {
    public static PathSearchAlgorithm getDefaultPathSearchAlgorithm() {
        return new BreadthFirstSearch();
    }
}