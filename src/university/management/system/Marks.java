package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Marks extends JFrame implements ActionListener{
    int m1, m2, m3, m4, m5, total;
    double percentage;
    String rollno, name;
    JButton print, cancel;
    // Parametrised constructor
    Marks(String rollno, String name){
        this.rollno = rollno;
        
        setSize(500, 600);
        setLocation(500, 100);
        setLayout(null);
        
        getContentPane().setBackground(Color.white);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("myIcons/universitylogo.jpg"));   //imageicon is created
        Image i2 = i1.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT);         //scaled image
        ImageIcon i3 = new ImageIcon(i2);       //image is again converted to imageicon as we can't pass image object to the class of JLabel
        JLabel image = new JLabel(i3);           //JLable is used to put anything on the frame
        image.setBounds(5, 0, 110, 110);
        add(image);
        
        JLabel heading = new JLabel("Ramdeobaba University");
        heading.setBounds(140, 20, 500, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        add(heading);
        
        JLabel subheading = new JLabel("Result of Examination 2024");
        subheading.setBounds(145, 60, 500, 20);
        subheading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(subheading);
        
        JLabel lblrollno = new JLabel("Roll Number:  "+ rollno);
        lblrollno.setBounds(60, 120, 500, 20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrollno);
        
        JLabel lblname = new JLabel("Name:  " + name);
        lblname.setBounds(60, 145, 500, 20);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblname);
                
        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(60, 170, 500, 20);
        lblsemester.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblsemester);
        
        JLabel lblsub = new JLabel("Subject");
        lblsub.setBounds(70, 210, 100, 30);
        lblsub.setFont(new Font("Tahoma", Font.PLAIN, 19));
        add(lblsub);
        
        JLabel lblmarks = new JLabel("Marks (Out of 100)");
        lblmarks.setBounds(220, 210, 200, 30);
        lblmarks.setFont(new Font("Tahoma", Font.PLAIN, 19));
        add(lblmarks);
        
        
        JLabel sub1 = new JLabel();
        sub1.setBounds(70, 250, 150, 25);
        sub1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub1);
        
        JLabel marks1 = new JLabel();
        marks1.setBounds(280, 250, 80, 25);
        marks1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(marks1);
        
        JLabel sub2 = new JLabel();
        sub2.setBounds(70, 280, 150, 25);
        sub2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub2);
        
        JLabel marks2 = new JLabel();
        marks2.setBounds(280, 280, 80, 25);
        marks2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(marks2);
        
        JLabel sub3 = new JLabel();
        sub3.setBounds(70, 310, 150, 25);
        sub3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub3);
        
        JLabel marks3 = new JLabel();
        marks3.setBounds(280, 310, 80, 25);
        marks3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(marks3);
        
        JLabel sub4 = new JLabel();
        sub4.setBounds(70, 340, 150, 25);
        sub4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub4);
        
        JLabel marks4 = new JLabel();
        marks4.setBounds(280, 340, 80, 25);
        marks4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(marks4);
        
        JLabel sub5 = new JLabel();
        sub5.setBounds(70, 370, 150, 25);
        sub5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub5);
        
        JLabel marks5 = new JLabel();
        marks5.setBounds(280, 370, 80, 25);
        marks5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(marks5);
        
        JLabel lbltotal = new JLabel();
        lbltotal.setBounds(70, 410, 300, 25);
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbltotal);
        
        JLabel lblpercentage = new JLabel();
        lblpercentage.setBounds(70, 435, 300, 25);
        lblpercentage.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblpercentage);
        
        try{
            Conn c = new Conn();
            
            ResultSet rs1 = c.s.executeQuery("select * from subject where rollno='"+rollno+"'");
            while(rs1.next()){
                sub1.setText(rs1.getString("subject1"));
                sub2.setText(rs1.getString("subject2"));
                sub3.setText(rs1.getString("subject3"));
                sub4.setText(rs1.getString("subject4"));
                sub5.setText(rs1.getString("subject5"));
            }
        
            ResultSet rs2 = c.s.executeQuery("select * from marks where rollno='"+rollno+"'");
            while(rs2.next()){
                //sub1.setText(sub1.getText() + " - " + rs2.getString("marks1"));
                m1 = rs2.getInt("marks1");
                m2 = rs2.getInt("marks2");
                m3 = rs2.getInt("marks3");
                m4 = rs2.getInt("marks4");
                m5 = rs2.getInt("marks5");
                marks1.setText(Integer.toString(m1));
                marks2.setText(Integer.toString(m2));
                marks3.setText(Integer.toString(m3));
                marks4.setText(Integer.toString(m4));
                marks5.setText(Integer.toString(m5));
                //marks2.setText(rs2.getString("marks2"));
                
                lblsemester.setText("Semester:  " + rs2.getString("semester"));
                lbltotal.setText("Total                           " + getTotal(m1, m2, m3, m4, m5) + "/500");
                lblpercentage.setText("Percentage                   " + getTotal(m1, m2, m3, m4, m5)/5.0 + " %");
            }
        
        } catch (Exception e){
            e.printStackTrace();
        }
        
        
        cancel = new JButton("Back");
        cancel.setBounds(260, 495, 140, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    public int getTotal(int m1, int m2, int m3, int m4, int m5){
        return m1+m2+m3+m4+m5;
    }
    
    public static void main(String[] args){
        new Marks("", "");
    }  
}
