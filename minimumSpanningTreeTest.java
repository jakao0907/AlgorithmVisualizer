package ntou.cs.java2020.project;

import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class minimumSpanningTreeTest extends minimumSpanningTreeGUI{
	private targetX;
	private targetY;
	private targetWidth;
	private targetHeight;
	private static int n;
	private static int m=0;
	protected static ArrayList<edge> testGraph = new ArrayList<edge>();
	// private static minimumSpanningTreeGUI gui;
	public static void main(String[] args){
		// testGraph.add(new edge(1,2,10));
		// testGraph.add(new edge(2,3,4));
		new minimumSpanningTreeTest();
		minimumSpanningTree testG = new minimumSpanningTree(n,m,testGraph);
		ArrayList<edge> minimumSpanningTreeOrder = testG.solve();
		for(edge x:minimumSpanningTreeOrder){
			System.out.println(x);
		}

		
	}

	public void paint(Graphics g){
		g.drawOval(targetX,targetY,targetWidth,targetHeight);
	}

	public void drawPoint(){
		System.out.println(n);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==fromPointTest){
			int n=Integer.parseInt(vertexNumberText.getText());
			if(fromPointTest.getSelectedItem()!="請選擇"){
				toPointTest.removeAllItems();
				toPointTest.addItem("請選擇");
				for(int i=1;i<=n;i++){
					if(i!=Integer.parseInt(fromPointTest.getSelectedItem().toString()))
					toPointTest.addItem(i);
				}
				toPointTest.setEnabled(true);
			}
		}
		else if(e.getSource()==buildButton){
			if(vertexNumberText.getText().equals("")){
				errLabel.setText("無輸入!!!");
			}
			else{
				paintBasicPoint();
				errLabel.setText("");
				n = Integer.parseInt(vertexNumberText.getText());
				fromPointTest.removeAllItems();
				fromPointTest.addItem("請選擇");
				for(int i=1;i<=n;i++){
					fromPointTest.addItem(i);
				}
				fromPointTest.setEnabled(true);
				weightPointTest.setEnabled(true);
				addEdgeButton.setEnabled(true);
				startButton.setEnabled(true);
			}
		}
		else if(e.getSource()==startButton){
		}
		else if(e.getSource()==addEdgeButton){
			if(weightPointTest.getText().equals("")){
				errLabel.setText("請輸入權重!");
			}
			else if(fromPointTest.getSelectedItem().equals("請選擇")){
				errLabel.setText("請選擇端點1");
			}
			else if(toPointTest.getSelectedItem().equals("請選擇")){
				errLabel.setText("請選擇端點2");
			}
			else if(Integer.parseInt(weightPointTest.getText())<=0){
				errLabel.setText("邊權重需為正整數!");
			}
			else{
				errLabel.setText("");
				int a = Integer.parseInt(fromPointTest.getSelectedItem().toString());
				int b = Integer.parseInt(toPointTest.getSelectedItem().toString());
				int c = Integer.parseInt(weightPointTest.getText());
				// G.add(edge(a,b,c));
				System.out.printf("%d %d %d\n",a,b,c);
				func();
			}
		}
		else{
			System.out.println("?");
		}
	}
}