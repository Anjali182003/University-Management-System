package university.management.system;

import java.awt.*;
import javax.swing.*;

public class About extends JFrame {
    
    About() {
        setSize(700,500);
        setLocation(400,150);
        getContentPane().setBackground(Color.WHITE);
        
               
        JLabel heading = new JLabel("<html>University Management System</html>");
        heading.setBounds(120,20,500,40);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/info.png"));
        Image i2 = i1.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(300,80,40,40);
        add(image);
        
        ImageIcon imgicon = new ImageIcon(ClassLoader.getSystemResource("icons/group.png"));
        Image img = imgicon.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon ic=new ImageIcon(img);
        JLabel i= new JLabel(ic);
        i.setBounds(280,140,80,80);
        add(i);
        
        JLabel label = new JLabel("<html>Developed By:</hmtl>");
        label.setBounds(250,240,250,40);
        label.setFont(new Font("serif",Font.BOLD,25));
        add(label);
        
        JLabel name = new JLabel("<html>~ Anjali Jain (2010DMTCSE07746)<br> ~ Pallavi Patel (2010DMTCSE07765)<br> ~ Devansh Rambadia (2010DMTCSE07753)</hmtl>");
        name.setBounds(200,200,500,250);
        name.setFont(new Font("serif",Font.PLAIN,20));
        add(name);
        
          
        setLayout(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new About();
    }
}
