package com.example.simulation.search_algorithm;

import com.example.simulation.search_algorithm.BreadthFirstSearch;
import com.example.simulation.search_algorithm.PathSearchAlgorithm;

public class PathSearchAlgorithmFactory {
    public static PathSearchAlgorithm getDefaultPathSearchAlgorithm() {
        return new BreadthFirstSearch();
    }
}