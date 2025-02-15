package com.example.simulation;

import com.example.simulation.search_algorithm.BreadthFirstSearch;
import com.example.simulation.search_algorithm.PathSearchAlgorithm;

public class Manager {
    public static PathSearchAlgorithm getDefaultPathSearchAlgorithm() {
        return new BreadthFirstSearch();
    }
}