package main.hackerrank.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

class Checker implements Comparator {
    public int compare(Object o1, Object o2) {
        return 0;
    }
}

public class BfsShortReach2 {
    public void run() {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        int[] distances = graph.shortestReach(0);
    }

    public static class Graph {
        private Node[] nodes;
        private static int EDGE_DISTANCE = 6;

        public Graph(int size) {
            nodes = new Node[size];
            for (int i = 0; i < size; i++) {
                nodes[i] = new Node();
            }
        }

        private class Node {
            public ArrayList<Integer> neighbors = new ArrayList<>();
        }

        public void addEdge(int first, int second) {
            Node firstNode = nodes[first];
            Node secondNode = nodes[second];

            firstNode.neighbors.add(second);
            secondNode.neighbors.add(first);
        }

        public int[] shortestReach(int startId) { // startId is 0 indexed.
            LinkedList<Integer> queue = new LinkedList<Integer>();
            queue.add(startId);

            int[] distances = new int[nodes.length];
            Arrays.fill(distances, -1);
            distances[startId] = 0;

            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int neighbor : nodes[node].neighbors) {
                    if (distances[neighbor] == -1) { // If it hasn't been visited yet...
                        distances[neighbor] = distances[node] + EDGE_DISTANCE;
                        queue.add(neighbor);
                    }
                }
            }

            // Fix return value for solution format.
            int[] returnedDistances = new int[nodes.length - 1]; // Not including start node.
            int returnedDistancesIndex = 0;
            for (int distance : distances) {
                if (distance == startId) // Not including start node.
                    continue;

                returnedDistances[returnedDistancesIndex] = distance;
                returnedDistancesIndex++;
            }

            return returnedDistances;
        }
    }
}