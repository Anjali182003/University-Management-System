package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class main_frame extends JFrame implements ActionListener{
    main_frame(){
        setSize(1540,850);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/clg.jpg"));
        Image i2=i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(350,20,120,120);
        add(image);
      
       JMenuBar mb=new JMenuBar();
       setJMenuBar(mb);
       
       JMenu newInformation=new JMenu("New Information");
       newInformation.setForeground(Color.blue);
       mb.add(newInformation);
       
       JMenuItem facultyInfo=new JMenuItem("New Faculty Information");
       facultyInfo.setBackground(Color.WHITE);
       facultyInfo.addActionListener(this);
       newInformation.add(facultyInfo);
       
       JMenuItem StudentInfo=new JMenuItem("New Student Information");
      StudentInfo.setBackground(Color.WHITE);
      StudentInfo.addActionListener(this);
       newInformation.add(StudentInfo);
       
       JMenu details=new JMenu("View Details");
       details.setForeground(Color.red);
       mb.add(details);
       
       JMenuItem facultydetails =new JMenuItem("View Faculty Details");
       facultydetails.setBackground(Color.WHITE);
       facultydetails.addActionListener(this);
       details.add(facultydetails);
       
       JMenuItem Studentdetails=new JMenuItem("View Student Details");
      Studentdetails.setBackground(Color.WHITE);
      Studentdetails.addActionListener(this);
       details.add(Studentdetails);
       
       JMenu Leave =new JMenu("Apply Leave");
       Leave.setForeground(Color.blue);
       mb.add(Leave);
       
       JMenuItem facultyLeave =new JMenuItem("Faculty Leave");
       facultyLeave.setBackground(Color.WHITE);
       facultyLeave.addActionListener(this);
       Leave.add(facultyLeave);
       
       JMenuItem StudentLeave=new JMenuItem("Student Leave");
      StudentLeave.setBackground(Color.WHITE);
      StudentLeave.addActionListener(this);
       Leave.add(StudentLeave);
       
        JMenu LeaveDetails =new JMenu("Leave Details");
       LeaveDetails.setForeground(Color.red);
       mb.add(LeaveDetails);
       
       JMenuItem facultyLeaveDetails =new JMenuItem("Faculty Leave Details");
       facultyLeaveDetails.setBackground(Color.WHITE);
       facultyLeaveDetails.addActionListener(this);
       LeaveDetails.add(facultyLeaveDetails);
       
       JMenuItem StudentLeaveDetails=new JMenuItem("Student Leave Details");
      StudentLeaveDetails.setBackground(Color.WHITE);
      StudentLeaveDetails.addActionListener(this);
       LeaveDetails.add(StudentLeaveDetails);
       
       JMenu exam =new JMenu(" Examination ");
       exam.setForeground(Color.blue);
       mb.add(exam);
       
       JMenuItem ExaminationDetails =new JMenuItem("Examination Result");
       ExaminationDetails.setBackground(Color.WHITE);
       ExaminationDetails.addActionListener(this);
       exam.add(ExaminationDetails);
       
       JMenuItem EnterMarks=new JMenuItem("Enter Marks");
      EnterMarks.setBackground(Color.WHITE);
      EnterMarks.addActionListener(this);
       exam.add(EnterMarks);
       
       JMenu UpdateInformation =new JMenu("Update Details");
       UpdateInformation.setForeground(Color.red);
       mb.add(UpdateInformation);
       
       JMenuItem UpdateFacultyInformation =new JMenuItem("Update faculty Details");
       UpdateFacultyInformation.setBackground(Color.WHITE);
       UpdateFacultyInformation.addActionListener(this);
       UpdateInformation.add(UpdateFacultyInformation);
       
       JMenuItem UpdateStudentInformation=new JMenuItem("Update Student Details");
      UpdateStudentInformation.setBackground(Color.WHITE);
      UpdateStudentInformation.addActionListener(this);
       UpdateInformation.add(UpdateStudentInformation);
       
       JMenu fee =new JMenu("Fee Details");
       fee.setForeground(Color.blue);
       mb.add(fee);
       
       JMenuItem feeStructure =new JMenuItem("Fee Structure");
       feeStructure.setBackground(Color.WHITE);
       feeStructure.addActionListener(this);
       fee.add(feeStructure);
       
       JMenuItem feeForm=new JMenuItem("Student Fee Form");
      feeForm.setBackground(Color.WHITE);
      feeForm.addActionListener(this);
       fee.add(feeForm);
       
       JMenu utility =new JMenu("Utility");
       utility.setForeground(Color.red);
       mb.add(utility);
       
       JMenuItem notepad =new JMenuItem("Notepad");
       notepad.setBackground(Color.WHITE);
      notepad.addActionListener(this);
       utility.add(notepad);
       
       JMenuItem Calculator =new JMenuItem("Calculator");
       notepad.setBackground(Color.WHITE);
       Calculator.addActionListener(this);
       utility.add(Calculator);
       
       JMenu about =new JMenu("About");
       about.setForeground(Color.blue);
       mb.add(about);
       
       JMenuItem ab =new JMenuItem("About Us");
       ab.setBackground(Color.WHITE);
       ab.addActionListener(this);
       about.add(ab);
       
       JMenu exit =new JMenu("Exit");
       exit.setForeground(Color.RED);
       mb.add(exit);
       
       JMenuItem ex =new JMenuItem("Exit");
       ex.setBackground(Color.WHITE);
       ex.addActionListener(this);
       exit.add(ex);
       
     setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        String msg=ae.getActionCommand();
        if(msg.equals("Exit")){
            setVisible(false);
        }else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");          
            }catch(Exception e){
                
            }
        }else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");          
            }catch(Exception e){
                
            }
        }else if(msg.equals("New Faculty Information")){
            new AddTeacher();
        }else if(msg.equals("New Student Information")){
            new AddStudent();
        }else if(msg.equals("View Faculty Details")){
            new TeacherDetails();
        }else if(msg.equals("View Student Details")){
            new StudentDetails();
        }else if(msg.equals("Faculty Leave")){
            new TeacherLeave();
        }else if(msg.equals("Student Leave")){
            new StudentLeave();
        }else if(msg.equals("Faculty Leave Details")){
            new TeacherLeaveDetails();
        }else if(msg.equals("Student Leave Details")){
            new StudentLeaveDetails();
        }else if(msg.equals("Update faculty Details")){
            new UpdateTeacher();
        }else if(msg.equals("Update Student Details")){
            new UpdateStudent();
        }else if(msg.equals("Enter Marks")){
            new EnterMarks();
        }else if(msg.equals("Examination Result")){
            new ExaminationDetails();        
        }else if(msg.equals("Fee Structure")){
            new FeeStructure();        
        }else if(msg.equals("About Us")){
            new About();        
        }else if(msg.equals("Student Fee Form")){
            new StudentFeeForm();        
        }
   }
    public static void main(String[] args){
        new main_frame();
    }
}
