package university.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Marks extends JFrame implements ActionListener{
    
    String rollno;
    JButton cancel;
    
    Marks(String rollno) {
        
        this.rollno = rollno;
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Shri Vaishnav Vidyapeeth Vishwavidyalaya (SVVV)");
        heading.setBounds(100,10,500,25);
        heading.setFont(new Font("serif",Font.BOLD,20));
        add(heading);
        
        JLabel subheading = new JLabel("Result of Examination 2022");
        subheading.setBounds(100,50,500,25);
        subheading.setFont(new Font("serif",Font.BOLD,18));
        add(subheading);
        
        JLabel lbrollno = new JLabel("Roll Number " + rollno);
        lbrollno.setBounds(60,100,500,20);
        lbrollno.setFont(new Font("serif",Font.PLAIN,18));
        add(lbrollno);
        
        JLabel lbsemester = new JLabel();
        lbsemester.setBounds(60,130,500,20);
        lbsemester.setFont(new Font("serif",Font.PLAIN,18));
        add(lbsemester);
        
        JLabel sub1 = new JLabel();
        sub1.setBounds(100,200,500,20);
        sub1.setFont(new Font("serif",Font.PLAIN,18));
        add(sub1);
        
        JLabel sub2 = new JLabel();
        sub2.setBounds(100,230,500,20);
        sub2.setFont(new Font("serif",Font.PLAIN,18));
        add(sub2);
        
        JLabel sub3 = new JLabel();
        sub3.setBounds(100,260,500,20);
        sub3.setFont(new Font("serif",Font.PLAIN,18));
        add(sub3);
        
        JLabel sub4 = new JLabel();
        sub4.setBounds(100,290,500,20);
        sub4.setFont(new Font("serif",Font.PLAIN,18));
        add(sub4);
        
        JLabel sub5 = new JLabel();
        sub5.setBounds(100,320,500,20);
        sub5.setFont(new Font("serif",Font.PLAIN,18));
        add(sub5);
        
        try{
            Conn c=new Conn();
            
            ResultSet rs1= c.s.executeQuery("select * from subject where rollno='"+rollno+"'");
            while(rs1.next()){
                sub1.setText(rs1.getString("subject1"));
                sub2.setText(rs1.getString("subject2"));
                sub3.setText(rs1.getString("subject3"));
                sub4.setText(rs1.getString("subject4"));
                sub5.setText(rs1.getString("subject5"));
            }
            
            ResultSet rs2= c.s.executeQuery("select * from marks where rollno='"+rollno+"'");
            while(rs2.next()){
                sub1.setText(sub1.getText() +"--------------"+ rs2.getString("marks1"));
                sub2.setText(sub2.getText() +"--------------"+ rs2.getString("marks2"));
                sub3.setText(sub3.getText() +"--------------"+ rs2.getString("marks3"));
                sub4.setText(sub4.getText() +"--------------"+ rs2.getString("marks4"));
                sub5.setText(sub5.getText() +"--------------"+ rs2.getString("marks5"));
                lbsemester.setText("Semester "+ rs2.getString("semester"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
       
 
        setSize(660,550);
        setLocation(500,100);
        setLayout(null);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(420,450,120,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("serif",Font.BOLD,16));
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e){
        setVisible(false);
    }
    
    public static void main(String[] args) {
        new Marks("");
    }
    
}
