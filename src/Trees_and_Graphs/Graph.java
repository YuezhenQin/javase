package Trees_and_Graphs;

import java.util.*;

public class Graph {

    //first input format: arrays of edges
    public Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge: edges) {
            int x = edge[0], y = edge[1];
            if (!graph.containsKey(x)) graph.put(x, new ArrayList<>());
            graph.get(x).add(y);
        }

        return graph;
    }
    //second input format: adjacency list
    //third input format: adjacency matrix

    //Solution547. Number of Groups (Connected Components)
    public static int findGroupNum(int[][] isConnected) {
        // build the graph
        return -1;
    }


}
