package ntou.cs.java2020.project;

import java.util.*;

public class shortestPath extends graph{

	public shortestPath(int _n,int _m,ArrayList<edge> _G){
		super(_n,_m,_G);
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				System.out.print(super.AdjacencyMartix[i][j]);
				System.out.print(' ');
			}
			System.out.println();
		}
		for(int i=1;i<=n;i++){
			System.out.print(i+" : ");
			for(pair x:super.AdjacencyList[i]){
				System.out.print(x.first+","+x.second+" ");
			}
			System.out.println();
		}
	}
}