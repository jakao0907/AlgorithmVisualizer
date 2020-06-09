import javax.swing.*;
import java.awt.*;

public class DrawCicle extends JFrame{
	MyPanel mp=null;
	public static void main(String[] args) {
		new DrawCicle();
	}

	public DrawCicle(){
		mp=new MyPanel();
		this.add(mp);
		this.setSize(300, 250);
		this.setLocation(600, 300);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}