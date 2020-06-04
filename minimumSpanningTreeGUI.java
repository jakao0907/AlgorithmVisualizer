package ntou.cs.java2020.project;

import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class minimumSpanningTreeGUI extends JFrame implements ActionListener{

	private final int guiWidth=500,guiHeight=500;
	protected JLabel vertexNumberLabel,errLabel,fromPointLabel,toPointLabel,weightPointLabel;
	protected JButton buildButton,startButton,addEdgeButton;
	protected JTextField vertexNumberText,weightPointTest;
	protected JPanel functionPanel,errPanel,addEdgePanel;
	protected JComboBox fromPointTest,toPointTest;
	private ArrayList<edge> edgeArray;
	private minimumSpanningTree myGraph;

	public minimumSpanningTreeGUI(){

		vertexNumberLabel = new JLabel("輸入點的數量");
		vertexNumberText = new JTextField(10);

		buildButton = new JButton("確定");
		startButton = new JButton("開始動畫");
		startButton.setEnabled(false);

		errLabel = new JLabel(" ");
		errLabel.setForeground(Color.red);
		//first line input vertex number and start teacher function
		functionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		functionPanel.add(vertexNumberLabel);
		functionPanel.add(vertexNumberText);
		functionPanel.add(buildButton);
		functionPanel.add(startButton);
		add(functionPanel);

		//secode line addedge function
		fromPointLabel = new JLabel("加邊-> 端點1:");
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

		addEdgePanel = new JPanel(new FlowLayout());

		addEdgePanel.add(fromPointLabel);
		addEdgePanel.add(fromPointTest);
		addEdgePanel.add(toPointLabel);
		addEdgePanel.add(toPointTest);
		addEdgePanel.add(weightPointLabel);
		addEdgePanel.add(weightPointTest);
		addEdgePanel.add(addEdgeButton);
		add(addEdgePanel);

		errPanel = new JPanel();
		errPanel.add(errLabel);
		add(errPanel,BorderLayout.SOUTH);

		fromPointTest.addActionListener(this);
		buildButton.addActionListener(this);
		startButton.addActionListener(this);
		addEdgeButton.addActionListener(this);

		setSize(550,500);
		setTitle("minimum Spanning Tree");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setVisible(true);
	}

	public void paintBasicPoint(){
		ArrayList<pair> pointPosition = new ArrayList<pair>();

	}

	public void actionPerformed(ActionEvent e) {

	}

	public static void main(String[] args) {
		new minimumSpanningTreeGUI();
	}
}