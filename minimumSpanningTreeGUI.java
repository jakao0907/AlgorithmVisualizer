package ntou.cs.java2020.project;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class minimumSpanningTreeGUI extends JFrame implements ActionListener{

	private final int guiWidth=500,guiHeight=500;
	JLabel vertexNumberLabel,edgeNumberLabel,errLabel;
	JButton buildButton,startButton;
	JTextField vertexNumberText,edgeNumberTest;
	JPanel functionPanel,errPanel;

	public minimumSpanningTreeGUI(){

		vertexNumberLabel = new JLabel("輸入點的數量");
		vertexNumberText = new JTextField(10);

		edgeNumberLabel	= new JLabel("輸入邊的數量(需連通所有點)");
		edgeNumberTest = new JTextField(10);

		buildButton = new JButton("建圖");
		startButton = new JButton("開始動畫");
		startButton.setEnabled(false);

		errLabel = new JLabel(" ");
		errLabel.setForeground(Color.red);

		functionPanel = new JPanel(new FlowLayout());

		functionPanel.add(vertexNumberLabel);
		functionPanel.add(vertexNumberText);
		functionPanel.add(edgeNumberLabel);
		functionPanel.add(edgeNumberTest);
		functionPanel.add(buildButton);
		functionPanel.add(startButton);
		add(functionPanel,BorderLayout.NORTH);

		errPanel = new JPanel();
		errPanel.add(errLabel);
		add(errPanel,BorderLayout.SOUTH);

		buildButton.addActionListener(this);
		startButton.addActionListener(this);

		setSize(800,500);
		setTitle("minimum Spanning Tree");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new minimumSpanningTreeGUI();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==buildButton){
			int n=Integer.parseInt(vertexNumberText.getText());
			int m=Integer.parseInt(edgeNumberTest.getText());
			if(n-m>1){
				errLabel.setText("邊的數量過少!");
			}
			else{
				errLabel.setText("");
				startButton.setEnabled(true);
			}
		}
		else if(e.getSource()==startButton){
			System.out.println("!!");
		}
	}
}