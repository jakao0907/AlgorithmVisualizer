import javax.swing.*;
import java.awt.*;


class MyPanel extends JPanel{
public void paint(Graphics g){
super.paint(g);
// System.out.println("hi");
g.drawOval(10, 10, 30, 30);
// g.drawLine(10, 20, 100, 20);
// g.drawRect(0, 0, 50, 60);
// g.setColor(Color.GREEN);
// g.fillRect(0, 0, 50, 60);
}
}