package djluis.sandbox.graphs;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class DepthFirstTraversal<K> {
    public Set<K> find(Graph<K, DefaultEdge> graph, K root) {
        Set<K> visited = new LinkedHashSet<>(); // To keep the order
        Stack<K> stack = new Stack<>(); //LIFO

        stack.push(root);  // Stack to avoid recursion
        visited.add(root); // Marked visited to avoid infinite cycles

        while (!stack.isEmpty()) {
            K vertex = stack.pop();

            for (DefaultEdge v : graph.edgesOf(vertex)) {
                K edgeTargetVertex = graph.getEdgeTarget(v);
                if (!visited.contains(edgeTargetVertex)) {
                    visited.add(edgeTargetVertex);
                    stack.push(edgeTargetVertex);
                }
            }
        }

        return visited;  // return an ordered set with all the connections to the K root
    }
}
