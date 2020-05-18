package ntou.cs.java2020.project;

import java.util.*;

public class graph{
	private int n,m;
	private ArrayList<edge> G;
	private ArrayList<ArrayList<Integer>> AdjacencyList;
	public graph(int _n,int _m,ArrayList<edge> _e){
		G = new ArrayList<edge>(_e);
		AdjacencyList = new ArrayList<ArrayList<Integer>>(n);

	}
}
