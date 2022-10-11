
package university.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.sql.ResultSet;

/**
 *
 * @author jaina
 */
public class login extends JFrame implements ActionListener {
    JButton login,cancel;
    JTextField tfusername,tfpassword;
    
    login() {
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lbusername = new JLabel("Username");
        lbusername.setBounds(40,20,100,20);
        add(lbusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150,20,150,20);
        add(tfusername);
        
        JLabel lbpassword = new JLabel("Password");
        lbpassword.setBounds(40,70,100,20);
        add(lbpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150,70,150,20);
        add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("serif",Font.BOLD,16));
        login.addActionListener(this);
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180,140,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("serif",Font.BOLD,16));
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/second.png"));
        Image i2=i1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(350,20,120,120);
        add(image);
     
        
        setSize(600,300);
        setLayout(null);
        setLocation(500,250);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login ) {
            String username=tfusername.getText();
            String password=tfpassword.getText();
            
            String query="select * from login where username='"+username+"'and password='"+password+"'";
            
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                
                if(rs.next()){
                    setVisible(false);
                    new main_frame();
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                    setVisible(false);
                }
                c.s.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if (ae.getSource() == cancel ) {
            setVisible(false);
        }
    }
    
   public static void main(String[] args) {
       new login();
   }
}