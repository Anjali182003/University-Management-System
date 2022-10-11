package university.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class ExaminationDetails extends JFrame implements ActionListener{
    
    JTextField search;
    JButton submit,cancel;
    JTable table;
    
    ExaminationDetails() {
        setSize(1000,475);
        setLocation(300,100);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Check Result");
        heading.setBounds(80,15,400,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);
        
        search =new JTextField();
        search.setBounds(80,90,200,30);
        search.setFont(new Font("serif",Font.PLAIN,18));
        add(search);
        
        submit = new JButton("Result");
        submit.setBounds(300,90,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("serif",Font.BOLD,16));
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(440,90,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("serif",Font.BOLD,16));
        cancel.addActionListener(this);
        add(cancel);
        
        table = new JTable();
        table.setFont(new Font("serif",Font.PLAIN,16));
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,130,1000,310);
        add(jsp);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me){
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 2).toString());
            }
        });
        
        setVisible(true);
                
    }
    
    public static void main(String[] args) {
        new ExaminationDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit) {
            setVisible(false);
            
            new Marks(search.getText());            
        }else {
            setVisible(false);
        }
    }
    
}
