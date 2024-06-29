package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;   //importing package to add the calender
import java.awt.event.*;

public class StudentLeave extends JFrame implements ActionListener{
    Choice crollno, ctime;
    JDateChooser dcdate;
    JTextField tfreason;
    JButton submit, cancel;
        
    StudentLeave(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Apply Leave (Student)");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tahuma", Font.BOLD, 20));
        add(heading);
        
        JLabel lblrollno = new JLabel("Search by Roll Number");
        lblrollno.setBounds(60, 100, 200, 20);
        lblrollno.setFont(new Font("Tahuma", Font.PLAIN, 16));
        add(lblrollno);
        
        crollno = new Choice();
        crollno.setBounds(60, 130, 200, 20);
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
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 165, 200, 20);
        lbldate.setFont(new Font("Tahuma", Font.PLAIN, 16));
        add(lbldate);
        
        dcdate = new JDateChooser(); //object of class dcdate: date chooser
        dcdate.setBounds(60, 195, 200, 25);
        add(dcdate);
        
        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60, 230, 200, 20);
        lbltime.setFont(new Font("Tahuma", Font.PLAIN, 16));
        add(lbltime);
        
        ctime = new Choice();
        ctime.setBounds(60, 260, 200, 20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);
        
        JLabel lblreason = new JLabel("Reason");
        lblreason.setBounds(60, 295, 200, 20);
        lblreason.setFont(new Font("Tahuma", Font.PLAIN, 16));
        add(lblreason);
        
        tfreason = new JTextField();
        tfreason.setBounds(60, 325, 225, 40);
        add(tfreason);
        
        submit = new JButton("Submit");
        submit.setBounds(60, 400, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(200, 400, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        
        setSize(500, 550);
        setLocation(500, 100);
        setVisible(true);
    }
    
    //we have to overwrite the abstract method
    public void actionPerformed(ActionEvent ae){
        //Get the values to store after submit is clicked
        //getText is used to get the value
        if(ae.getSource() == submit){
            String rollno = crollno.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();
            String reason = tfreason.getText();
            
            
            String query = "insert into studentleave values('"+rollno+"', '"+date+"', '"+duration+"', '"+reason+"')";
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);                
            } catch(Exception e){
                e.printStackTrace();
            }
            
        } else{
            //cancel button is pressed, close the window
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new StudentLeave();
    }
}
