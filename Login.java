package ntou.cs.java2020.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Login extends JFrame
{
    JButton button1,button2,button3,button4;
    public static void main(String[] args)
    { 
      Login login = new Login(); 
      login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      login.setSize(1000,800); 
      login.setVisible(true);
      login.setLocationRelativeTo(null);
    }
    public Login()
    {
        super("演算法視覺化");
        this.setLayout(null);

        Container ct;
        BackgroundPanel bgp;
      
        bgp=new BackgroundPanel((new ImageIcon("1.jpg")).getImage());
        bgp.setLayout(null);
        bgp.setBounds(0,0,1000,800);
        this.add(bgp);
        JLabel label = new JLabel("Algorithm visualization",JLabel.CENTER);
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN,60);
        label.setFont(font);
        label.setSize(640,65);
        label.setLocation(180,100);
        bgp.add(label); 

        Icon image1 = new ImageIcon(getClass().getResource("2_1.png"));
        Icon image2 = new ImageIcon(getClass().getResource("2_2.png"));
        Icon image4 = new ImageIcon(getClass().getResource("2_4.png"));

        button1=new JButton(image1);
        button1.setBounds(360,260,280,100);
        button2=new JButton(image2);
        button2.setBounds(360,430,280,100);
        button4=new JButton(image4);
        button4.setBounds(400,600,200,100);
        bgp.add(button1);
        bgp.add(button2);
        bgp.add(button4);
        button1.setVisible(true);
        button2.setVisible(true);
        button4.setVisible(true);

        ButtonHandler handler = new ButtonHandler();
        button1.addActionListener(handler);
        button2.addActionListener(handler);
        button4.addActionListener(handler);
    }
    class BackgroundPanel extends JPanel
    {
        Image im;
        public BackgroundPanel(Image im)
        {
            this.im=im;
            this.setOpaque(true);
        }
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponents(g);
            g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
        }
    }
    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if(event.getSource()==button4)
                System.exit(0);
            else if(event.getSource()==button1){
                minimumSpanningTreeTest nowWindows = new minimumSpanningTreeTest();
                System.out.println("MST");
            }
            else if(event.getSource()==button2){
                shortestPathTest nowWindows = new shortestPathTest();
                System.out.println("SP");
            }
        }
    }
}