package ntou.cs.java2020.project;

import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class minimumSpanningTreeGUI extends JFrame implements ActionListener{

	protected final static int gwidth = 450;
	protected final static int gheight = 600;
	private final int guiWidth=1000,guiHeight=800;
	protected JLabel vertexNumberLabel,errLabel,fromPointLabel,toPointLabel,weightPointLabel,testLabel1,testLabel2;
	protected JButton buildButton,startButton,addEdgeButton;
	protected JTextField vertexNumberText,weightPointTest;
	protected JPanel functionPanel,errPanel,addEdgePanel,edgeDisplayPanel;
	protected JComboBox fromPointTest,toPointTest;
	private ArrayList<edge> edgeArray;
	protected static Graphics g;
	private minimumSpanningTree myGraph;
	protected static int gx,gy;
	Dimension ScreenSize,FrameSize;
	
	public minimumSpanningTreeGUI(){

		edgeDisplayPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		// testLabel1 = new JLabel("10 - 20  length = 34445");
		// testLabel2 = new JLabel("4 - 5  length = 6");
		// edgeDisplayPanel.add(testLabel1);
		// edgeDisplayPanel.add(testLabel2);
		// edgeDisplayPanel.setSize(180,400);
		// edgeDisplayPanel.setLocation(750,10);
		// add(edgeDisplayPanel);

		vertexNumberLabel = new JLabel("輸入點的數量");
		vertexNumberText = new JTextField(10);

		buildButton = new JButton("確定");
		startButton = new JButton("開始動畫");
		startButton.setEnabled(false);

		errLabel = new JLabel("");
		errLabel.setForeground(Color.red);
		//first line input vertex number and start teacher function
		functionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		functionPanel.add(vertexNumberLabel);
		functionPanel.add(vertexNumberText);
		functionPanel.add(buildButton);
		functionPanel.add(startButton);
		functionPanel.add(errLabel);
		functionPanel.setSize(600,50);
		functionPanel.setLocation(10,10);
		add(functionPanel);

		//secode line addedge function
		fromPointLabel = new JLabel("加邊： 端點1:");
		fromPointTest = new JComboBox();
		fromPointTest.setEnabled(false);

		toPointLabel = new JLabel("端點2:");
		toPointTest = new JComboBox();
		toPointTest.setEnabled(false);

		weightPointLabel = new JLabel("權重為:");
		weightPointTest = new JTextField(10);
		weightPointTest.setEnabled(false);

		addEdgeButton = new JButton("新增");
		addEdgeButton.setEnabled(false);

		addEdgePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		addEdgePanel.add(fromPointLabel);
		addEdgePanel.add(fromPointTest);
		addEdgePanel.add(toPointLabel);
		addEdgePanel.add(toPointTest);
		addEdgePanel.add(weightPointLabel);
		addEdgePanel.add(weightPointTest);
		addEdgePanel.add(addEdgeButton);
		addEdgePanel.setSize(500,50);
		addEdgePanel.setLocation(10,60);
		add(addEdgePanel);

		fromPointTest.addActionListener(this);
		buildButton.addActionListener(this);
		startButton.addActionListener(this);
		addEdgeButton.addActionListener(this);

		setSize(guiWidth,guiHeight);	//寬-長
		setTitle("minimum Spanning Tree");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setLayout(new FlowLayout());
		setLayout(null);
		setVisible(true);

		ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
		FrameSize = getSize();
		setLocation((ScreenSize.width-FrameSize.width)/2,(ScreenSize.height-FrameSize.height)/2);

		gx=(FrameSize.width-gwidth)/2;
		gy=(FrameSize.height-gheight)/2+100;
		g = getGraphics();
		g.setClip(gx,gy, gwidth, gheight);
		g.setColor(Color.BLACK);
	}
	
	public void actionPerformed(ActionEvent e) {

	}

	public static void main(String[] args) {
		new minimumSpanningTreeGUI();
	}
}