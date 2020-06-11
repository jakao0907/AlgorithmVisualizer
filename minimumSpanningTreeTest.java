package ntou.cs.java2020.project;

import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class minimumSpanningTreeTest extends minimumSpanningTreeGUI{
	private static int n;
	private static int m=0;
	private static JLabel testNumLabel;
	private static JPanel vertexNumberPanel;
	private static boolean flag=false;
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

	public void paintPoint(){
		update(super.g);
		int[] X=new int[n+1],Y=new int[n+1];
		final double PIDouble=Math.PI*2;
		int s=0;
		for(double a=0;a<PIDouble;a+=PIDouble/n){
			X[s] = (int) (Math.round((super.gwidth/2-1) * Math.cos(a)*Math.pow(10,0))/Math.pow(10,0)*0.8+(super.gwidth/2));
            Y[s] = (int) (Math.round((super.gwidth/2-1) * Math.sin(a)*Math.pow(10,0))/Math.pow(10,0)*0.8+(super.gheight/2));
            super.g.drawOval(X[s]+super.gx,Y[s]+super.gy,30,30);
            super.g.drawString(Integer.toString(s+1),X[s]+super.gx+12,Y[s]+super.gy+19);
           	System.out.println((X[s]+super.gx)+" "+(Y[s]+super.gy));
            s++;
		}
	}

	public void drawPoint(){
		System.out.println(n);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==buildButton){
			if(vertexNumberText.getText().equals("")){
				errLabel.setText("無輸入!!!");
			}
			else{
				errLabel.setText("");
				n = Integer.parseInt(vertexNumberText.getText());
				paintPoint();
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
			}
		}
		else if(fromPointTest!=null&&e.getSource()==fromPointTest){
			int n=Integer.parseInt(vertexNumberText.getText());
			if(fromPointTest.getSelectedItem()!=null&&!fromPointTest.getSelectedItem().toString().equals("請選擇")){
				toPointTest.removeAllItems();
				toPointTest.addItem("請選擇");
				for(int i=1;i<=n;i++){
					if(i!=Integer.parseInt(fromPointTest.getSelectedItem().toString()))
					toPointTest.addItem(i);
				}
				toPointTest.setEnabled(true);
			}
		}
		else{
			System.out.println("?");
		}
	}
}