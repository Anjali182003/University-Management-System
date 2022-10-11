package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class StudentFeeForm extends JFrame implements ActionListener {
    
    Choice crollno;
    JComboBox cbcourse,cbbranch,cbSemester;
    JLabel labeltotal;
    JButton update,pay,back;
    
    StudentFeeForm(){
                
        setSize(900,500);
        setLocation(300,100);
        
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,20,250,250);
        add(image);
        
        JLabel lbrollnumber= new JLabel("Select Roll No.");
        lbrollnumber.setBounds(40,60,150,20);
        lbrollnumber.setFont(new Font("serif",Font.BOLD,18));
        add(lbrollnumber);
        
        crollno=new Choice();
        crollno.setBounds(200,60,150,20);
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
        
        JLabel lbname = new JLabel("Name");
        lbname.setBounds(40,100,150,20);
        lbname.setFont(new Font("serif",Font.BOLD,18));
        add(lbname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(200,100,150,20);
        labelname.setFont(new Font("serif",Font.PLAIN,18));
        add(labelname);
        
        JLabel lbfname = new JLabel("Father's Name");
        lbfname.setBounds(40,140,400,20);
        lbfname.setFont(new Font("serif",Font.BOLD,18));
        add(lbfname);
        
        JLabel labelfname = new JLabel();
        labelfname.setBounds(200,140,150,20);
        labelfname.setFont(new Font("serif",Font.PLAIN,18));
        add(labelfname);
        
         try {
            Conn c = new Conn();
            String query = "select * from student where roll='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
               
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        
         crollno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
               try {
            Conn c = new Conn();
            String query = "select * from student where roll='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
               
            }
        }catch (Exception c) {
            c.printStackTrace();
        } 
            }          
        });
         
        JLabel lbcourse = new JLabel("Course");
        lbcourse.setBounds(40,180,150,20);
        lbcourse.setFont(new Font("serif",Font.BOLD,18));
        add(lbcourse);
        
        String course[] = {"B.Tech","M.Tech","BBA","MBA","BCA","MSC","BSC","MCA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200,180,150,20);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        
        JLabel lbbranch = new JLabel("Branch");
        lbbranch.setBounds(40,220,150,20);
        lbbranch.setFont(new Font("serif",Font.BOLD,18));
        add(lbbranch);
        
        String branch[] = {"Computer Science","Electronic","Mechanical","Civil","Information Technology"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(200,220,150,20);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
        JLabel lbSemester= new JLabel("Semester");
        lbSemester.setBounds(40,260,150,20);
        lbSemester.setFont(new Font("serif",Font.BOLD,18));
        add(lbSemester);
        
        String semester[] = { "Semester1", "Semester2", "Semester3", "Semester4", "Semester5", "Semester6", "Semester7", "Semester8" };
        cbSemester = new JComboBox(semester);
        cbSemester.setBounds(200,260,150,20);
        cbSemester.setBackground(Color.WHITE);
        add(cbSemester);
        
        JLabel lbtotal = new JLabel("Total Fee");
        lbtotal.setBounds(40,300,150,20);
        lbtotal.setFont(new Font("serif",Font.BOLD,18));
        add(lbtotal);
        
        labeltotal = new JLabel("");
        labeltotal.setBounds(200,300,150,20);
        labeltotal.setFont(new Font("serif",Font.PLAIN,18));
        add(labeltotal);
        
        update = new JButton("Update");
        update.setBounds(30,380,100,25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("serif",Font.BOLD,16));
        update.addActionListener(this);
        add(update);
        
        pay = new JButton("Pay Fee");
        pay.setBounds(150,380,100,25);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.setFont(new Font("serif",Font.BOLD,16));
        pay.addActionListener(this);
        add(pay);
        
        back = new JButton("Back");
        back.setBounds(270,380,100,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("serif",Font.BOLD,16));
        back.addActionListener(this);
        add(back);
        
        setLayout(null);
        setVisible(true);
    }
    
    public static void main(String arg[]){
        new StudentFeeForm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == update) {
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cbSemester.getSelectedItem();
            
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from fee where course = '"+course+"' ");
                while(rs.next()) {
                    labeltotal.setText(rs.getString(semester));
                }
            }catch(Exception w) {
                w.printStackTrace();
            }
            
        }else if(e.getSource() == pay) {
            
            String rollno = crollno.getSelectedItem();
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cbSemester.getSelectedItem();     
            String branch = (String) cbbranch.getSelectedItem();
            String total = labeltotal.getText();
            
            try {
                Conn c = new Conn();
                String query = "insert into collegeFee values('"+rollno+"','"+course+"','"+branch+"','"+semester+"','"+total+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"College fee submitted successfully.");
                setVisible(false);
            }catch(Exception w) {
                w.printStackTrace();
            }
            
        }else {
            setVisible(false);
        }
        
    }
}
