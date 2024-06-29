package university.management.system;

import javax.swing.*;
import java.awt.*;
import  java.awt.event.*;
import java.sql.*;

public class UpdateTeacher extends JFrame implements ActionListener{
    JTextField tfaddress, tfphone, tfemail, tfqualification, tfdept;
    JButton update, cancel;
    JLabel labelempID;
    Choice cempID;
    
    UpdateTeacher(){
        setSize(900, 650);
        setLocation(350, 50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);
        
        JLabel lblempID = new JLabel("Select Employee ID");
        lblempID.setBounds(50, 100, 200, 20);
        lblempID.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempID);
        
        cempID = new Choice();
        cempID.setBounds(250, 100, 200, 20);
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
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 200, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);
        
        JLabel labelName = new JLabel();
        labelName.setBounds(200, 150, 150, 30);
        labelName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelName);
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);
        
        JLabel labelfName = new JLabel();
        labelfName.setBounds(600, 150, 150, 30);
        labelfName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelfName);
        
        lblempID = new JLabel("Employee ID");
        lblempID.setBounds(50, 200, 200, 30);
        lblempID.setFont(new Font("serif", Font.BOLD, 20));
        add(lblempID);
                
        labelempID = new JLabel();
        labelempID.setBounds(200, 200, 200, 30);
        labelempID.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelempID);   
        
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);
        
        JLabel labeldob = new JLabel(); 
        labeldob.setBounds(600, 200, 150, 30);
        labeldob.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labeldob);
        
        //to add Address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 500, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        //to add Phone number
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 500, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        //to add email ID
        JLabel lblemail = new JLabel("Email ID");
        lblemail.setBounds(50, 300, 500, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        //Aadhar number
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(400, 300, 500, 30);
        lblaadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(lblaadhar);
        
        JLabel labelaadhar = new JLabel();
        labelaadhar.setBounds(600, 300, 150, 30);
        labelaadhar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelaadhar);
        
        // PAN details
        JLabel lblpan = new JLabel("PAN Details");
        lblpan.setBounds(50, 350, 500, 30);
        lblpan.setFont(new Font("serif", Font.BOLD, 20));
        add(lblpan);
        
        JLabel labelpan = new JLabel();
        labelpan.setBounds(200, 350, 150, 30);
        labelpan.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelpan);
        
        // UGC-NET score
        JLabel lblscore = new JLabel("UGC-NET Score");
        lblscore.setBounds(400, 350, 500, 30);
        lblscore.setFont(new Font("serif", Font.BOLD, 20));
        add(lblscore);
        
        JLabel labelscore = new JLabel();
        labelscore.setBounds(600, 350, 150, 30);
        labelscore.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelscore);

        JLabel lblqualification = new JLabel("Qualification");
        lblqualification.setBounds(50, 400, 500, 30);
        lblqualification.setFont(new Font("serif", Font.BOLD, 20));
        add(lblqualification);
        
        tfqualification = new JTextField();
        tfqualification.setBounds(200, 400, 150, 30);
        add(tfqualification);
        
        JLabel lbldept = new JLabel("Department");
        lbldept.setBounds(400, 400, 500, 30);
        lbldept.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldept);
        
        tfdept = new JTextField();
        tfdept.setBounds(600, 400, 150, 30);
        add(tfdept);
        
        try{
            Conn c = new Conn();
            String query = "select * from teacher where empID ='"+cempID.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){   //to check whether the data is present or not
                labelempID.setText(rs.getString("empID"));
                labelName.setText(rs.getString("name"));
                labelfName.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelaadhar.setText(rs.getString("aadhar"));
                labelpan.setText(rs.getString("pan"));
                labelscore.setText(rs.getString("UGCNETscore"));
                tfqualification.setText(rs.getString("qualification"));
                tfdept.setText(rs.getString("department"));
                
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        cempID.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c = new Conn();
                    String query = "select * from teacher where empID='"+cempID.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
            
                    while(rs.next()){   //to check whether the data is present or not
                        labelempID.setText(rs.getString("empID"));
                        labelName.setText(rs.getString("name"));
                        labelfName.setText(rs.getString("fname"));
                        labeldob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        labelaadhar.setText(rs.getString("aadhar"));
                        labelpan.setText(rs.getString("pan"));
                        labelscore.setText(rs.getString("UGCNETscore"));
                        tfqualification.setText(rs.getString("qualification"));
                        tfdept.setText(rs.getString("department"));
                    }
                } catch(Exception e){
                    e.printStackTrace();
                }           
            }      
        });
        
        update = new JButton("Update");
        update.setBounds(250, 500, 120, 35);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(update);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 500, 120, 35);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        //Get the values to store after update is clicked
        //getText is used to get the value
        if(ae.getSource() == update){
            String empID = labelempID.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String qualification = tfqualification.getText();
            String dept = tfdept.getText();
            
            try{
                String query = "update teacher set address= '"+address+"', phone= '"+phone+"', email= '"+email+"', qualification = '"+qualification+"', department= '"+dept+"' where empID='"+cempID.getSelectedItem()+"'";           
                        //'' - single inverted comma is used as the datatype of variable is varchar
                
                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Teacher Details Updated Successfully");
                setVisible(false);              
                        
            } catch (Exception e){
                e.printStackTrace();            
            }
        } else{
            //cancel button is pressed, close the window
            setVisible(false);
        }
    }  

    public static void main(String[] args){
        new UpdateTeacher();
    }
}