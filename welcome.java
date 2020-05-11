package ntou.cs.java2020.project;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class welcome{
    public static void main(String args[]){
    	String[] algorithm = {"Minimum Spanning Tree","Shortest Path","Convex Hull"};
        JFrame mainWindow = new JFrame("演算法視覺化");
        mainWindow.setSize(1000,750);
        mainWindow.getContentPane().setLayout(new FlowLayout());

        for(int i=0;i<algorithm.length;i++){
        	JButton btn = new JButton(algorithm[i]);
        	mainWindow.add(btn);
        }

        mainWindow.setVisible(true);
    }
}