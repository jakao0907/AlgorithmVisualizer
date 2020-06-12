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
	private static ArrayList<edge> testGraph = new ArrayList<edge>();
	private int[][] adjacencyMartix;
	private int[] X,Y;
	private disjointSet myDS;
	private static int nowHeight=300;

	public static void main(String[] args){
		new minimumSpanningTreeTest();	
	}

	public void paintPoint(){
		update(super.g);
		X = new int[n+1];
		Y = new int[n+1];
		final double PIDouble=Math.PI*2;
		int s=0;
		super.g.setColor(Color.BLACK);
		for(double a=0;a<PIDouble;a+=PIDouble/n){
			X[s] = (int) (Math.round((super.gheight/2-1) * Math.cos(a)*Math.pow(10,0))/Math.pow(10,0)*0.8+(super.gwidth/2));
            Y[s] = (int) (Math.round((super.gheight/2-1) * Math.sin(a)*Math.pow(10,0))/Math.pow(10,0)*0.8+(super.gheight/2));
            super.g.drawOval(X[s]+super.gx,Y[s]+super.gy,30,30);
            super.g.drawString(Integer.toString(s+1),X[s]+super.gx+12,Y[s]+super.gy+19);
            System.out.println((X[s]+super.gx)+ " "+(Y[s]+super.gy ));
            s++;
		}
	}

	public void drawPoint(){
		System.out.println(n);
	}

	public void drawEdge(int a,int b,int c){
		double d = (double)(Y[b-1]-Y[a-1])/(X[b-1]-X[a-1]);
		double angle = -Math.atan(d)/(Math.PI/180.0);
		myDS.union(a,b);
		m++;
		int diffX,diffY;
		// super.g.drawString(a+" - "+b+" length = "+c,870,nowHeight);
		nowHeight+=20;
		diffX = Math.abs((int) Math.round((Math.cos(angle)*15)));
		diffY = Math.abs((int) -Math.round((Math.sin(angle)*15)));
		if(X[a-1]>X[b-1]){
			if(Y[a-1]>Y[b-1]){
				super.g.drawLine(X[a-1]+super.gx+15-diffX,Y[a-1]+super.gy+15-diffY,X[b-1]+super.gx+15+diffX,Y[b-1]+super.gy+15+diffY);
			}
			else{
				super.g.drawLine(X[a-1]+super.gx+15-diffX,Y[a-1]+super.gy+15+diffY,X[b-1]+super.gx+15+diffX,Y[b-1]+super.gy+15-diffY);
			}
		}
		else{
			if(Y[a-1]>Y[b-1]){
				super.g.drawLine(X[a-1]+super.gx+15+diffX,Y[a-1]+super.gy+15-diffY,X[b-1]+super.gx+15-diffX,Y[b-1]+super.gy+15+diffY);
			}
			else{
				super.g.drawLine(X[a-1]+super.gx+15+diffX,Y[a-1]+super.gy+15+diffY,X[b-1]+super.gx+15-diffX,Y[b-1]+super.gy+15-diffY);
			}
		}
		super.g.setColor(Color.BLACK);
		
	}
	
	public void play(){
		minimumSpanningTree game = new minimumSpanningTree(n,m,testGraph);
		// super.g.drawString("1 - 2 length = 3",870,340);
		// super.g.drawString("1 - 2 length = 3",870,300);
		// super.g.drawString("1 - 2 length = 3",870,320);
		ArrayList<edge> getGraph = game.solve();
		int edgeID = 0;
		for(edge i:testGraph){
			if(edgeID > 0){
				super.g.setColor(Color.GREEN);
				edge front = getGraph.get(edgeID-1);
				drawEdge(front.u,front.v,front.len);
			}
			drawEdge(i.u,i.v,i.len);
			System.out.println(i.u+" "+i.v+" "+i.len);
			for(int j=0;j<n;j++){
				if(testGraph.get(j)==i){
					super.g.setColor(Color.RED);
					super.g.drawString(i.u+" - "+i.v+" length = "+i.len,870,300+20*j);
					System.out.println("success at "+j);
					System.out.printf("%d %d %d - %d %d %d",i.u,i.v,i.len,testGraph.get(j).u,testGraph.get(j).v,testGraph.get(j).len);
					break;
				}
			}
			edgeID++;
			try{
				Thread.sleep(2000);
			}
			catch(InterruptedException ie){
				System.err.println("sleep err");
			}
		}
		super.g.setColor(Color.GREEN);
		edge front = getGraph.get(edgeID-1);
		drawEdge(front.u,front.v,front.len);
		super.g.setColor(Color.BLACK);
		errLabel.setForeground(Color.green);
		errLabel.setText("finish!");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==buildButton){
			if(vertexNumberText.getText().equals("")){
				errLabel.setForeground(Color.red);
				errLabel.setText("無輸入!!!");
			}
			else{
				errLabel.setText("");
				n = Integer.parseInt(vertexNumberText.getText());
				nowHeight = 300;
				myDS = new disjointSet(n);
				adjacencyMartix = new int[n+1][n+1];
				for(int i=0;i<=n;i++){
					for(int j=0;j<=n;j++){
						adjacencyMartix[i][j]=0;
					}
				}
				paintPoint();
				fromPointTest.removeAllItems();
				fromPointTest.addItem("請選擇");
				for(int i=1;i<=n;i++){
					fromPointTest.addItem(i);
				}
				fromPointTest.setEnabled(true);
				toPointTest.setEnabled(false);
				weightPointTest.setEnabled(true);
				addEdgeButton.setEnabled(true);
				startButton.setEnabled(true);
			}
		}
		else if(e.getSource()==startButton){
			boolean flag=true;
			for(int i=2;i<=n;i++){
				if(myDS.find(i-1)!=myDS.find(i)){
					flag=false;
				}
			}
			if(flag){
				play();
			}
			else{
				errLabel.setForeground(Color.red);
				errLabel.setText("需先將整張圖連通!");
			}
		}
		else if(e.getSource()==addEdgeButton){
			if(weightPointTest.getText().equals("")){
				errLabel.setForeground(Color.red);
				errLabel.setText("請輸入權重!");
			}
			else if(fromPointTest.getSelectedItem().equals("請選擇")){
				errLabel.setForeground(Color.red);
				errLabel.setText("請選擇端點1");
			}
			else if(toPointTest.getSelectedItem().equals("請選擇")){
				errLabel.setForeground(Color.red);
				errLabel.setText("請選擇端點2");
			}
			else if(Integer.parseInt(weightPointTest.getText())<=0){
				errLabel.setForeground(Color.red);
				errLabel.setText("邊權重需為正整數!");
			}
			else{
				errLabel.setText("");
				int a = Integer.parseInt(fromPointTest.getSelectedItem().toString());
				int b = Integer.parseInt(toPointTest.getSelectedItem().toString());
				int c = Integer.parseInt(weightPointTest.getText());
				if(adjacencyMartix[a][b]>0){
					errLabel.setForeground(Color.red);
					errLabel.setText("此邊已設值");
				}
				else{
					adjacencyMartix[a][b]=adjacencyMartix[b][a]=c;
					System.out.printf("%d %d %d\n",a,b,c);
					super.g.setColor(Color.BLACK);
					super.g.drawString(a+" - "+b+" length = "+c,870,300+20*testGraph.size());
					testGraph.add(new edge(a,b,c));
					drawEdge(a,b,c);
					fromPointTest.setSelectedIndex(0);
					toPointTest.setSelectedIndex(0);
					weightPointTest.setText("");
					toPointTest.setEnabled(false);
				}
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