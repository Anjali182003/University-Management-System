package university.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import javax.swing.*;
import java.sql.ResultSet;

public class UpdateStudent extends JFrame implements ActionListener{
    
    JTextField tfaddress,tfphone,tfemail,tfcourse,tfbranch;
    JLabel labelroll;
    JButton update,cancel;
    Choice crollno;
   
    UpdateStudent() {
        
        setSize(900,650);
        setLocation(350,50);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);
        
        JLabel lbrollnumber= new JLabel("Select Roll Number");
        lbrollnumber.setBounds(50,100,200,20);
        lbrollnumber.setFont(new Font("serif",Font.PLAIN,18));
        add(lbrollnumber);
        
        crollno=new Choice();
        crollno.setBounds(250,100,200,20);
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
        lbname.setBounds(50,150,100,30);
        lbname.setFont(new Font("serif",Font.BOLD,18));
        add(lbname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(200,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,18));
        add(labelname);
        
        JLabel lbfname = new JLabel("Father's Name");
        lbfname.setBounds(400,150,200,30);
        lbfname.setFont(new Font("serif",Font.BOLD,18));
        add(lbfname);
        
        JLabel labelfname = new JLabel();
        labelfname.setBounds(600,150,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,18));
        add(labelfname);
        
        JLabel lbroll = new JLabel("Roll Number");
        lbroll.setBounds(50,200,200,30);
        lbroll.setFont(new Font("serif",Font.BOLD,18));
        add(lbroll);
        
        labelroll = new JLabel();
        labelroll.setBounds(200,200,200,30);
        labelroll.setFont(new Font("serif",Font.PLAIN,18));
        add(labelroll);
        
        JLabel lbdob = new JLabel("Date of Birth");
        lbdob.setBounds(400,200,200,30);
        lbdob.setFont(new Font("serif",Font.BOLD,18));
        add(lbdob);
        
        JLabel labeldob = new JLabel();
        labeldob.setBounds(600,200,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,18));
        add(labeldob);
        
        JLabel lbaddress = new JLabel("Address");
        lbaddress.setBounds(50,250,200,30);
        lbaddress.setFont(new Font("serif",Font.BOLD,18));
        add(lbaddress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        JLabel lbphone = new JLabel("Phone Number");
        lbphone.setBounds(400,250,200,30);
        lbphone.setFont(new Font("serif",Font.BOLD,18));
        add(lbphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
        
        JLabel lbemail = new JLabel("Email Id");
        lbemail.setBounds(50,300,200,30);
        lbemail.setFont(new Font("serif",Font.BOLD,18));
        add(lbemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        JLabel lbclass10 = new JLabel("Class 10th (%)");
        lbclass10.setBounds(400,300,200,30);
        lbclass10.setFont(new Font("serif",Font.BOLD,18));
        add(lbclass10);
        
        JLabel labelclass10 = new JLabel();
        labelclass10.setBounds(600,300,150,30);
        labelclass10.setFont(new Font("serif",Font.PLAIN,18));
        add(labelclass10);
        
        JLabel lbclass12 = new JLabel("Class 12th (%)");
        lbclass12.setBounds(50,350,200,30);
        lbclass12.setFont(new Font("serif",Font.BOLD,18));
        add(lbclass12);
        
        JLabel labelclass12 = new JLabel();
        labelclass12.setBounds(200,350,150,30);
        labelclass12.setFont(new Font("serif",Font.PLAIN,18));
        add(labelclass12);
        
        JLabel lbaadhar = new JLabel("Aadhar Number");
        lbaadhar.setBounds(400,350,200,30);
        lbaadhar.setFont(new Font("serif",Font.BOLD,18));
        add(lbaadhar);
        
        JLabel labelaadhar = new JLabel();
        labelaadhar.setBounds(600,350,150,30);
        labelaadhar.setFont(new Font("serif",Font.PLAIN,18));
        add(labelaadhar);
        
        JLabel lbcourse = new JLabel("Course");
        lbcourse.setBounds(50,400,200,30);
        lbcourse.setFont(new Font("serif",Font.BOLD,18));
        add(lbcourse);
        
        tfcourse = new JTextField();
        tfcourse.setBounds(200,400,150,30);
        add(tfcourse);
        
        JLabel lbbranch = new JLabel("Branch");
        lbbranch.setBounds(400,400,200,30);
        lbbranch.setFont(new Font("serif",Font.BOLD,18));
        add(lbbranch);
                
        tfbranch = new JTextField();
        tfbranch.setBounds(600,400,150,30);
        tfbranch.setBackground(Color.WHITE);
        add(tfbranch);
        
        try {
            Conn c = new Conn();
            String query = "select * from student where roll='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelclass10.setText(rs.getString("class10"));
                labelclass12.setText(rs.getString("class12"));
                labelaadhar.setText(rs.getString("aadhar"));
                labelroll.setText(rs.getString("roll"));
                tfcourse.setText(rs.getString("course"));
                tfbranch.setText(rs.getString("branch"));
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
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelclass10.setText(rs.getString("class10"));
                labelclass12.setText(rs.getString("class12"));
                labelaadhar.setText(rs.getString("aadhar"));
                labelroll.setText(rs.getString("roll"));
                tfcourse.setText(rs.getString("course"));
                tfbranch.setText(rs.getString("branch"));
            }
        }catch (Exception c) {
            c.printStackTrace();
        } 
            }          
        });
        
        update = new JButton("Update");
        update.setBounds(250,500,120,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("serif",Font.BOLD,16));
        update.addActionListener(this);
        add(update);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450,500,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("serif",Font.BOLD,16));
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            String rollno = labelroll.getText();
                String address = tfaddress.getText();
                String phone = tfphone.getText();
                String email = tfemail.getText();
                String course = tfcourse.getText();
                String branch = tfbranch.getText();
            try {            
               String query = "update student set address='"+address+"', phone='"+phone+"', email='"+email+"',course='"+course+"',branch='"+branch+"' where roll='"+rollno+"' ";
               Conn c = new Conn();
               c.s.executeUpdate(query);
               
               JOptionPane.showMessageDialog(null, "Student Details Updated Successful");                              
               setVisible(false);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
                                 
        }else {
            setVisible(false);
        }
    }
     public static void main(String[] args) {
       new UpdateStudent();
   }
}
