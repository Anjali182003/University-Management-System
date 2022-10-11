package university.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class StudentLeave extends JFrame implements ActionListener{
    Choice crollno,ctime;
    JDateChooser dcdate;
    JButton submit,cancel;
    
    StudentLeave() {
        
        setSize(500,550);
        setLocation(550,100);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading= new JLabel("Apply Leave (Student)");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("serif", Font.BOLD,18));
        add(heading);
        
        JLabel lbroll= new JLabel("Search By Roll Number");
        lbroll.setBounds(60,100,200,20);
        lbroll.setFont(new Font("serif", Font.PLAIN,16));
        add(lbroll);
        
        crollno=new Choice();
        crollno.setBounds(60,130,200,20);
        add(crollno);
        
        try {
            Conn c= new Conn();
            ResultSet rs=c.s.executeQuery("select * from student");
            while(rs.next()){
                crollno.add(rs.getString("roll"));
            }
        }
            catch(Exception e){
                    e.printStackTrace();
                    }
        
        JLabel lbdate= new JLabel("Date");
        lbdate.setBounds(60,180,200,20);
        lbdate.setFont(new Font("serif", Font.PLAIN,16));
        add(lbdate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(60,210,200,25);
        add(dcdate);
        
        JLabel lbtime= new JLabel("Time Duration");
        lbtime.setBounds(60,260,200,20);
        lbtime.setFont(new Font("serif", Font.PLAIN,16));
        add(lbtime);
        
        ctime=new Choice();
        ctime.setBounds(60,290,200,20);
        ctime.add("Full Day");
        ctime.add("Half day");
        add(ctime);
        
        submit = new JButton("Submit");
        submit.setBounds(60,350,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("serif",Font.BOLD,16));
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(200,350,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("serif",Font.BOLD,16));
        cancel.addActionListener(this);
        add(cancel);
        
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new StudentLeave();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            
            String rollno = crollno.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();
            
            String query = "insert into studentleave values('"+rollno+"','"+date+"','"+duration+"')";
            
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Confirmed.");
                setVisible(false);
               
            }catch(Exception a) {
                a.printStackTrace();
            }
            
        }else {
            setVisible(false);
        }
    }
    
}
