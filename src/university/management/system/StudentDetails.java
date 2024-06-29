package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;   //class used to insert data directly in the table
import java.awt.event.*;

public class StudentDetails extends JFrame implements ActionListener{
    Choice crollno;     //for dropdown list to select the rollno
    Choice sortOpt;
    JTable table;
    JButton search, print, update, add, cancel, apply;
    
    StudentDetails(){
        
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
        
        // adding sorting criteria
        JLabel head2 = new JLabel("Sort by");
        head2.setBounds(550, 20, 60, 20);
        add(head2);
        
        sortOpt = new Choice();
        sortOpt.setBounds(610, 20, 150, 20);
        add(sortOpt);
        
        // adding sorting criteria option to the drop down list
        sortOpt.add("Name");
        sortOpt.add("Roll Number");
        sortOpt.add("Class-X Marks");
        sortOpt.add("Class-XII Marks");
        
        
        table = new JTable();
        //to add the scroll bar
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
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
        
        add = new JButton("Add");
        add.setBounds(220, 70, 80, 20);
        add.addActionListener(this);
        add(add);
        
        update = new JButton("Update");
        update.setBounds(320, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);         
        
        // to apply the sort
        apply = new JButton("Apply");
        apply.setBounds(550, 70, 80, 20);
        apply.addActionListener(this);
        add(apply);
        
        setSize(900, 700);
        setLocation(300, 80);        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";
            
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
        } else if(ae.getSource() == add){
            setVisible(false);
            new AddStudent();   //current frame is closed and the new object of AddStudent class is created to add the student details
        } else if(ae.getSource() == update){
            setVisible(false);
            new UpdateStudent(); //current frame is closed and the new object of UpdateStudent class is created to update the student details       
        } else if(ae.getSource() == apply){
            String query1;
            String selected = sortOpt.getSelectedItem();
            if(selected.equals("Roll Number")){
                query1 = "select * from student order by rollno asc";
            }
            else if(selected.equals("Class-X Marks")){
                query1 = "select * from student order by class_x desc";
            }
            else if(selected.equals("Class-XII Marks")){
                query1 = "select * from student order by class_xii desc";
            }
            else{
                query1 = "select * from student order by name";
            }
            
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query1);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch(Exception e){
                e.printStackTrace();
            }
        } 
        
        else{
            setVisible(false);  //cancel button is clicked, hence close the frame
        }   
    }
    
    public static void main(String[] args){
        new StudentDetails();
    }
}