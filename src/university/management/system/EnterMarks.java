package university.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.ResultSet;

public class EnterMarks extends JFrame implements ActionListener{
    
    Choice crollno;
    JComboBox cbSemester;
    JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5,tfmarks1,tfmarks2,tfmarks3,tfmarks4,tfmarks5;
    JButton submit,cancel;
    
    EnterMarks() {    
        
        setSize(800,500);
        setLayout(null);
        setLocation(300,150);      
                
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/exam.png"));
        Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(500,50,200,200);
        add(image);
        
        JLabel heading = new JLabel("Enter Marks of student");
        heading.setBounds(50,0,500,40);
        heading.setFont(new Font("serif",Font.BOLD,20));
        add(heading);
        
        JLabel lbrollnumber= new JLabel("Select Roll Number");
        lbrollnumber.setBounds(50,70,150,20);
        add(lbrollnumber);
        
        crollno=new Choice();
        crollno.setBounds(200,70,150,20);
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
        
        JLabel lbSemester= new JLabel("Select Semester");
        lbSemester.setBounds(50,110,150,20);
        add(lbSemester);
        
        String semester[] = { "1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester", "7th Semester", "8th Semester" };
        cbSemester = new JComboBox(semester);
        cbSemester.setBounds(200,110,150,20);
        cbSemester.setBackground(Color.WHITE);
        add(cbSemester);
        
        JLabel lbentersubject= new JLabel("Enter Subject");
        lbentersubject.setBounds(100,150,200,40);
        add(lbentersubject);
        
        JLabel lbentermarks= new JLabel("Enter Marks");
        lbentermarks.setBounds(320,150,200,40);
        add(lbentermarks);
        
        tfsub1 = new JTextField();
        tfsub1.setBounds(50,200,200,20);
        add(tfsub1);
        
        tfsub2 = new JTextField();
        tfsub2.setBounds(50,230,200,20);
        add(tfsub2);
        
        tfsub3 = new JTextField();
        tfsub3.setBounds(50,260,200,20);
        add(tfsub3);
        
        tfsub4 = new JTextField();
        tfsub4.setBounds(50,290,200,20);
        add(tfsub4);
        
        tfsub5 = new JTextField();
        tfsub5.setBounds(50,320,200,20);
        add(tfsub5);
        
        tfmarks1 = new JTextField();
        tfmarks1.setBounds(250,200,200,20);
        add(tfmarks1);
        
        tfmarks2 = new JTextField();
        tfmarks2.setBounds(250,230,200,20);
        add(tfmarks2);
        
        tfmarks3 = new JTextField();
        tfmarks3.setBounds(250,260,200,20);
        add(tfmarks3);
        
        tfmarks4 = new JTextField();
        tfmarks4.setBounds(250,290,200,20);
        add(tfmarks4);
        
        tfmarks5 = new JTextField();
        tfmarks5.setBounds(250,320,200,20);
        add(tfmarks5);
        
        submit = new JButton("Submit");
        submit.setBounds(70,360,150,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("serif",Font.BOLD,16));
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(280,360,150,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("serif",Font.BOLD,16));
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
        
    }
    
    
    
    public static void main(String [] args) {
        new EnterMarks();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            try{
                Conn c=new Conn();
                String query1= "insert into subject values('"+crollno.getSelectedItem()+"', '"+cbSemester.getSelectedItem()+"','"+tfsub1.getText()+"','"+tfsub2.getText()+"','"+tfsub3.getText()+"','"+tfsub4.getText()+"','"+tfsub5.getText()+"' )";
                String query2= "insert into marks values('"+crollno.getSelectedItem()+"', '"+cbSemester.getSelectedItem()+"','"+tfmarks1.getText()+"','"+tfmarks2.getText()+"','"+tfmarks3.getText()+"','"+tfmarks4.getText()+"','"+tfmarks5.getText()+"' )";
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Marks Inserted Successfully");
                setVisible(false);
            }catch (Exception w){
                w.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    
}
