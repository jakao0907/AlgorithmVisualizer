package ntou.cs.java2020.project;

import java.util.*;

public class ShortestPathTest{
	private static int n=3;
	private static int m=2;
	private static ArrayList<edge> testGraph = new ArrayList<edge>();

	public static void main(String[] args) {
		testGraph.add(new edge(1,2,3));
		testGraph.add(new edge(2,3,4));
		ShortestPath testG = new ShortestPath(n,m,testGraph);
	}
}