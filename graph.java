package ntou.cs.java2020.project;

import java.util.*;

public class graph{

	protected int n,m;
	protected ArrayList<edge> G;
	protected int[][] AdjacencyMartix;
	protected ArrayList<pair>[] AdjacencyList;

	public graph(int _n,int _m,ArrayList<edge> _e){
		n = _n;
		m = _m;
		G = new ArrayList<edge>(_e);
		AdjacencyMartix = new int[n+1][n+1];
		AdjacencyList = new ArrayList[n+1];
		for(int i=1;i<=n;i++){
			AdjacencyList[i] = new ArrayList<pair>();
		}
		for(edge x:G){
			int a=x.u,b=x.v,c=x.len;
			AdjacencyList[a].add(new pair(b,c));
			AdjacencyList[b].add(new pair(a,c));
			AdjacencyMartix[a][b]=AdjacencyMartix[b][a]=c;
		}
	}
}
