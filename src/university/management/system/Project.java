package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener{
    
    Project(){
        setSize(1540, 850);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("myIcons/third.jpg"));   //imageicon is created
        Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);         //scaled image
        ImageIcon i3 = new ImageIcon(i2);       //image is again converted to imageicon as we can't pass image object to the class of JLabel
        JLabel image = new JLabel(i3);          //JLable is used to put anything on the frame
        add(image);

        //Menu bar -> menu -> menu item
        
        JMenuBar mb = new JMenuBar();       //Class to add the menu bar
        
        //New Information
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.black);
        mb.add(newInformation);     //to add the Jmenu on the menu bar
        
        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");  //to add the items to Jmenu
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.setForeground(Color.GRAY);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);    //add the menu item in the jmenu
        
        JMenuItem studentInfo = new JMenuItem("New Student Information");  //to add the items to Jmenu
        studentInfo.setBackground(Color.WHITE);
        studentInfo.setForeground(Color.gray);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);    //add the menu item in the jmenu
        
        //Details
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.black);
        mb.add(details);     //to add the Jmenu on the menu bar
        
        JMenuItem facultydetails = new JMenuItem("View Faculty Details");  //to add the items to Jmenu
        facultydetails.setBackground(Color.WHITE);
        facultydetails.setForeground(Color.gray);
        facultydetails.addActionListener(this);
        details.add(facultydetails);    //add the menu item in the jmenu
        
        JMenuItem studentdetails = new JMenuItem("View Student Details");  //to add the items to Jmenu
        studentdetails.setBackground(Color.WHITE);
        studentdetails.setForeground(Color.gray);
        studentdetails.addActionListener(this);
        details.add(studentdetails);    //add the menu item in the jmenu
        
        //Leave
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.black);
        mb.add(leave);     //to add the Jmenu on the menu bar
        
        JMenuItem facultyleave = new JMenuItem("Faculty Leave");  //to add the items to Jmenu
        facultyleave.setBackground(Color.WHITE);
        facultyleave.setForeground(Color.gray);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);    //add the menu item in the jmenu
        
        JMenuItem studentleave = new JMenuItem("Student Leave");  //to add the items to Jmenu
        studentleave.setBackground(Color.WHITE);
        studentleave.setForeground(Color.gray);
        studentleave.addActionListener(this);
        leave.add(studentleave);    //add the menu item in the jmenu
        
        //Leave Details
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.black);
        mb.add(leaveDetails);     //to add the Jmenu on the menu bar
        
        JMenuItem facultyleaveDetails = new JMenuItem("Faculty Leave Details");  //to add the items to Jmenu
        facultyleaveDetails.setBackground(Color.WHITE);
        facultyleaveDetails.setForeground(Color.gray);
        facultyleaveDetails.addActionListener(this);
        leaveDetails.add(facultyleaveDetails);    //add the menu item in the jmenu
        
        JMenuItem studentleaveDetails = new JMenuItem("Student Leave Details");  //to add the items to Jmenu
        studentleaveDetails.setBackground(Color.WHITE);
        studentleaveDetails.setForeground(Color.gray);
        studentleaveDetails.addActionListener(this);
        leaveDetails.add(studentleaveDetails);    //add the menu item in the jmenu
        
        
        //Exams
        JMenu exams = new JMenu("Examination");
        exams.setForeground(Color.black);
        mb.add(exams);     //to add the Jmenu on the menu bar
        
        JMenuItem examinationDetails = new JMenuItem("Examination Results");  //to add the items to Jmenu
        examinationDetails.setBackground(Color.WHITE);
        examinationDetails.setForeground(Color.gray);
        examinationDetails.addActionListener(this);
        exams.add(examinationDetails);    //add the menu item in the jmenu
        
        JMenuItem enterMarks = new JMenuItem("Enter Marks");  //to add the items to Jmenu
        enterMarks.setBackground(Color.WHITE);
        enterMarks.setForeground(Color.gray);
        enterMarks.addActionListener(this);
        exams.add(enterMarks);    //add the menu item in the jmenu
        
        //Update Information
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.black);
        mb.add(updateInfo);     //to add the Jmenu on the menu bar
        
        JMenuItem updateFacultyInfo = new JMenuItem("Update Faculty Details");  //to add the items to Jmenu
        updateFacultyInfo.setBackground(Color.WHITE);
        updateFacultyInfo.setForeground(Color.gray);
        updateFacultyInfo.addActionListener(this);
        updateInfo.add(updateFacultyInfo);    //add the menu item in the jmenu
        
        JMenuItem updateStudentInfo = new JMenuItem("Update Student Details");  //to add the items to Jmenu
        updateStudentInfo.setBackground(Color.white);
        updateStudentInfo.setForeground(Color.gray);
        updateStudentInfo.addActionListener(this);
        updateInfo.add(updateStudentInfo);    //add the menu item in the jmenu
        
        //Fees
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.black);
        mb.add(fee);     //to add the Jmenu on the menu bar
        
        JMenuItem feeStructure = new JMenuItem("Fee Structure");  //to add the items to Jmenu
        feeStructure.setBackground(Color.WHITE);
        feeStructure.setForeground(Color.gray);
        feeStructure.addActionListener(this);
        fee.add(feeStructure);    //add the menu item in the jmenu
        
        JMenuItem feeForm = new JMenuItem("Student Fee Form");  //to add the items to Jmenu
        feeForm.setBackground(Color.WHITE);
        feeForm.setForeground(Color.gray);
        feeForm.addActionListener(this);
        fee.add(feeForm);    //add the menu item in the jmenu
        
        //Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.black);
        mb.add(utility);     //to add the Jmenu on the menu bar
        
        JMenuItem notepad = new JMenuItem("Notepad");  //to add the items to Jmenu
        notepad.setBackground(Color.WHITE);
        notepad.setForeground(Color.gray);
        notepad.addActionListener(this);
        utility.add(notepad);    //add the menu item in the jmenu
        
        JMenuItem calc = new JMenuItem("Calculator");  //to add the items to Jmenu
        calc.setBackground(Color.WHITE);
        calc.setForeground(Color.gray);
        calc.addActionListener(this);
        utility.add(calc);    //add the menu item in the jmenu
        
        JMenuItem browser = new JMenuItem("Web Browser");  //to add the items to Jmenu
        browser.setBackground(Color.WHITE);
        browser.setForeground(Color.gray);
        browser.addActionListener(this);
        utility.add(browser);   
        
        //About
        JMenu about = new JMenu("About");
        about.setForeground(Color.black);
        mb.add(about);     //to add the Jmenu on the menu bar
        
        JMenuItem ab = new JMenuItem("About");  //to add the items to Jmenu
        ab.setBackground(Color.WHITE);
        ab.setForeground(Color.gray);
        ab.addActionListener(this);
        about.add(ab);    //add the menu item in the jmenu
        
        //Exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.black);
        mb.add(exit);     //to add the Jmenu on the menu bar
        
        JMenuItem ex = new JMenuItem("Exit");  //to add the items to Jmenu
        ex.setBackground(Color.WHITE);
        ex.setForeground(Color.gray);
        ex.addActionListener(this);
        exit.add(ex);    //add the menu item in the jmenu
        
        
        setJMenuBar(mb);
                
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        
        if(msg.equals("Exit")){
            setVisible(false);
        } else if (msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe"); //Runtime is a class               
            }
            catch (Exception e){}
        }
        else if (msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe"); //Runtime is a class              
            }
            catch (Exception e){}
        }
        else if(msg.equals("Web Browser")){
            try{
                Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application/chrome.exe");
            }
            catch (Exception e){}
        }
        else if (msg.equals("New Faculty Information")){
            new AddTeacher();
        }
        else if(msg.equals("New Student Information")){
            new AddStudent();
        }
        else if(msg.equals("View Faculty Details")){
            new TeacherDetails();
        }
        else if(msg.equals("View Student Details")){
            new StudentDetails();
        }
        else if(msg.equals("Faculty Leave")){
            new TeacherLeave();
        }
        else if(msg.equals("Student Leave")){
            new StudentLeave();
        }
        else if(msg.equals("Faculty Leave Details")){
            new TeacherLeaveDetails();
        }
        else if(msg.equals("Student Leave Details")){
            new StudentLeaveDetails();
        }
        else if(msg.equals("Update Faculty Details")){
            new UpdateTeacher();
        }
        else if(msg.equals("Update Student Details")){
            new UpdateStudent();
        }
        else if(msg.equals("Enter Marks")){
            new EnterMarks();
        }
        else if(msg.equals("Examination Results")){
            new ExaminationResults();
        }
        else if(msg.equals("Fee Structure")){
            new FeeStructure();
        }
        else if(msg.equals("About")){
            new About();
        }
        else if(msg.equals("Student Fee Form")){
            new StudentFeeForm();
        }
    }

    public static void main(String[] args){
        new Project();   
    }
}
