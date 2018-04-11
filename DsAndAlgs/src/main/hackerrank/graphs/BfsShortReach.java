package main.hackerrank.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BfsShortReach {
    class Graph {
        private Set<Node> nodes = new LinkedHashSet<Node>();

        public void addNode(Node nodeA) {
            nodes.add(nodeA);
        }

        public Node findNode(String name) {
            for (Node node : nodes) {
                if (node.getName().equals(name))
                    return node;
            }

            return null;
        }

        public Node findNode(int startNode) {
            return findNode(String.valueOf(startNode));
        }

        public boolean removeNode(int name) {
            return removeNode(String.valueOf(name));
        }

        public boolean removeNode(String name) {
            return removeNode(findNode(name));
        }

        public boolean removeNode(Node node) {
            return nodes.remove(node);
        }
    }

    class Node {

        private String name;

        private List<Node> shortestPath = new LinkedList<Node>();

        private Integer distance = Integer.MAX_VALUE; // Set distance to an infinite value.

        Map<Node, Integer> adjacentNodes = new HashMap<>();

        public void addDestination(Node destination, int distance) {
            adjacentNodes.put(destination, distance);
        }

        public Node(String name) {
            this.name = name;
        }

        public Node(int name) {
            this.name = String.valueOf(name);
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public Map<Node, Integer> getAdjacentNodes() {
            return adjacentNodes;
        }

        public Integer getDistance() {
            return distance;
        }

        public void setShortestPath(LinkedList<Node> shortestPath) {
            this.shortestPath = shortestPath;
        }

        public List<Node> getShortestPath() {
            return shortestPath;
        }

        public String getName() {
            return name;
        }
    }

    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.setDistance(0); // Set distance of startNode to zero.

        Set<Node> settledNodes = new HashSet<Node>();
        Set<Node> unsettledNodes = new HashSet<Node>();

        unsettledNodes.add(source); // Add the startNode to the unsettled nodes set.

        while (unsettledNodes.size() != 0) { // While the unsettledNodes set is not empty...
            // Choose an evaluation node from the unsettled nodes set,
            // the evaluation node should be the one with the lowest distance from the source.
            // First iteration the source node is zero, and therefore not only the lowest distance,
            // but the only choice...
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);

            // Calculate new distances to direct neighbors
            // by keeping the lowest distance at each evaluation.
            for (Map.Entry<Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();

                // Add neighbors that are not yet settled to the unsettled nodes set.
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }

            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node : unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateMinimumDistance(Node evaluationNode, Integer edgeWeight, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeight < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeight);
            LinkedList<Node> shortestPath = new LinkedList<Node>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    public int[] bfs(int numNodes, int numEdges, int[][] edges, int startNode) {
        Graph graph = new Graph();
        for (int i = 1; i <= numNodes; i++) {
            Node newNode = new Node(i);
            graph.addNode(newNode);
        }

        for (int i = 0; i < numEdges; i++) {
            int firstValue = edges[i][0];
            Node firstFoundNode = graph.findNode(firstValue);

            int secondValue = edges[i][1];
            Node secondFoundNode = graph.findNode(secondValue);

            firstFoundNode.addDestination(secondFoundNode, 6);
        }

        Node nodeA = graph.findNode(startNode);
        graph = calculateShortestPathFromSource(graph, nodeA);

        int[] returnedDistances = new int[numNodes - 1];
        int returnedDistancesIndex = 0;
        for (Node node : graph.nodes) {
            if (node.name.equals(String.valueOf(startNode)))
                continue;

            int distance = node.getDistance();
            if (distance == Integer.MAX_VALUE)
                distance = -1;

            returnedDistances[returnedDistancesIndex] = distance;
            returnedDistancesIndex++;
        }

        return returnedDistances;
    }
}