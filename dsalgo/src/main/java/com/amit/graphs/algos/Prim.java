package com.amit.graphs.algos;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.amit.datastructure.MinimumPriorityQueue;
import com.amit.graphs.Graph;
import com.amit.graphs.Graph.Edge;

public class Prim {
	private static int cost = 0;
	private static Set<Graph.Edge<Integer>> path = null;
	private static List<Graph.Vertex<Integer>> unvisited = null;
	private static com.amit.datastructure.PriorityQueue<Edge<Integer>> edgesAvailable = null;
	private Prim() { }
	public static Graph.CostPathPair<Integer> getMinimumSpanningTree(Graph<Integer> graph, Graph.Vertex<Integer> start) {
		if (graph == null)
			throw (new NullPointerException("Graph must be non-NULL."));
		// Reset variables
		cost = 0;
		path = null;
		unvisited = null;
		edgesAvailable = null;
		// Prim's algorithm only works on undirected graphs
		if (graph.getType() == Graph.TYPE.DIRECTED)
			throw (new IllegalArgumentException("Undirected graphs only."));
		path = new LinkedHashSet<Graph.Edge<Integer>>();
		unvisited = new ArrayList<Graph.Vertex<Integer>>();
		unvisited.addAll(graph.getVerticies());
		unvisited.remove(start);
		edgesAvailable = new MinimumPriorityQueue<Graph.Edge<Integer>>();
		Graph.Vertex<Integer> vertex = start;
		while (!unvisited.isEmpty()) {
			for (Graph.Edge<Integer> e : vertex.getEdges()) {
				if (unvisited.contains(e.getToVertex()))
					edgesAvailable.insert(e);
			}
			Graph.Edge<Integer> e = edgesAvailable.remove();
			cost += e.getCost();
			path.add(e);
			vertex = e.getToVertex();
			unvisited.remove(vertex);
		}
		return (new Graph.CostPathPair<Integer>(cost, path));
	}
}