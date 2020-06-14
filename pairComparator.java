package ntou.cs.java2020.project;

import java.util.*;

public class pairComparator implements Comparator<pair>{
	@Override
	public int compare(pair a,pair b){
		if(a.first!=b.first)
			return a.first-b.first;
		return a.second-b.second;
	}
}