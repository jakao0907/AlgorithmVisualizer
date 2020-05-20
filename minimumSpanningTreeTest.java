package ntou.cs.java2020.project;

import java.util.*;

public class minimumSpanningTreeTest{
	private static int n=3;
	private static int m=2;
	private static ArrayList<edge> testGraph = new ArrayList<edge>();

	public static void main(String[] args){
		testGraph.add(new edge(1,2,10));
		testGraph.add(new edge(2,3,4));
		minimumSpanningTree testG = new minimumSpanningTree(n,m,testGraph);
		ArrayList<edge> minimumSpanningTreeOrder = testG.solve();
		for(edge x:minimumSpanningTreeOrder){
			System.out.println(x);
		}
	}
}