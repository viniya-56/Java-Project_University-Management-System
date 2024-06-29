package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;   //class used to insert data directly in the table
import java.awt.event.*;

public class TeacherDetails extends JFrame implements ActionListener{
    Choice cempID;     //for dropdown list to select the rollno
    Choice sortOpt;   // for dropdown list to select the sorting criteria
    JTable table;
    JButton search, print, update, add, cancel, apply;
    
    TeacherDetails(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Employee ID");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        cempID = new Choice();
        cempID.setBounds(180, 20, 150, 20);
        add(cempID);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            
            while(rs.next()){
                cempID.add(rs.getString("empID"));    //all the values from "empID" column will get added to the dropdown cempID
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
        sortOpt.add("Employee ID");
        sortOpt.add("UGC NET score");
        
        table = new JTable();
        //to add the scroll bar
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
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
            String query = "select * from teacher where empID = '"+cempID.getSelectedItem()+"'";
            
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
            new AddTeacher();   //current frame is closed and the new object of AddTeacher class is created to add the teacher details
        } else if(ae.getSource() == update){
            setVisible(false);
            new UpdateTeacher(); //current frame is closed and the new object of UpdateTeacher class is created to update the teacher details       
        } else if (ae.getSource() == apply){
            String query1;
            String selected = sortOpt.getSelectedItem();
            if(selected.equals("UGC NET score")){
                query1 = "select * from teacher order by UGCNETscore desc";
            }
            else if(selected.equals("Employee ID")){
                query1 = "select * from teacher order by empID asc";
            }
            else{
                query1 = "select * from teacher order by name asc";
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
        new TeacherDetails();
    }
}