package university.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class AddTeacher extends JFrame implements ActionListener{
    
    JTextField tfname,tffname,tfaddress,tfphone,tfemail,tfclass10,tfclass12,tfaadhar;
    JLabel labelempId;
    JDateChooser dcdob;
    JComboBox cbcourse,cbbranch;
    JButton submit,cancel;
    
    Random random = new Random();
    long first4 = Math.abs((random.nextLong() % 9000L) + 1000L);
    
    AddTeacher() {
        
        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        
        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);
        
        JLabel lbname = new JLabel("Name");
        lbname.setBounds(50,150,100,30);
        lbname.setFont(new Font("serif",Font.BOLD,18));
        add(lbname);
        
        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        JLabel lbfname = new JLabel("Father's Name");
        lbfname.setBounds(400,150,200,30);
        lbfname.setFont(new Font("serif",Font.BOLD,18));
        add(lbfname);
        
        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        JLabel lbempId = new JLabel("Employee Id");
        lbempId.setBounds(50,200,200,30);
        lbempId.setFont(new Font("serif",Font.BOLD,18));
        add(lbempId);
        
        labelempId = new JLabel("101" + first4);
        labelempId.setBounds(200,200,200,30);
        labelempId.setFont(new Font("serif",Font.BOLD,18));
        add(labelempId);
        
        JLabel lbdob = new JLabel("Date of Birth");
        lbdob.setBounds(400,200,200,30);
        lbdob.setFont(new Font("serif",Font.BOLD,18));
        add(lbdob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(600,200,150,30);
        add(dcdob);
        
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
        
        tfclass10 = new JTextField();
        tfclass10.setBounds(600,300,150,30);
        add(tfclass10);
        
        JLabel lbclass12 = new JLabel("Class 12th (%)");
        lbclass12.setBounds(50,350,200,30);
        lbclass12.setFont(new Font("serif",Font.BOLD,18));
        add(lbclass12);
        
        tfclass12 = new JTextField();
        tfclass12.setBounds(200,350,150,30);
        add(tfclass12);
        
        JLabel lbaadhar = new JLabel("Aadhar Number");
        lbaadhar.setBounds(400,350,200,30);
        lbaadhar.setFont(new Font("serif",Font.BOLD,18));
        add(lbaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        add(tfaadhar);
        
        JLabel lbcourse = new JLabel("Qualification");
        lbcourse.setBounds(50,400,200,30);
        lbcourse.setFont(new Font("serif",Font.BOLD,18));
        add(lbcourse);
        
        String course[] = {"B.Tech","M.Tech","BBA","MBA","BCA","MSC","BSC","MCA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200,400,150,30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        
        JLabel lbbranch = new JLabel("Department");
        lbbranch.setBounds(400,400,200,30);
        lbbranch.setFont(new Font("serif",Font.BOLD,18));
        add(lbbranch);
        
        String branch[] = {"Computer Science","Electronic","Mechanical","Civil","Information Technology"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(600,400,150,30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
        submit = new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("serif",Font.BOLD,16));
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("serif",Font.BOLD,16));
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new AddTeacher();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            try {
                String name = tfname.getText();
                String fname = tffname.getText();
                String roll = labelempId.getText();
                String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
                String address = tfaddress.getText();
                String phone = tfphone.getText();
                String email = tfemail.getText();
                String class10 = tfclass10.getText();
                String class12 = tfclass12.getText();
                String aadhar = tfaadhar.getText();
                String course = (String) cbcourse.getSelectedItem();
                String branch = (String) cbbranch.getSelectedItem();
                
                String query = "insert into teacher values('"+name+"','"+fname+"','"+roll+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+class10+"','"+class12+"','"+aadhar+"','"+course+"','"+branch+"')";
                
                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
                
                setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
                                 
        }else {
            setVisible(false);
        }
    }
}
