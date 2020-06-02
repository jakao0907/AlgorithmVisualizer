package ntou.cs.java2020.project;

import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class minimumSpanningTreeTest extends minimumSpanningTreeGUI{
	private static int n=3;
	private static int m=2;
	protected static ArrayList<edge> testGraph = new ArrayList<edge>();
	private static minimumSpanningTreeGUI gui;
	public static void main(String[] args){
		gui = new minimumSpanningTreeGUI();
		// testGraph.add(new edge(1,2,10));
		// testGraph.add(new edge(2,3,4));
		minimumSpanningTree testG = new minimumSpanningTree(n,m,testGraph);
		ArrayList<edge> minimumSpanningTreeOrder = testG.solve();
		for(edge x:minimumSpanningTreeOrder){
			System.out.println(x);
		}
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==super.startButton){
			System.out.print("success");
		}
	}
}