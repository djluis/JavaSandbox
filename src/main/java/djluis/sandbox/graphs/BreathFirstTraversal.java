package djluis.sandbox.graphs;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreathFirstTraversal<K> {
    Set<K> find(Graph<K, DefaultEdge> graph, K root) {
        Set<K> visited = new LinkedHashSet<>(); // To keep the order
        Queue<K> queue = new LinkedList<>(); //FIFO

        queue.add(root); // Queue to avoid recursion
        visited.add(root); // Marked visited to avoid infinite cycles

        while (!queue.isEmpty()) {
            K vertex = queue.poll();
            for (DefaultEdge v : graph.edgesOf(vertex)) {
                K edgeTargetVertex = graph.getEdgeTarget(v);
                if (!visited.contains(edgeTargetVertex)) {
                    visited.add(edgeTargetVertex);
                    queue.add(edgeTargetVertex);
                }
            }
        }

        return visited; // return an ordered set with all the connections to the K root
    }
}
