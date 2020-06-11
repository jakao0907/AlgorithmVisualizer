package ntou.cs.java2020.project;

import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class minimumSpanningTreeGUI extends JFrame implements ActionListener{

	protected final static int gwidth = 450;
	protected final static int gheight = 450;
	private final int guiWidth=600,guiHeight=600;
	protected JLabel vertexNumberLabel,errLabel,fromPointLabel,toPointLabel,weightPointLabel;
	protected JButton buildButton,startButton,addEdgeButton;
	protected JTextField vertexNumberText,weightPointTest;
	protected JPanel functionPanel,errPanel,addEdgePanel;
	protected JComboBox fromPointTest,toPointTest;
	private ArrayList<edge> edgeArray;
	protected static Graphics g;
	private minimumSpanningTree myGraph;
	protected static int gx,gy;
	Dimension ScreenSize,FrameSize;

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

		setSize(guiWidth,guiHeight);	//寬-長
		setTitle("minimum Spanning Tree");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setVisible(true);

		ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
		FrameSize = getSize();
		setLocation((ScreenSize.width-FrameSize.width)/2,(ScreenSize.height-FrameSize.height)/2);

		gx=(FrameSize.width-gwidth)/2;
		gy=(FrameSize.height-gheight)/2+25;
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