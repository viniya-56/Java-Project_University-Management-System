package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;   //class used to insert data directly in the table
import java.awt.event.*;

public class StudentLeaveDetails extends JFrame implements ActionListener{
    Choice crollno;     //for dropdown list to select the rollno
    JTable table;
    JButton search, print, cancel;
    
    StudentLeaveDetails(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        crollno = new Choice();
        crollno.setBounds(180, 20, 150, 20);
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
        
        table = new JTable();
        //to add the scroll bar
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 800, 600);
        add(jsp);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from studentLeave");
            table.setModel(DbUtils.resultSetToTableModel(rs));  //to get the data directly in the table                 
        }   catch(Exception e){
            e.printStackTrace();
        }
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
               
        cancel = new JButton("Cancel");
        cancel.setBounds(220, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);
               
        
        setSize(800, 600);
        setLocation(400, 80);        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            //it will give the search results for selected roll no only
            String query = "select * from studentLeave where rollno = '"+crollno.getSelectedItem()+"'";
            
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            
            } catch(Exception e){
            e.printStackTrace();
        }
        } else if(ae.getSource() == print){
            try{
                table.print();  //to print the table            
            } catch(Exception e){
                e.printStackTrace();
            }
        } else{
            setVisible(false);  //cancel button is clicked, hence close the frame
        }   
    }

    public static void main(String[] args){
        new StudentLeaveDetails();
    }
}