package ntou.cs.java2020.project;

import java.util.*;

public class disjointSet{
	private int n;
	private int[] root;
	public disjointSet(int n){
		root = new int[n+1];
		for(int i=0;i<=n;i++)	root[i]=i;
	}
	public int find(int x){
		return root[x]==x?x:find(root[x]);
	}
	public void union(int x,int y){
		if(find(x)!=find(y))
			root[find(y)]=root[find(x)];
	}
}