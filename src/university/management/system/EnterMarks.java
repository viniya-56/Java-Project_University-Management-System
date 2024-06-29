package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class EnterMarks extends JFrame implements ActionListener{
    
    Choice crollno;
    JComboBox  cbsemester;
    JTextField tfSub1, tfSub2, tfSub3, tfSub4, tfSub5, tfMarks1, tfMarks2, tfMarks3, tfMarks4, tfMarks5;
    JButton submit, cancel;        
    
    EnterMarks(){
        setSize(1000, 500);
        setLocation(300,150);
        setLayout(null);
        
        getContentPane().setBackground(Color.white);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("myIcons/exam.jpg"));   //imageicon is created
        Image i2 = i1.getImage().getScaledInstance(400, 280, Image.SCALE_DEFAULT);         //scaled image
        ImageIcon i3 = new ImageIcon(i2);       //image is again converted to imageicon as we can't pass image object to the class of JLabel
        JLabel image = new JLabel(i3);           //JLable is used to put anything on the frame
        image.setBounds(520, 80, 400, 280);
        add(image);
        
        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);
        
        JLabel lblrollno = new JLabel("Select Roll Number");
        lblrollno.setBounds(50, 70, 150, 20);
        add(lblrollno);
        
        crollno = new Choice();
        crollno.setBounds(200, 70, 150, 20);
        add(crollno);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            
            while(rs.next()){
                crollno.add(rs.getString("rollno"));    //all the values from "rollno" column will get added to the dropdown crollno
            }       
        }   catch(Exception e){
            e.printStackTrace();
        }  
        
        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(50, 110, 150, 20);
        add(lblsemester);
        
        String semester[] = {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester", "7th Semester", "8th Semester"};
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(200, 110, 150, 20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
        JLabel lblenterSubject = new JLabel("Enter Subject");
        lblenterSubject.setBounds(100, 160, 200, 15);
        add(lblenterSubject);

        JLabel lblenterMarks = new JLabel("Enter Marks");
        lblenterMarks.setBounds(320, 150, 200, 15);
        add(lblenterMarks);
        
        JLabel lbloutOf = new JLabel("(Out of 100)");
        lbloutOf.setBounds(320, 165, 200, 15);
        add(lbloutOf);

        tfSub1 = new JTextField();
        tfSub1.setBounds(50, 200, 200, 20);
        add(tfSub1);
        tfMarks1 = new JTextField();
        tfMarks1.setBounds(305, 200, 100, 20);
        add(tfMarks1);
        
        tfSub2 = new JTextField();
        tfSub2.setBounds(50, 230, 200, 20);
        add(tfSub2);
        tfMarks2 = new JTextField();
        tfMarks2.setBounds(305, 230, 100, 20);
        add(tfMarks2);
        
        tfSub3 = new JTextField();
        tfSub3.setBounds(50, 260, 200, 20);
        add(tfSub3);
        tfMarks3 = new JTextField();
        tfMarks3.setBounds(305, 260, 100, 20);
        add(tfMarks3);
        
        tfSub4 = new JTextField();
        tfSub4.setBounds(50, 290, 200, 20);
        add(tfSub4);
        tfMarks4 = new JTextField();
        tfMarks4.setBounds(305, 290, 100, 20);
        add(tfMarks4);
        
        tfSub5 = new JTextField();
        tfSub5.setBounds(50, 320, 200, 20);
        add(tfSub5);
        tfMarks5 = new JTextField();
        tfMarks5.setBounds(305, 320, 100, 20);
        add(tfMarks5);
        
        submit = new JButton("Submit");
        submit.setBounds(75, 380, 150, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Back");
        cancel.setBounds(280, 380, 150, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);    
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            try{
                Conn c = new Conn();
                
                String query1 = "insert into subject values('"+crollno.getSelectedItem()+"' , '"+cbsemester.getSelectedItem()+"', '"+tfSub1.getText()+"', '"+tfSub2.getText()+"', '"+tfSub3.getText()+"', '"+tfSub4.getText()+"', '"+tfSub5.getText()+"')";
                String query2 = "insert into marks values('"+crollno.getSelectedItem()+"' , '"+cbsemester.getSelectedItem()+"', '"+tfMarks1.getText()+"', '"+tfMarks2.getText()+"', '"+tfMarks3.getText()+"', '"+tfMarks4.getText()+"', '"+tfMarks5.getText()+"')";
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
            
                JOptionPane.showMessageDialog(null,"Marks Inserted Successfully!");
                setVisible(false);
            } catch(Exception e){
                e.getStackTrace();            
            }
            
        } else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new EnterMarks();
    }
}
